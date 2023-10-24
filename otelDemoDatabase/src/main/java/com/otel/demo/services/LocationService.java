package com.otel.demo.services;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.otel.demo.dto.States;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class LocationService {

    private final MeterRegistry meterRegistry;

    public LocationService(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    public List<States> listaEstados() {
        Type listType = new TypeToken<ArrayList<States>>(){}.getType();
        return new Gson().fromJson("[\n" +
                "    {\n" +
                "        \"state\": \"Acre\",\n" +
                "        \"abbr\": \"AC\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"state\": \"Alagoas\",\n" +
                "        \"abbr\": \"AL\"\n" +
                "    }\n" +
                "]", listType);
    }
}
