FROM adoptopenjdk/openjdk11:alpine-jre
#FROM openjdk:11
ADD target/ResourceServiceV1-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]