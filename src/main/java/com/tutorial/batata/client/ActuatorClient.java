package com.tutorial.batata.client;

import com.tutorial.batata.model.actuator.Health;
import com.tutorial.batata.model.actuator.Metric;
import com.tutorial.batata.model.actuator.Metrics;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "actuator-client", url = "${endpoint.url.actuator}")
public interface ActuatorClient {

    @GetMapping(value = "/health")
    Health health();

    @GetMapping(value = "/metrics")
    Metrics metrics();

    @GetMapping(value = "/metrics/{metricName}")
    Metric metric(@PathVariable("metricName") String metricName);
}
