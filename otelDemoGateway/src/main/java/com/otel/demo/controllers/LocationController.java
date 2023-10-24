package com.otel.demo.controllers;

import com.otel.demo.dto.States;
import com.otel.demo.services.LocationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/v1")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @RequestMapping(value = "/locations",method = RequestMethod.GET)
    public ResponseEntity getAllStates (
            @RequestHeader Integer httpStatus
    ) {
        log.info("Getting list of locations received");
        if(httpStatus.equals(HttpStatus.OK.value())){
            List<States> states = locationService.listaEstados();
            return new ResponseEntity(states, HttpStatus.OK);
        } else{
            return new ResponseEntity(HttpStatus.resolve(httpStatus));
        }
    }
}
