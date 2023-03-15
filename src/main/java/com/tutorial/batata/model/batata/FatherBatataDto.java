package com.tutorial.batata.model.batata;

import java.time.LocalDateTime;
import java.util.List;

public record FatherBatataDto (Integer id, String name, String type, LocalDateTime createdAt, LocalDateTime updatedAt, List<BatataDto> batatas) {
}
