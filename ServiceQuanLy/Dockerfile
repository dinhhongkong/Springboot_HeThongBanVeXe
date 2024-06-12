FROM openjdk:20
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ServiceQuanLy-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/ServiceQuanLy-0.0.1-SNAPSHOT.jar"]