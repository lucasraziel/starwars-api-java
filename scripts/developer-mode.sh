#!/usr/bin/env bash
# Run the app using local stack SQS and S3

chmod +x ./scripts/mount-environment.sh

./scripts/cache-docker/mount-environment.sh

export MONGO_HOST=localhost
export MONGO_USER=admin
export MONGO_PASSWORD=password
export MONGO_PORT=27017
export MONGO_DB=starwars
export MONGO_CONTAINER_NAME=mongoservice
export AUTHORIZATION_SECRET='TazvE@QSs7AfWTMfEwXaR#TB7P6&p@JQ5RqCMqZ%cL5MU$2qPZyEDkTZH^#cuUW3nbRrTJy^+Hj5wWdNVg?-QypDRMyfE5pCwR#F%bh%73q#F^m*B?@PS'
export AWS_SECRET_KEY=SECRET
export AWS_ACCESS_KEY=ACCESS
export AWS_REGION=us-east-1
export SNS_ENDPOINT=http://localhost:4566
export SQS_ENDPOINT=http://localhost:4566
export SQS_PLANET_DELETE_URL=http://localhost:4566/queue/planet-delete.fifo
export SWAPI_URL=https://swapi.dev/api
export ENV=ENV
export API_PORT=8080
export PROFILE=dev
export MONGO_AUTH_SOURCE=admin

./gradlew build -x test --info

java -jar ./build/libs/starwars.jar
