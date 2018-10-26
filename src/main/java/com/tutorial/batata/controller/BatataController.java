package com.tutorial.batata.controller;

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
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("batata")
public class BatataController {

    private static Logger logger = LoggerFactory.getLogger(BatataController.class);

    private BatataService batataService;

    @Autowired
    public BatataController(BatataService batataService) {
        this.batataService = batataService;
    }

    @GetMapping(produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
    public ResponseEntity<Page<BatataDto>> findAll(Pageable page){
        logger.info("Get all Batatas");
        return ResponseEntity.ok(batataService.findAll(page));
    }
}
