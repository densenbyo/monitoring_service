# Use an OpenJDK 21 JRE image
FROM eclipse-temurin:21-jre-alpine

# Set the working directory
WORKDIR /app

# Copy the application JAR file
# Make sure to update "your-app.jar" to the actual name of your JAR file
COPY target/your-app.jar app.jar

# Expose port 8080
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
