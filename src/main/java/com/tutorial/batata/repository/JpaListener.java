package com.tutorial.batata.repository;

import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import jakarta.persistence.PostUpdate;
import lombok.extern.slf4j.Slf4j;

/**
 * Simple example class to add a "listener" for database transactions
 */
@Slf4j
public class JpaListener {

    @PostRemove
    protected void triggerRemoveEvent(Object entity) {
        log.info("{} removed entity: {}", entity.getClass().getSimpleName(), entity);
    }

    @PostUpdate
    protected void triggerUpdateEvent(Object entity) {
        log.info("{} updated entity: {}", entity.getClass().getSimpleName(), entity);
    }

    @PostPersist
    protected void triggerPersistEvent(Object entity) {
        log.info("{} created entity: {}", entity.getClass().getSimpleName(), entity);
    }
}
