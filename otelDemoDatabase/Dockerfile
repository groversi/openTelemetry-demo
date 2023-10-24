#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build
COPY ./otelDemoDatabase/src /project/src
COPY ./otelDemoDatabase/pom.xml ./
COPY ./otelDemoDatabase/src ./src
RUN mvn -f ./pom.xml clean package

FROM openjdk:11-jre
RUN mkdir -p /app/bin
COPY --from=build ./target/otel-demo-database-0.0.1.jar /app/bin
COPY ./agent/opentelemetry-javaagent.jar /app/bin

CMD java -DOTEL.SERVICE.NAME=otelDemoDatabase \
         -DOTEL.TRACES.EXPORTER=otlp \
         -DOTEL.EXPORTER.OTLP.ENDPOINT=http://otel-collector:5555 \
         -DOTEL.EXPORTER.OTLP.PROTOCOL=grpc \
         -Dapplication.home=/app/bin/ \
         -javaagent:/app/bin/opentelemetry-javaagent.jar \
         -jar \
         /app/bin/otel-demo-database-0.0.1.jar