package com.tutorial.batata.exception;

import com.tutorial.batata.exception.model.Error;
import com.tutorial.batata.exception.model.Field;
import lombok.Getter;

import java.util.List;

@Getter
public class BaseException  extends RuntimeException {

    private final Error error;

    public BaseException(String title) {
        this.error = new Error(title);
    }

    public BaseException(String code, String title) {
        this.error = new Error(code, title);
    }

    public BaseException(String code, String detail, String title) {
        this.error = new Error(code, detail, title);
    }

    public BaseException(String code, String detail, String title, String pointer) {
        this.error = new Error(code, detail, title, pointer);
    }

    public BaseException(String code, String detail, String title, List<Field> fields) {
        this.error = new Error(code, detail, title, fields);
    }
}