package com.tutorial.batata.controller;

import com.tutorial.batata.exception.model.Error;
import com.tutorial.batata.model.batata.BatataDto;
import com.tutorial.batata.model.response.Response;
import com.tutorial.batata.service.BatataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("batata")
@Slf4j
public class BatataController {

    private final BatataService batataService;

    @Autowired
    public BatataController(BatataService batataService) {
        this.batataService = batataService;
    }

    @GetMapping(produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
    public Response<BatataDto, Error> pageableFind(Pageable page,
                                        @RequestParam(value = "name", required = false) String name,
                                        @RequestParam(value = "type", required = false) String type) {

        BatataDto filter = new BatataDto(null, name, type, null);

        log.info("Get all Batatas with {} using {}", filter, page);

        return Response.build()
                       .withPagination(batataService.pageFind(page, filter))
                       .create();
    }
}

