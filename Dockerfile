# Use official OpenJDK image as the base image
FROM openjdk:11

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/simple_todo_be-0.0.1-SNAPSHOT.jar app.jar

# Expose the port on which the app will run
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "app.jar"]