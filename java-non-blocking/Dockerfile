FROM openjdk:17-alpine

COPY ./target/java-non-blocking-0.0.1-SNAPSHOT.jar /opt/app.jar
WORKDIR . /opt

RUN apk update \
    apk add maven

ENTRYPOINT [ "java", "-jar", "app.jar" ]
EXPOSE 8080