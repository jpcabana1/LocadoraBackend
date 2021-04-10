FROM openjdk:11.0.9
EXPOSE 8080
VOLUME /tmp

ADD build/libs/restfulApi-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]