FROM openjdk:21
WORKDIR /app
COPY target/LibraryService-1.0-SNAPSHOT.jar LibraryService.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "LibraryService.jar"]