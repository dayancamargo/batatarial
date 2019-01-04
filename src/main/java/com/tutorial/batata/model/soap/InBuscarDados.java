package com.tutorial.batata.model.soap;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.io.Serializable;

@NoArgsConstructor @Getter @Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class InBuscarDados implements Serializable {
    private Long idPessoa;
    private String nomPessoa;
    private String numDocumento;
    private Long numPagina;
    private Long tamPagina;
    private String tpoPessoa;
}
