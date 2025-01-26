#!/bin/bash

echo "Building all projects with Gradle..."
./gradlew clean bootJar

services=(
    "microservices/ticket:jinhyeokfang/ms-ticket"
    "microservices/review:jinhyeokfang/ms-review"
    "microservices/user:jinhyeokfang/ms-user"
    "microservices/ticket-composite:jinhyeokfang/ms-ticket-composite"
)

build_and_push() {
    local path=$1
    local repo=$2

    echo "Processing $path -> $repo"

    cd "$path"

    echo "Building Docker image for $repo..."
    docker build -t "$repo:latest" .

    echo "Pushing Docker image $repo:latest..."
    docker push "$repo:latest"

    cd -

    echo "Completed processing $repo"
    echo "------------------------"
}

for service in "${services[@]}"; do
    IFS=':' read -r path repo <<< "$service"

    build_and_push "$path" "$repo" &
done

wait

docker-compose down
docker-compose up -d

echo "All services have been built and pushed successfully!"