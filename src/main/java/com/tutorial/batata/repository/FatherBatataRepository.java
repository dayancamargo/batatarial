package com.tutorial.batata.repository;

import com.tutorial.batata.model.batata.FatherBatata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface FatherBatataRepository extends JpaRepository<FatherBatata, Integer>, JpaSpecificationExecutor<FatherBatata>, SpecificationUtils<FatherBatata> {
}