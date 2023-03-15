package com.tutorial.batata.controller;

import com.tutorial.batata.exception.model.Error;
import com.tutorial.batata.model.batata.BatataDto;
import com.tutorial.batata.model.batata.FatherBatataCreateDto;
import com.tutorial.batata.model.batata.FatherBatataDto;
import com.tutorial.batata.model.batata.FatherBatataRequestDto;
import com.tutorial.batata.model.response.Response;
import com.tutorial.batata.service.BatataService;
import com.tutorial.batata.service.FatherBatataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("batata")
@RequiredArgsConstructor
@Slf4j
public class BatataController {

    private final BatataService batataService;
    private final FatherBatataService fatherBatataService;

    @GetMapping
    public Response<BatataDto, Error> pageableFind(Pageable page,
                                                   @RequestParam(value = "name", required = false) String name,
                                                   @RequestParam(value = "type", required = false) String type) {

        BatataDto filter = new BatataDto(null, name, type, null, null, null);

        log.info("Get all Batatas with {} using {}", filter, page);

        return Response.build()
                .withPagination(batataService.pageFind(page, filter))
                .create();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Response<BatataDto, Error> create(@RequestBody BatataDto batataDto) {

        return Response.build()
                .withBody(batataService.create(batataDto))
                .create();
    }

    @GetMapping(value = "/father")
    public Response<FatherBatataDto, Error> pageableFindFathers(Pageable page,
                                                                @RequestParam(value = "name", required = false) String name,
                                                                @RequestParam(value = "type", required = false) String type,
                                                                @RequestParam(value = "childName", required = false) String childName,
                                                                @RequestParam(value = "childType", required = false) String childType) {

        FatherBatataRequestDto filter = new FatherBatataRequestDto(name, type, childName, childType);

        log.info("Get all FatherBatatas with {} using {}", filter, page);

        return Response.build()
                .withPagination(fatherBatataService.pageFindFatherAndChild(page, filter))
                .create();
    }

    @PostMapping(value = "/father")
    @ResponseStatus(HttpStatus.CREATED)
    public Response<FatherBatataDto, Error> createFather(@RequestBody FatherBatataCreateDto dto) {

        return Response.build()
                .withBody(fatherBatataService.create(dto))
                .create();
    }

    @PostMapping(value = "/father/{fatherId}/add-child")
    @ResponseStatus(HttpStatus.CREATED)
    public Response<FatherBatataDto, Error> addChild(@PathVariable final Integer fatherId, @RequestBody BatataDto batataDto) {

        return Response.build()
                .withBody(fatherBatataService.addChild(fatherId, batataDto))
                .create();
    }
}

