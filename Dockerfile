FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8080
ADD target/*.jar servicio-medicos.jar
ENV JAVA_OPTS=""
ENTRYPOINT ["java","-jar","/servicio-medicos.jar"]