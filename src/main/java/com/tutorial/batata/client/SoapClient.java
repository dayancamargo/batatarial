package com.tutorial.batata.client;

import com.tutorial.batata.model.soap.continents.ListOfContinentsByCode;
import com.tutorial.batata.model.soap.continents.ListOfContinentsByCodeResponse;
import com.tutorial.batata.model.soap.countryinfo.FullCountryInfo;
import com.tutorial.batata.model.soap.countryinfo.FullCountryInfoResponse;
import feign.Headers;
import feign.RequestLine;
import org.springframework.stereotype.Component;

@Component
public interface SoapClient {

    @RequestLine("POST")
    @Headers({"SOAPAction: ''",
            "Content-Type:  text/xml;charset=UTF-8"})
    FullCountryInfoResponse fullCountryInfo(FullCountryInfo info);


    @RequestLine("POST")
    @Headers({"SOAPAction: ''",
            "Content-Type:  text/xml;charset=UTF-8"})
    ListOfContinentsByCodeResponse listOfContinents(ListOfContinentsByCode request);
}
