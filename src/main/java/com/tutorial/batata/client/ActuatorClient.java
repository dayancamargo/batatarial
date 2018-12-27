package com.tutorial.batata.client;

import com.tutorial.batata.model.actuator.Health;
import com.tutorial.batata.model.actuator.Metric;
import com.tutorial.batata.model.actuator.Metrics;
import feign.Param;
import feign.RequestLine;
import org.springframework.stereotype.Component;

@Component
public interface ActuatorClient {

    @RequestLine("GET /health")
    Health health();

    @RequestLine("GET /metrics")
    Metrics metrics();

    @RequestLine("GET /metrics/{metricName}")
    Metric metric(@Param("metricName") String metricName);
}
