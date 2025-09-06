

# Use a stable, lightweight Java base image.
FROM openjdk:26-trixie

# Set the working directory inside the container.

# Copy the JAR file from your local machine to the container.
# The source path is relative to the build context (where you run the docker build command).
# The destination is '/app/app.jar' inside the container.
ADD target/email-writer.jar email-writer.jar

# Define the command to run the application when the container starts.
ENTRYPOINT ["java", "-jar", "/email-writer.jar"]


