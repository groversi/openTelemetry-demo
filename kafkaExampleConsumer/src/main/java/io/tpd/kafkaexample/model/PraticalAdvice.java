package io.tpd.kafkaexample.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public record PraticalAdvice (@JsonProperty("message") String message,
                             @JsonProperty("identifier") LocalDateTime identifier){
    @Override
    public String toString() {
        return "PraticalAdvice{" +
                "message='" + message + '\'' +
                ", identifier=" + identifier +
                '}';
    }
}
