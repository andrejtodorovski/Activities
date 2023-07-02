FROM openjdk:17-jdk-alpine
COPY ./target/Activities-0.0.1.jar app.jar
COPY ./src/main/resources/static/games.json /app/jsonData/games.json
COPY ./src/main/resources/static/tv_shows.json /app/jsonData/tv_shows.json
ENTRYPOINT ["java","-jar","/app.jar"]