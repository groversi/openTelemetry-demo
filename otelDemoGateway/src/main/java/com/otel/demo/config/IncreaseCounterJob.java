package com.otel.demo.config;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

@Component
public class IncreaseCounterJob {
    private final Counter ordersCreatedCounter;

    public IncreaseCounterJob(MeterRegistry meterRegistry) {
        ordersCreatedCounter = meterRegistry.counter("");
    }
}
