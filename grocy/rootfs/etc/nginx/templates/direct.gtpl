server {
    {{ if not .ssl }}
    listen 80 default_server;
    {{ else }}
    listen 80 default_server ssl http2;
    {{ end }}

    include /etc/nginx/includes/server_params.conf;

    {{ if .ssl }}
    include /etc/nginx/includes/ssl_params.conf;

    ssl_certificate /ssl/{{ .certfile }};
    ssl_certificate_key /ssl/{{ .keyfile }};
    {{ end }}

    # SICUREZZA: Rate limiting per file statici (più permissivo)
    location ~* \.(css|js|png|jpg|jpeg|gif|ico|svg|woff|woff2|ttf|eot)$ {
        limit_req zone=static burst=20 nodelay;
        expires 1y;
        add_header Cache-Control "public, immutable";
    }
    
    # SICUREZZA: Rate limiting per login e API
    location ~ ^/(login|api) {
        limit_req zone=login burst=5 nodelay;
        limit_req zone=api burst=10 nodelay;
    }
    
    # SICUREZZA: Gestione API per Direct - tutte le API vanno a PHP
    location ~ ^/api/ {
        limit_req zone=api burst=10 nodelay;
        fastcgi_pass 127.0.0.1:9001;
        fastcgi_read_timeout 300;
        fastcgi_split_path_info ^(.+\.php)(/.+)$;
        fastcgi_index index.php;
        fastcgi_param SCRIPT_FILENAME $document_root/index.php;
        fastcgi_param REQUEST_URI $request_uri;
        fastcgi_param QUERY_STRING $query_string;
        include /etc/nginx/includes/fastcgi_params.conf;
    }

    location ~ .php$ {
        fastcgi_pass 127.0.0.1:9001;
        # SICUREZZA: Ridurre timeout da 900 a 300 secondi
        fastcgi_read_timeout 300;
        fastcgi_split_path_info ^(.+\.php)(/.+)$;
        fastcgi_index index.php;
        fastcgi_param SCRIPT_FILENAME $document_root$fastcgi_script_name;
        include /etc/nginx/includes/fastcgi_params.conf;
    }
}
