FROM adoptopenjdk/openjdk11:alpine-jre
ADD target/SongService-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

#FROM adoptopenjdk/openjdk11:alpine-jre
#EXPOSE 8084
#WORKDIR /app
#
## Copy maven executable to the image
#COPY mvnw .
#COPY .mvn .mvn
#
## Copy the pom.xml file
#COPY pom.xml .
#
## Copy the project source
#COPY ./src ./src
#COPY ./pom.xml ./pom.xml
#
#RUN chmod 755 /app/mvnw
#
#RUN ./mvnw package -DskipTests
#ENTRYPOINT ["java","-jar","target/SongService-0.0.1-SNAPSHOT.jar"]

