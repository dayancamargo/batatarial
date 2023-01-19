package com.tutorial.batata.model.soap.countryinfo;

import com.tutorial.batata.model.BaseModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.io.Serializable;

@NoArgsConstructor
@Getter @Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class Language extends BaseModel implements Serializable {

    private String sISOCode;
    private String sName;
}
