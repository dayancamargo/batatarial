package com.tutorial.batata.client;

import com.tutorial.batata.model.translate.TranslateRequest;
import com.tutorial.batata.model.translate.TranslateResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "identity-validator", url = "${endpoint.url.translate}")
public interface TranslateClient {

    @PostMapping(value = "/translate/morse.json")
    TranslateResponse morse(@RequestBody TranslateRequest text);

    @PostMapping(value = "/translate/yoda.json")
    TranslateResponse yoda(@RequestBody TranslateRequest text);

    @PostMapping(value = "/translate/pirate.json")
    TranslateResponse pirate(@RequestBody TranslateRequest text);
}
