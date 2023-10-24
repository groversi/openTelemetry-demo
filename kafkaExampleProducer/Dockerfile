#
# Build stage
#
FROM maven:3.8.4-openjdk-17 AS build
COPY ./kafkaExampleProducer/src /project/src
COPY ./kafkaExampleProducer/pom.xml ./
COPY ./kafkaExampleProducer/src ./src
RUN mvn -f ./pom.xml clean package

FROM openjdk:17-jdk-slim
RUN mkdir -p /app/bin
COPY --from=build ./target/kafka-example-producer-0.0.1.jar /app/bin
COPY ./agent/opentelemetry-javaagent.jar /app/bin


CMD java -DOTEL.SERVICE.NAME=kafkaExampleProducer \
         -DOTEL.TRACES.EXPORTER=otlp \
         -DOTEL.EXPORTER.OTLP.ENDPOINT=http://otel-collector:5555 \
         -DOTEL.EXPORTER.OTLP.PROTOCOL=grpc \
         -Dapplication.home=/app/bin/ \
         -javaagent:/app/bin/opentelemetry-javaagent.jar \
         -jar \
         /app/bin/kafka-example-producer-0.0.1.jar