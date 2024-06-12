FROM openjdk:20
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} DiscoveryServer-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/DiscoveryServer-0.0.1-SNAPSHOT.jar"]