package com.tutorial.batata.model.soap;

import com.tutorial.batata.model.BaseModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@NoArgsConstructor @Getter @Setter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "buscarDadosResponse")
public class OutBuscarDados extends BaseModel implements Serializable {

    @XmlElementWrapper(name="pessoas")
    @XmlElement(name = "pessoa")
    List<Pessoa> pessoas;
}
