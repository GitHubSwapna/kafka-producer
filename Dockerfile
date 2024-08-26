FROM eclipse-temurin:17

EXPOSE 9191

COPY target/Kafka-producer-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]