package com.tutorial.batata.config;

import com.tutorial.batata.client.ActuatorClient;
import com.tutorial.batata.client.TranslateClient;
import com.tutorial.batata.exception.decode.TranslateErrorDecode;
import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.slf4j.Slf4jLogger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfiguration {

    @Value("${endpoint.url.actuator}")
    private String actuatorUrl;

    @Value("${endpoint.url.translate}")
    private String translateUrl;

    @Bean
    ActuatorClient getActuatorClient(){
        return Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .errorDecoder(new TranslateErrorDecode())
                .logger(new Slf4jLogger(ActuatorClient.class))
                .logLevel(Logger.Level.FULL)
                .target(ActuatorClient.class, actuatorUrl);
    }

    @Bean
    TranslateClient getTranslateClient(){
        return Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .errorDecoder(new TranslateErrorDecode())
                .logger(new Slf4jLogger(TranslateClient.class))
                .logLevel(Logger.Level.FULL)
                .errorDecoder(new TranslateErrorDecode())
                .target(TranslateClient.class, translateUrl);
    }
}
