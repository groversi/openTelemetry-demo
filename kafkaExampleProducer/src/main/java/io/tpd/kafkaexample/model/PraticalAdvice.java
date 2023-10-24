package io.tpd.kafkaexample.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class PraticalAdvice {

    @JsonProperty("message")
    private String message;

    @JsonProperty("identifier")
    private LocalDateTime identifier;


    public PraticalAdvice(String message, LocalDateTime identifier) {
        this.message = message;
        this.identifier = identifier;
    }
}
