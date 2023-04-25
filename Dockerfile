FROM maven:3.8.7-eclipse-temurin-19 as build
WORKDIR /app
COPY . .
RUN mvn package

FROM eclipse-temurin:19-jre-alpine

WORKDIR /app
COPY consumer/target/consumer-1.0-SNAPSHOT.jar /app/consumer.jar
COPY provider/target/provider-1.0-SNAPSHOT.jar /app/provider.jar
COPY service/target/service-1.0-SNAPSHOT.jar /app/service.jar

EXPOSE 8080

ENTRYPOINT ["java", "--module-path", "/app", "-m", "org.example.consumer/org.example.consumer.Consumer"]





#COPY customjre /app/customjre

#ENV JAVA_HOME /customjre

#ENV PATH $PATH:$JAVA_HOME/bin