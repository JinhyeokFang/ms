FROM eclipse-temurin:17-jre as builder
WORKDIR /workspace
COPY ./build/libs/*.jar app.jar

FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=builder /workspace/app.jar ./app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
