FROM tomcat:jdk8

MAINTAINER shivangiPandey

ENV MYSQL_DATABASE=demoapp \
    MYSQL_ROOT_PASSWORD=root@123

COPY target/DemoProject*.war /usr/local/tomcat/webapps/


EXPOSE 8080
