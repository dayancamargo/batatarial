package com.tutorial.batata.model.soap;

import com.tutorial.batata.model.BaseModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@NoArgsConstructor @Getter @Setter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "pessoa")
public class Pessoa extends BaseModel {
    private String anoFaturamento;
    private String caracCapital;
    private String catBACEN;
    private String cnae;
    private Long cnpjPJ;
    private String codCNADivisao;
    private String codCNAEClasse;
    private String codCNAEGrupo;
    private String codCNAESubclasse;
    private Long codGrauInstrucao;
    private String codNaturezaEmpresa;
    private String corEtnia;
    private String datCasamento;
    private String datConstituicao;
    private String datEmissaoRG;
    private String datInicioAtividade;
    private String datNascimento;
    private String datOcupacao;
    private String desCNAEClasse;
    private String desCNAEDivisao;
    private String desCNAEGrupo;
    private String desCNAESecao;
    private String desCNAESubclasse;
    private String desGrauInstrucao;
    private String desNaturezaEmpresa;
    private String desNaturezaJuridica;
    private String estCivil;
    private String genero;
    private Long idPessoa;
    private String nacionalidade;
    private String natAtividade;
    private String natJuridica;
    private String nomCidade;
    private String nomFantasia;
    private String nomMae;
    private String nomPai;
    private String nomPessoa;
    private String nomRegimeBem;
    private String nomTipoDocumento;
    private String numRG;
}
