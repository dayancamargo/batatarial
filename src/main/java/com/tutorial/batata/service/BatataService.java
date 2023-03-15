package com.tutorial.batata.service;

import com.tutorial.batata.model.batata.Batata;
import com.tutorial.batata.model.batata.BatataDto;
import com.tutorial.batata.repository.BatataRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BatataService {

    private BatataRepository batataRepository;

    @Autowired
    public BatataService(BatataRepository batataRepository){
        this.batataRepository = batataRepository;
    }

    /**
     * A Find method to be used with pagination and a more complex filter rule
     * @param page pagination information
     * @param filter filter object to be used with LIKE and ignore case
     * @return paginated list of batataDto
     */
    public Page pageFind(final Pageable page, final BatataDto filter){

        Example<Batata> exFilter = Example.of(new Batata(filter), batataRepository.pageableMatcher());

        Page<Batata> dtos = batataRepository.findAll(exFilter, page);
        log.debug("returning: {} ", dtos.getContent());

        return dtos.map(this::convertToDto);
    }

    /**
     * A Find method to be used without pagination and a exact where rule
     * @param filter filter object to be used with LIKE and ignore case
     * @return list of batataDto
     */
    public List<BatataDto> find(final BatataDto filter) {

        Example<Batata> exFilter = Example.of(new Batata(filter), batataRepository.simpleMatcher());

        List<Batata> dtos = batataRepository.findAll(exFilter);
        log.debug("returning: {} ", dtos);

        return dtos.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public BatataDto create(final BatataDto dto) {
        return convertToDto(batataRepository.save(new Batata(dto)));
    }

    public BatataDto addChild(Integer fatherId, BatataDto batataDto) {
        return null;
    }

    private BatataDto convertToDto(Batata batata) {
        if(Objects.nonNull(batata)) {
            return new BatataDto(batata.getId(), batata.getName(), batata.getType(), batata.getFatherId(), batata.getCreatedAt().toLocalDateTime(), batata.getUpdatedAt().toLocalDateTime());
        }

        return null;
    }
}
