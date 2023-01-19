package com.tutorial.batata.model.soap.countryinfo;

import com.tutorial.batata.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@Getter @Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class FullCountryInfoResult extends BaseModel {

    private String sISOCode;
    private String sName;
    private String sCapitalCity;
    private String sPhoneCode;
    private String sContinentCode;
    private String sCurrencyISOCode;
    private String sCountryFlag;

//    @XmlElementWrapper(name="Languages")
//    @XmlElement(name = "tLanguage")
//    private List<Language> languages;
}
