package com.tutorial.batata.client;

import com.tutorial.batata.model.soap.BuscarDados;
import com.tutorial.batata.model.soap.BuscarDadosResponse;
import feign.Headers;
import feign.RequestLine;
import org.springframework.stereotype.Component;

@Component
public interface SoapClient {

    @RequestLine("POST")
    @Headers({
            "SOAPAction: ''",
            "Content-Type:  text/xml;charset=UTF-8"
            })
    BuscarDadosResponse buscarDados(BuscarDados request);
}
