FROM maven:3.5-jdk-8-alpine
WORKDIR /app
COPY . /app
RUN mvn package

FROM openjdk:8-jre-alpine
WORKDIR /app
COPY --from=0 /app/target/randomlog-0.0.1-SNAPSHOT.jar /app
ENTRYPOINT ["sh", "-c"]
CMD ["java -jar randomlog-0.0.1-SNAPSHOT.jar"]
