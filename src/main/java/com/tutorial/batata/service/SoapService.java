package com.tutorial.batata.service;

import com.tutorial.batata.client.SoapClient;
import com.tutorial.batata.model.soap.continents.ListOfContinentsByCode;
import com.tutorial.batata.model.soap.continents.ListOfContinentsByCodeResponse;
import com.tutorial.batata.model.soap.countryinfo.FullCountryInfo;
import com.tutorial.batata.model.soap.countryinfo.FullCountryInfoResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SoapService {

    private SoapClient soapClient;

    @Autowired
    public SoapService(SoapClient soapClient) {
        this.soapClient = soapClient;
    }

    public FullCountryInfoResponse getFullInfo(FullCountryInfo request){
        FullCountryInfoResponse meh = soapClient.fullCountryInfo(request);
        log.debug("InfoResponse : {}", meh);
        return meh;
    }

    public ListOfContinentsByCodeResponse getListOfContinents(ListOfContinentsByCode request){
        ListOfContinentsByCodeResponse meh = soapClient.listOfContinents(request);
        log.debug("ListOfContinentsByCode : {}", meh);
        return meh;
    }
}
