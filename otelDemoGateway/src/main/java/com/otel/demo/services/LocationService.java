package com.otel.demo.services;


import com.otel.demo.dto.States;
import io.opentelemetry.extension.annotations.WithSpan;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class LocationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LocationService.class);

    @Value("${app.database.url}")
    private String databaseUrl;

    @Autowired
    private RestTemplate restTemplate;

    @WithSpan
    public List<States> listaEstados() {
        LOGGER.info("Getting locations from {}", databaseUrl);

        ResponseEntity<States[]> response = restTemplate.getForEntity(databaseUrl, States[].class);

        return Arrays.asList(response.getBody());
    }
}
