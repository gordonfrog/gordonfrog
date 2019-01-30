FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
#ADD ${JAR_FILE} app.jar
ADD target/gordonfrog-0.1.0.jar app.jar
#ADD target/fleetman-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 9090