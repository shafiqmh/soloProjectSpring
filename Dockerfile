FROM openjdk:8-jdk-alpine

COPY target/firstspringapplication-1.0-SNAPSHOT.jar /usr/app/

ENTRYPOINT ["java", "-jar", "/usr/app/firstspringapplication-1.0-SNAPSHOT.jar"]
