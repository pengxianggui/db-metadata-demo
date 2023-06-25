FROM pengxg/java8-skywalking

VOLUME /tmp
VOLUME /opt/www/db-meta-serve

COPY docker-entrypoint.sh docker-entrypoint.sh
COPY target/server-*-SNAPSHOT.jar /app/app.jar

RUN chmod a+x docker-entrypoint.sh
ENTRYPOINT ["/docker-entrypoint.sh"]
