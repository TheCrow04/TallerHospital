FROM amazoncorretto:17-alpine-jdk
COPY target/tallerhospital-0.0.1-SNAPSHOT.jar /miapihospitalv1.jar

ENTRYPOINT ["java","-jar","/miapihospitalv1.jar"]