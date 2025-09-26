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

    # SICUREZZA: Rate limiting per login e API
    location ~ ^/(login|api) {
        limit_req zone=login burst=5 nodelay;
        limit_req zone=api burst=10 nodelay;
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
