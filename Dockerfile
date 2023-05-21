FROM openjdk:17
EXPOSE 8080
ADD target/movie-api.jar movie-api.jar
ENTRYPOINT ["java","-jar","/movie-api.jar"]