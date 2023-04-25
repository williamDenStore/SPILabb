FROM eclipse-temurin:19-jre-alpine

WORKDIR /app
COPY consumer/target/consumer-1.0-SNAPSHOT.jar /app/consumer.jar
COPY provider/target/provider-1.0-SNAPSHOT.jar /app/provider.jar
COPY service/target/service-1.0-SNAPSHOT.jar /app/service.jar

EXPOSE 8080

#ENTRYPOINT ["java", "--module-path", "/app/provider:/app/service:/app/consumer", "-m", "org.example.consumer/org.example.consumer.Consumer"]
ENTRYPOINT ["java", "--module-path", "/app", "-m", "org.example.consumer/org.example.consumer.Consumer"]
#ENTRYPOINT ["java", "--module-path", "./", "-m", "org.example.consumer/org.example.consumer.Consumer"]




#COPY customjre /app/customjre

#ENV JAVA_HOME /customjre

#ENV PATH $PATH:$JAVA_HOME/bin