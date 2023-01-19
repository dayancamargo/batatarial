package com.tutorial.batata.model.soap.continents;

import com.tutorial.batata.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@Getter @Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class Continent extends BaseModel {
    private String sCode;
    private String sName;
}
