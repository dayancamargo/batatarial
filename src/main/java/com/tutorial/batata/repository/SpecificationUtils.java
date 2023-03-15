package com.tutorial.batata.repository;

import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

public interface SpecificationUtils<T> {

    default Specification<T> isNull(String fieldName) {
        return (root, query, builder) ->
                builder.isNull(root.get(fieldName));
    }

    default Specification<T> isEqual(String fieldName, Object value) {
        return (root, query, builder) -> {
            if (Objects.nonNull(value)) {
                return builder.equal(root.get(fieldName), value);
            } else {
//                return builder.isNotNull(root.get(fieldName)); remove comment this to set not null if value is null
                return null;
            }
        };
    }

    default Specification<T> isEqualWithJoin(String entity, String fieldName, Object value) {
        if(Objects.nonNull(value)) {
            return (root, query, builder) ->
                    builder.equal(root.get(entity).get(fieldName), value);
        }  else {
            return null;
        }
    }

    default Specification<T> isNotNull(String fieldName) {
        return (root, query, builder) ->
                builder.isNotNull(root.get(fieldName));
    }

    default Specification<T> isLike(String fieldName, Object value) {
        return (root, query, builder) -> {
            if (Objects.nonNull(value)) {
                return builder.like(root.get(fieldName), "%"+value+"%");
            } else {
//                return builder.isNotNull(root.get(fieldName)); remove comment this to set not null if value is null
                return null;
            }
        };
    }
}