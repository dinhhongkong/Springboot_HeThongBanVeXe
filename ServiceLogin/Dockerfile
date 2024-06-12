FROM openjdk:20
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ServiceLogin-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/ServiceLogin-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080