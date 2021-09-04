# syntax=docker/dockerfile:1

FROM maven:3.8.2-adoptopenjdk-11

WORKDIR /app

COPY pom.xml ./

COPY src ./src

RUN mvn verify

WORKDIR /app/target

CMD ["java", "-jar", "java-bank-1.0.jar"]
