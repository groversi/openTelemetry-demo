package com.otel.demo.controllers;

import com.otel.demo.dto.States;
import com.otel.demo.services.LocationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/v1")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @RequestMapping(value = "/locations",method = RequestMethod.GET)
    public ResponseEntity getAllStates () {
        log.info("Getting list of locations received");
        List<States> states = locationService.listaEstados();
        return new ResponseEntity(states, HttpStatus.OK);
    }
}
