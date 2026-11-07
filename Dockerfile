FROM nginx:alpine

RUN mkdir -p /tmp/nginx/client_body /tmp/nginx/proxy /tmp/nginx/fastcgi /tmp/nginx/uwsgi /tmp/nginx/scgi \
    && chmod -R 777 /tmp/nginx

COPY nginx.conf /etc/nginx/nginx.conf
COPY index.html /usr/share/nginx/html/index.html

EXPOSE 3000

ENTRYPOINT ["nginx"]
CMD ["-g", "daemon off;"]
