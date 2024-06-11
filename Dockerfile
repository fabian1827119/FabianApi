# Start with a base image containing Java runtime
FROM openjdk:17-jdk-alpine

VOLUME /temp

# Add Maintainer Info
LABEL maintainer="fabian.santillan@example.com"

# Make port 8080 available to the world outside this container
EXPOSE 8085

# The application's jar file
ARG JAR_FILE=target/apijwt-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} app.jar

# Run the jar file 
ENTRYPOINT ["java","-jar","/app.jar"]