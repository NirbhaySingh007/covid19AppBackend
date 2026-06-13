FROM openjdk:11-jre-slim
WORKDIR usr/src
ENV MONGO_URI=mongodb://localhost:27017/movie_db
ADD ./target/MyFavouriteService-0.0.1-SNAPSHOT.jar /usr/src/MyFavouriteService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","MyFavouriteService-0.0.1-SNAPSHOT.jar"]
