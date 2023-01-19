package com.tutorial.batata.controller;

import com.tutorial.batata.exception.model.Error;
import com.tutorial.batata.model.response.Response;
import com.tutorial.batata.model.translate.TranslateRequest;
import com.tutorial.batata.model.translate.TranslateResponse;
import com.tutorial.batata.service.TranslateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("translate")
@Slf4j
public class TranslateController {

    private final TranslateService translateService;

    @Autowired
    public TranslateController(TranslateService translateService) {
        this.translateService = translateService;
    }

    @PostMapping(value = "/yoda", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE }, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Response<TranslateResponse, Error> getMetrics(@RequestBody TranslateRequest text) {

        log.info("Translate to yoda language.");

        return Response.build()
                .withBody(translateService.yoda(text))
                .create();
    }
}

