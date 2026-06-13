FROM openjdk:11-jre-slim
WORKDIR usr/src
ADD ./target/ExternalAPIService-0.0.1-SNAPSHOT.jar /usr/src/ExternalAPIService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","ExternalAPIService-0.0.1-SNAPSHOT.jar"]
