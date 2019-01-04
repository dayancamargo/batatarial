package com.tutorial.batata.controller;

import com.tutorial.batata.controller.interceptor.RequestInterceptor;
import com.tutorial.batata.exception.model.Error;
import com.tutorial.batata.model.response.Response;
import com.tutorial.batata.model.soap.BuscarDados;
import com.tutorial.batata.model.soap.BuscarDadosResponse;
import com.tutorial.batata.model.soap.InBuscarDados;
import com.tutorial.batata.service.SoapService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("informacoes-cadastrais")
@Slf4j
public class SoapController extends RequestInterceptor {

    private SoapService soapService;

    @Autowired
    public SoapController(SoapService soapService) {
        this.soapService = soapService;
    }

    @GetMapping(value = "/buscar-dados/{idPessoa}", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
    public Response<BuscarDadosResponse, Error> buscarDados(@PathVariable("idPessoa") Long idPessoa) {

        log.info("Get data from a soap service.");

        BuscarDados bd = new BuscarDados();
        InBuscarDados inBd = new InBuscarDados();
        inBd.setIdPessoa(idPessoa);
        bd.setInBuscarDados(inBd);

        return Response.build()
                       .withBody(soapService.buscarDados(bd))
                       .create();
    }
}

