FROM eclipse-temurin:19-jre-focal

RUN apt-get update
RUN apt-get -qq -y install tini
ENTRYPOINT ["tini", "-e", "143", "--"]
RUN mkdir /app
COPY ./build/libs/spring-graceful-shutdown-demo-0.0.1-SNAPSHOT.jar /app/java-application.jar
WORKDIR /app
CMD ["java", "-jar", "java-application.jar"]
