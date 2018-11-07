package com.tutorial.batata.controller;

import com.tutorial.batata.controller.interceptor.RequestInterceptor;
import com.tutorial.batata.model.Response;
import com.tutorial.batata.model.batata.BatataDto;
import com.tutorial.batata.service.BatataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("batata")
public class BatataController extends RequestInterceptor {

    private static Logger logger = LoggerFactory.getLogger(BatataController.class);

    private BatataService batataService;

    @Autowired
    public BatataController(BatataService batataService) {
        this.batataService = batataService;
    }

    @GetMapping(produces = { MediaType.APPLICATION_JSON_UTF8_VALUE }, value = "find")
    public ResponseEntity<Page> pageableFind(Pageable page,
                                        @RequestParam(value = "name", required = false) String name,
                                        @RequestParam(value = "type", required = false) String type) {

        BatataDto filter = new BatataDto(null, name, type, null);

        logger.info("Get all Batatas with {} using {}", filter, page);

        return ResponseEntity.ok(batataService.pageFind(page, filter));
    }

    @GetMapping(produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
    public Response find(@RequestParam(value = "name", required = false) String name,
                         @RequestParam(value = "type", required = false) String type) {

        BatataDto filter = new BatataDto(null, name, type, null);

        logger.info("Get all Batatas with {}", filter);

        return Response.build().withBody(batataService.find(filter)).create();
    }
}

