package com.tutorial.batata.config;

import com.tutorial.batata.client.SoapClient;
import feign.Feign;
import feign.Logger;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.jaxb.JAXBContextFactory;
import feign.soap.SOAPDecoder;
import feign.soap.SOAPEncoder;
import feign.soap.SOAPErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignSoapClientConfiguration {

//    @Value("${endpoint.url.soap.country.info}")
    private String countryInfoUrl;
//
    private JAXBContextFactory getJaxbContextFactory() {
        return new JAXBContextFactory.Builder()
                                     .build();
    }

//    @Bean
    SoapClient getSoapClient(){
        return Feign.builder()
                .encoder(new SOAPEncoder(getJaxbContextFactory()))
                .decoder(new SOAPDecoder(getJaxbContextFactory()))
                .errorDecoder(new SOAPErrorDecoder())
//                .logger(new Slf4jLogger(SoapClient.class))
                .logLevel(Logger.Level.BASIC)
                .target(SoapClient.class, countryInfoUrl);
    }


    private static final JAXBContextFactory jaxbFactory = new JAXBContextFactory.Builder()
            .withMarshallerSchemaLocation("${endpoint.url.soap.country.info-wsdl}")
            .build();

//    @Bean
//    Encoder soapEncoder() {
//        return new SOAPEncoder(jaxbFactory);
//    }
//
//    @Bean
//    Decoder soapDecoder() {
//        return new SOAPDecoder(jaxbFactory);
//    }
}
