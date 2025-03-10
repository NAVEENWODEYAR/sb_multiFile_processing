# Use an official OpenJDK runtime as a base image for building
FROM openjdk:17 AS build

# Create a directory for the application
RUN mkdir /usr/app/

# Copy the JAR file into the container
COPY target/My_Docker_App.jar /usr/app/

# Set the working directory
WORKDIR /usr/app/

# Run the application
ENTRYPOINT ["java", "-jar", "My_Docker_App.jar"]
