#
# Build stage
#
FROM maven:3.8.4-openjdk-17 AS build
COPY ./kafkaExampleConsumer/src /project/src
COPY ./kafkaExampleConsumer/pom.xml ./
COPY ./kafkaExampleConsumer/src ./src
RUN mvn -f ./pom.xml clean package

FROM openjdk:17-jdk-slim
RUN mkdir -p /app/bin
COPY --from=build ./target/kafka-example-consumer-0.0.1.jar /app/bin
COPY ./agent/opentelemetry-javaagent.jar /app/bin


CMD java -DOTEL.SERVICE.NAME=kafkaExampleConsumer \
         -DOTEL.TRACES.EXPORTER=otlp \
         -DOTEL.LOGS.EXPORTER=otlp \
         -DOTEL.METRICS.EXPORTER=otlp \
         -DOTEL.EXPORTER.OTLP.ENDPOINT=http://otel-collector:5555 \
         -DOTEL.EXPORTER.OTLP.PROTOCOL=grpc \
         -Dapplication.home=/app/bin/ \
         -javaagent:/app/bin/opentelemetry-javaagent.jar \
         -jar \
         /app/bin/kafka-example-consumer-0.0.1.jar