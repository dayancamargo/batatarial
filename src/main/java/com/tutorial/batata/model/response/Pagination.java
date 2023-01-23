package com.tutorial.batata.model.response;

public record Pagination(Integer page,
                         Integer size,
                         Long totalElements,
                         Long totalPages) {
}
