package com.tutorial.batata.model.soap.continents;

import com.tutorial.batata.model.BaseModel;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ListOfContinentsByCodeResponse")
public class ListOfContinentsByCodeResponse extends BaseModel {

    @XmlElementWrapper(name="ListOfContinentsByCodeResult")
    @XmlElement(name = "tContinent")
    private List<Continent> continents;

    public List<Continent> getContinents() {
        return continents;
    }

    public void setContinents(List<Continent> continents) {
        this.continents = continents;
    }
}
