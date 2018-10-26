package com.tutorial.batata.repository;

import com.tutorial.batata.model.batata.Batata;
import com.tutorial.batata.model.batata.BatataDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BatataRepository extends JpaRepository<Batata, Integer> {

    @Query("SELECT new com.tutorial.batata.model.batata.BatataDto( b.name,  b.type, b.dtUpdate) FROM Batata AS b")
    Page<BatataDto> findAllDto(Pageable pageable);
}
