package com.tutorial.batata.service;

import com.tutorial.batata.client.ActuatorClient;
import com.tutorial.batata.model.actuator.Health;
import com.tutorial.batata.model.actuator.Metric;
import com.tutorial.batata.model.actuator.Metrics;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ActuatorService {

    @Autowired private ActuatorClient actuatorClient;

    public Health health(){
        return actuatorClient.health();
    }

    public Metrics metrics(){
        return actuatorClient.metrics();
    }

    public Metric metrics(String metricName){
        return actuatorClient.metric(metricName);
    }
}
