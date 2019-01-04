package com.tutorial.batata.service;

import com.tutorial.batata.client.SoapClient;
import com.tutorial.batata.model.soap.BuscarDados;
import com.tutorial.batata.model.soap.BuscarDadosResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SoapService {

    private SoapClient soapClient;

    @Autowired
    public SoapService(SoapClient soapClient) {
        this.soapClient = soapClient;
    }

    public BuscarDadosResponse buscarDados(BuscarDados request){
        return soapClient.buscarDados(request);
    }
}
