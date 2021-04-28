FROM openjdk:8-jdk-slim
COPY "./target/mutantsDnaAPI-0.0.1-SNAPSHOT.jar" "mutantsDnaAPI-0.0.1-SNAPSHOT.jar"
EXPOSE 8080
CMD ["java","-jar","mutantsDnaAPI-0.0.1-SNAPSHOT.jar"]