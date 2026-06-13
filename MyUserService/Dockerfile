FROM openjdk:11-jre-slim
WORKDIR usr/src
EXPOSE 8085
ADD ./target/MyUserService-0.0.1-SNAPSHOT.jar /usr/src/MyUserService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","MyUserService-0.0.1-SNAPSHOT.jar"]