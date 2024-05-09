FROM openjdk:20
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} DiscoveryServer-0.0.1-SNAPSHOT.jar.jar
ENTRYPOINT ["java","-jar","/DiscoveryServer-0.0.1-SNAPSHOT.jar.jar"]
EXPOSE 8761