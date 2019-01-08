package com.tutorial.batata.config;

import com.tutorial.batata.client.SoapClient;
import com.tutorial.batata.client.TranslateClient;
import com.tutorial.batata.feign.soap.SOAPDecoder;
import com.tutorial.batata.feign.soap.SOAPEncoder;
import com.tutorial.batata.feign.soap.SOAPErrorDecoder;
import feign.Feign;
import feign.Logger;
import feign.jaxb.JAXBContextFactory;
import feign.slf4j.Slf4jLogger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignSoapClientConfiguration {

    @Value("${endpoint.soap.country.info.url}")
    private String countryInfoUrl;


    private JAXBContextFactory getJaxbContextFactory() {
        return new JAXBContextFactory.Builder()
                                     .build();
    }

    @Bean
    SoapClient getSoapClient(){
        return Feign.builder()
                .encoder(new SOAPEncoder(getJaxbContextFactory()))
                .decoder(new SOAPDecoder(getJaxbContextFactory()))
                .errorDecoder(new SOAPErrorDecoder())
                .logger(new Slf4jLogger(SoapClient.class)).logLevel(Logger.Level.FULL)
                .target(SoapClient.class, countryInfoUrl);
    }
}
