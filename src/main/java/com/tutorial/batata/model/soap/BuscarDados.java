package com.tutorial.batata.model.soap;

import com.tutorial.batata.model.BaseModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@NoArgsConstructor @Getter @Setter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "buscarDados", namespace = "http://cadastro.ejb.enterprise.cadastros.servicos.sicredi.com.br/")
public class BuscarDados extends BaseModel implements Serializable {
    private InBuscarDados inBuscarDados;
}