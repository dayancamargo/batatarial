package com.tutorial.batata.model.actuator;

import com.tutorial.batata.model.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Health extends BaseModel {

    private String status;
    private Detail details;
}
