package com.tutorial.batata.model.soap.countryinfo;

import com.tutorial.batata.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Getter @Setter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "FullCountryInfoResponse")
public class FullCountryInfoResponse extends BaseModel implements Serializable {

    @XmlElement(name = "FullCountryInfoResult")
    private FullCountryInfoResult fullCountryInfoResult;
}
