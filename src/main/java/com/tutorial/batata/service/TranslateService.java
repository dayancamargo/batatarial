package com.tutorial.batata.service;

import com.tutorial.batata.client.TranslateClient;
import com.tutorial.batata.model.translate.TranslateRequest;
import com.tutorial.batata.model.translate.TranslateResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TranslateService {

    @Autowired private TranslateClient translateClient;

    public TranslateResponse morse(TranslateRequest text){
        return translateClient.morse(text);
    }

    public TranslateResponse yoda(TranslateRequest text){
        return translateClient.yoda(text);
    }

    public TranslateResponse pirate(TranslateRequest text){
        return translateClient.pirate(text);
    }
}
