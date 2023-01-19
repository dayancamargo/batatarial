package com.tutorial.batata.model.soap.countryinfo;

import com.tutorial.batata.model.BaseModel;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "FullCountryInfo")
public class FullCountryInfo extends BaseModel implements Serializable {
    private String sCountryISOCode;
}
