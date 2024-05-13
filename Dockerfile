FROM openjdk:8

RUN rm -rf /etc/localtime && echo 'Asia/Shanghai' >/etc/timezone

VOLUME /etc/zhishuyun/conf
VOLUME /var/lib/zhishuyun

ARG ADMIN_PASSWORD='admin123'
ARG ACTIVE_ENV='docker'
ARG LOG_LEVEL='info'

COPY lucene-yun-backend/lucene-yun-main/build/libs/zhishuyun.jar /opt/zhishuyun/zhishuyun.jar
COPY lucene-yun-backend/lucene-yun-main/src/main/resources/application-docker.yml /etc/zhishuyun/conf/
COPY ./resources/jdbc/system /var/lib/zhishuyun/jdbc/system

EXPOSE 8080

ENV ADMIN_PASSWORD=${ADMIN_PASSWORD}
ENV ACTIVE_ENV=${ACTIVE_ENV}
ENV LOG_LEVEL=${LOG_LEVEL}

CMD java -jar /opt/zhishuyun/zhishuyun.jar --logging.level.root=${LOG_LEVEL} --spring.profiles.active=${ACTIVE_ENV} --isx-app.admin-passwd=${ADMIN_PASSWORD} --spring.config.additional-location=/etc/zhishuyun/conf/