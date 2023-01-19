package com.tutorial.batata.controller;

import com.tutorial.batata.exception.model.Error;
import com.tutorial.batata.model.actuator.Health;
import com.tutorial.batata.model.actuator.Metric;
import com.tutorial.batata.model.actuator.Metrics;
import com.tutorial.batata.model.response.Response;
import com.tutorial.batata.service.ActuatorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("actuator")
@Slf4j
public class ActuatorController {

    private final ActuatorService actuatorService;

    @Autowired
    public ActuatorController(ActuatorService actuatorService) {
        this.actuatorService = actuatorService;
    }

    @GetMapping(value = "/health", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
    public Response<Health, Error> getById() {

        log.info("Get Health properties.");

        return Response.build()
                .withBody(actuatorService.health())
                .create();
    }

    @GetMapping(value = "/metrics", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
    public Response<Metrics, Error> getMetrics() {

        log.info("Get all Metrics.");

        return Response.build()
                .withBody(actuatorService.metrics())
                .create();
    }

    @GetMapping(value = "/metrics/{metricName}", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
    public Response<Metric, Error> getMetrics(@PathVariable("metricName") String metricName) {

        log.info("Get all Metrics.");

        return Response.build()
                .withBody(actuatorService.metrics(metricName))
                .create();
    }
}

