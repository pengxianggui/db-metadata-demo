FROM registry.cn-hangzhou.aliyuncs.com/dbmeta/nginx:1.17.0-alpine-perl
RUN rm /etc/nginx/conf.d/default.conf
COPY site.template /etc/nginx/conf.d/
CMD envsubst '${API_URL}' < /etc/nginx/conf.d/site.template > /etc/nginx/conf.d/default.conf && nginx -g 'daemon off;'
COPY dist/  /usr/share/nginx/html/
