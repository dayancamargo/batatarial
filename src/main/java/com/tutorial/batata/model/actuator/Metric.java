package com.tutorial.batata.model.actuator;

import java.util.List;

public record Metric(String name, String description, String baseUnit, List<Measurements> measurements) {
}
