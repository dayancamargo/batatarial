package com.tutorial.batata.service;

import com.tutorial.batata.model.batata.Batata;
import com.tutorial.batata.model.batata.BatataDto;
import com.tutorial.batata.repository.BatataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BatataService {

    private static Logger logger = LoggerFactory.getLogger(BatataService.class);
    private BatataRepository batataRepository;

    @Autowired
    public BatataService(BatataRepository batataRepository){
        this.batataRepository = batataRepository;
    }

    public Page findAll(Pageable page){

        Page<Batata> dtos = batataRepository.findAll(page);
        logger.debug("returning: {} ", dtos.getContent());

        return dtos.map(this::convertToDto);
    }

    private BatataDto convertToDto(Batata batata){
        return new BatataDto(batata.getId(), batata.getName(), batata.getType(), batata.getDtUpdate());
    }
}
