package com.tutorial.batata.service;

import com.tutorial.batata.model.batata.BatataDto;
import com.tutorial.batata.model.batata.BatataRequestDto;
import com.tutorial.batata.model.batata.FatherBatata;
import com.tutorial.batata.model.batata.FatherBatataCreateDto;
import com.tutorial.batata.model.batata.FatherBatataDto;
import com.tutorial.batata.model.batata.FatherBatataRequestDto;
import com.tutorial.batata.repository.FatherBatataRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class FatherBatataService {

    private final FatherBatataRepository fatherBatataRepository;

    public Page pageFind(final Pageable page, final BatataRequestDto filter){

        Page<FatherBatata> dtos = fatherBatataRepository.findAll(fatherBatataRepository.isLike("name", filter.name())
                                                                                       .and(fatherBatataRepository.isLike("type", filter.type())),
                                                                 page);
        log.debug("returning: {} ", dtos.getContent());

        return dtos.map(FatherBatata::toDto);
    }

    public Page pageFindFatherAndChild(final Pageable page, final FatherBatataRequestDto filter){

        Page<FatherBatata> dtos = fatherBatataRepository.findAll(fatherBatataRepository.isEqual( "name", filter.name())
                                                                                       .and(fatherBatataRepository.isEqual("type", filter.type()))
                                                                                       .and(fatherBatataRepository.isEqualWithJoin("batatas", "name", filter.childName()))
                                                                                       .and(fatherBatataRepository.isEqualWithJoin("batatas","type", filter.childType())),
                                                                 page);
        log.debug("returning: {} ", dtos.getContent());

        return dtos.map(FatherBatata::toDto);
    }

    public FatherBatataDto create(final FatherBatataCreateDto dto) {
        return fatherBatataRepository.save(new FatherBatata(dto)).toDto();
    }


    public FatherBatataDto addChild(Integer fatherId, BatataDto batataDto) {
        return null;
    }
}
