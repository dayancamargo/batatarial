package com.tutorial.batata.model.batata;

import java.time.LocalDateTime;

public record BatataDto (Integer id, String name, String type, Integer fatherId, LocalDateTime createdAt, LocalDateTime updatedAt) {
}