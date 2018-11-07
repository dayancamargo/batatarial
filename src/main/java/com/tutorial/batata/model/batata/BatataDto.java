package com.tutorial.batata.model.batata;

import com.tutorial.batata.model.BaseModel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(exclude = {"dtUpdate"}, callSuper = false)
public class BatataDto extends BaseModel {

    private Integer id;
    private String name;
    private String type;
    private Date dtUpdate;
}
