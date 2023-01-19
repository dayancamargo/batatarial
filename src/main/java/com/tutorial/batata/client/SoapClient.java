package com.tutorial.batata.client;

import com.tutorial.batata.config.FeignSoapClientConfiguration;
import com.tutorial.batata.model.soap.continents.ListOfContinentsByCode;
import com.tutorial.batata.model.soap.continents.ListOfContinentsByCodeResponse;
import com.tutorial.batata.model.soap.countryinfo.FullCountryInfo;
import com.tutorial.batata.model.soap.countryinfo.FullCountryInfoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "country-info-soap",
        url = "${endpoint.url.soap.country.info}",
        configuration = FeignSoapClientConfiguration.class)
public interface SoapClient {

    @PostMapping(produces = MediaType.TEXT_XML_VALUE, consumes = MediaType.TEXT_XML_VALUE)
    FullCountryInfoResponse fullCountryInfo(@RequestBody FullCountryInfo info);

    @PostMapping(produces = MediaType.TEXT_XML_VALUE, consumes = MediaType.TEXT_XML_VALUE)
    ListOfContinentsByCodeResponse listOfContinents(@RequestBody ListOfContinentsByCode request);
}
