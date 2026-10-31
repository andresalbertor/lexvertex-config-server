# Thin wrapper — prefer building from repo root with backend/Dockerfile.
# Kept for local tooling that expects a Dockerfile beside the service.
FROM eclipse-temurin:21-jre-jammy
WORKDIR /app
COPY build/libs/*.jar app.jar
EXPOSE 8888
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
