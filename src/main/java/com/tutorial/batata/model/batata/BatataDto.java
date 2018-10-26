package com.tutorial.batata.model.batata;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(exclude = {"dtUpdate"})
public class BatataDto {

    private String name;
    private String type;
    private Date dtUpdate;

    public BatataDto(String name, String type) {
        this.name = name;
        this.type = type;
    }
}
