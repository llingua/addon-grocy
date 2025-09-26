server {
    listen {{ .interface }}:8099 default_server;

    include /etc/nginx/includes/server_params_ingress.conf;

    # SICUREZZA: Accesso limitato a Home Assistant
    allow   172.30.32.2;
    deny    all;
    
    # SICUREZZA: Rate limiting per ingress (più permissivo per file statici)
    location ~* \.(css|js|png|jpg|jpeg|gif|ico|svg|woff|woff2|ttf|eot)$ {
        limit_req zone=static burst=20 nodelay;
        expires 1y;
        add_header Cache-Control "public, immutable";
    }
    
    location ~ ^/(login|api) {
        limit_req zone=login burst=5 nodelay;
        limit_req zone=api burst=10 nodelay;
    }

    # SICUREZZA: Gestione API per Ingress - tutte le API vanno a PHP
    location ~ ^/api/ {
        limit_req zone=api burst=10 nodelay;
        fastcgi_pass 127.0.0.1:9002;
        fastcgi_read_timeout 300;
        fastcgi_split_path_info ^(.+\.php)(/.+)$;
        fastcgi_index index.php;
        
        {{ if .grocy_user }}
        fastcgi_param GROCY_AUTH_CLASS "Grocy\Middleware\ReverseProxyAuthMiddleware";
        fastcgi_param GROCY_REVERSE_PROXY_AUTH_HEADER REMOTE_USER;
        fastcgi_param HTTP_REMOTE_USER {{ .grocy_user }};
        {{ end }}
        
        fastcgi_param SCRIPT_FILENAME $document_root/index.php;
        include /etc/nginx/includes/fastcgi_params.conf;
    }

    location ~ .php$ {
        fastcgi_pass 127.0.0.1:9002;
        # SICUREZZA: Ridurre timeout da 900 a 300 secondi
        fastcgi_read_timeout 300;
        fastcgi_split_path_info ^(.+\.php)(/.+)$;
        fastcgi_index index.php;

        {{ if .grocy_user }}
        # SICUREZZA: Autenticazione sicura per ingress
        fastcgi_param GROCY_AUTH_CLASS "Grocy\Middleware\ReverseProxyAuthMiddleware";
        fastcgi_param GROCY_REVERSE_PROXY_AUTH_HEADER REMOTE_USER;
        fastcgi_param HTTP_REMOTE_USER {{ .grocy_user }};
        {{ end }}

        fastcgi_param SCRIPT_FILENAME $document_root$fastcgi_script_name;
        include /etc/nginx/includes/fastcgi_params.conf;
    }
}
