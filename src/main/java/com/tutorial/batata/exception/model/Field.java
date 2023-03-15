package com.tutorial.batata.exception.model;

import com.tutorial.batata.model.BaseModel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@Getter
@RequiredArgsConstructor
public class Field extends BaseModel {

    @NonNull private String parameter;
    private String value;

    public Field(String parameter, Object value) {
        this.parameter = parameter;
        this.value = Objects.toString(value, "null");
    }
}
