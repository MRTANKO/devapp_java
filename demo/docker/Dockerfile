FROM openjdk:17

ARG APP_JAR=*.jar

COPY ${APP_JAR} demo.jar

ENTRYPOINT ["java", "-jar", "demo.jar"]

EXPOSE 8080