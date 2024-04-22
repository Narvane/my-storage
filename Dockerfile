FROM openjdk:17

ENV SPRING_PROFILES_ACTIVE=prod

WORKDIR /app

COPY /app/target/app*.jar /app/my-storage.jar

EXPOSE 8081

CMD ["java", "-jar", "/app/my-storage.jar"]