# syntax=docker/dockerfile:1

FROM adoptopenjdk:11-jre-hotspot

WORKDIR /app

COPY target/java-bank-1.0.jar ./

CMD ["java", "-jar", "java-bank-1.0.jar"]