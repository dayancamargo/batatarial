package com.tutorial.batata.model.actuator;

public record DiskSpaceDetails (Long total,
                               Long free,
                               Long threshold) {}
