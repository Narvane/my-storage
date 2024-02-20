FROM openjdk:17

ENV SPRING_PROFILES_ACTIVE=prod

WORKDIR /app

COPY /api-webmvc/target/api-webmvc*.jar /app/my-storage.jar

EXPOSE 8081

CMD ["java", "-jar", "/app/my-storage.jar"]