package com.tutorial.batata.model.soap.continents;

import com.tutorial.batata.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@Getter @Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class Continent extends BaseModel {
    private String sCode;
    private String sName;
}
