# Stacks
This demo includes these observability backends:
 - Grafana
 - Tempo
 - Loki
 - Jaeger
 - Zipkin
 - Prometheus

And these services:
 - Spring Kafka
 - Spring boot API

# Requirements
This project is docker native, it's necessary to have one of it on you machine

# How to run
Execute this command inside of the playground folder:

`` 
    docker compose up --build
``

# Demos
Attached to playground/util folder, there is a Postman collection, with some example requests:
 - Reqs for grafana metrics - through Otel-collector
 - Reqs for logs - through Otel-collector
 - Reqs for traces - through Otel-collector
 - Reqs for spring boot api


# Architecture
Attached on playground/util, there is a power point presentation showing the details of this demo.

# Configurations
The OpenTelemetry collector has a file inside playground/etc folder, otel-collector-config.yaml, where it's possible
to configure the behaviour of the Receivers, Processors, Exporters and Connectors.

On the demo, the collector is configured to capture logs, metrics and trace, exposing ports 
4318 (http) and 4319 (grpc) able to receive payloads of logs, traces and metrics.

For more information, take a look at [OpenTelemetry](https://opentelemetry.io/).

# Backends urls
You can access the backends by these routers:
 - http://localhost:16686 - Jaeger
 - http://localhost:3000 - Grafana
 - http://localhost:9090 - Prometheus
 - https://localhost:9411 - Zipkin

# Contacts
| Name            | Email                     |
|-----------------|---------------------------|
| Gustavo Roversi | gustavo.roversi@gmail.com |