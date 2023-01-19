package com.tutorial.batata.config;

import feign.Logger;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.jaxb.JAXBContextFactory;
import feign.soap.SOAPDecoder;
import feign.soap.SOAPEncoder;
import org.springframework.context.annotation.Bean;
public class FeignSoapClientConfiguration {

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    Encoder soapEncoder() {
        return new SOAPEncoder(new JAXBContextFactory.Builder().build());
    }

    @Bean
    Decoder soapDecoder() {
        return new SOAPDecoder(new JAXBContextFactory.Builder().build());
    }
}
