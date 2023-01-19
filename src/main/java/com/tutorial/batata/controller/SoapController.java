package com.tutorial.batata.controller;

import com.tutorial.batata.exception.model.Error;
import com.tutorial.batata.model.response.Response;
import com.tutorial.batata.model.soap.continents.ListOfContinentsByCode;
import com.tutorial.batata.model.soap.countryinfo.FullCountryInfo;
import com.tutorial.batata.model.soap.countryinfo.FullCountryInfoResponse;
import com.tutorial.batata.service.SoapService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("country-info")
@Slf4j
public class SoapController {

    private final SoapService soapService;

    @Autowired
    public SoapController(SoapService soapService) {
        this.soapService = soapService;
    }

    @GetMapping(value = "/full-info/{isoCode}", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
    public Response<FullCountryInfoResponse, Error> fullInfo(@PathVariable("isoCode") String isoCode) {

        log.info("Get country({}) information data from a soap service.", isoCode);

        FullCountryInfo request = new FullCountryInfo(isoCode);

        return Response.build()
                       .withBody(soapService.getFullInfo(request))
                       .create();
    }

    @GetMapping(value = "/list-continent", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
    public Response<FullCountryInfoResponse, Error> listCountry() {

        log.info("Get continent list from a soap service.");

        ListOfContinentsByCode request = new ListOfContinentsByCode();

        return Response.build()
                .withBody(soapService.getListOfContinents(request))
                .create();
    }
}

