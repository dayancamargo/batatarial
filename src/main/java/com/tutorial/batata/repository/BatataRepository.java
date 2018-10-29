package com.tutorial.batata.repository;

import com.tutorial.batata.model.batata.Batata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatataRepository extends JpaRepository<Batata, Integer> {
}