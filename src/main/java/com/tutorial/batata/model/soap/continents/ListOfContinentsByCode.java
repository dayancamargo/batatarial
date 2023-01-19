package com.tutorial.batata.model.soap.continents;

import com.tutorial.batata.model.BaseModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

@NoArgsConstructor
@Getter @Setter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ListOfContinentsByCode")
public class ListOfContinentsByCode extends BaseModel {

}
