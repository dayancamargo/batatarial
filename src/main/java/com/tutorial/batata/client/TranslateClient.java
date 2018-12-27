package com.tutorial.batata.client;

import com.tutorial.batata.model.translate.TranslateRequest;
import com.tutorial.batata.model.translate.TranslateResponse;
import feign.Headers;
import feign.RequestLine;
import org.springframework.stereotype.Component;

@Component
@Headers("Content-Type: application/json")
public interface TranslateClient {

    @RequestLine("POST /translate/morse.json")
    TranslateResponse morse(TranslateRequest text);

    @RequestLine("POST /translate/yoda.json")
    TranslateResponse yoda(TranslateRequest text);

    @RequestLine("POST /translate/pirate.json")
    TranslateResponse pirate(TranslateRequest text);
}
