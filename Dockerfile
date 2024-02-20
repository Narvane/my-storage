FROM openjdk:17

ENV SPRING_PROFILES_ACTIVE=prod

WORKDIR /app

COPY target/my-storage*.jar /app/my-storage.jar

EXPOSE 8081

CMD ["java", "-jar", "/app/my-storage.jar"]