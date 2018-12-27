package com.tutorial.batata.model.actuator;

import com.tutorial.batata.model.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Metric extends BaseModel {

     private String name;
     private String description;
     private String baseUnit;

     private List<Measurements> measurements;
}
