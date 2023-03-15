package com.tutorial.batata.repository;

import com.tutorial.batata.model.batata.Batata;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.exact;

@Repository
public interface BatataRepository extends JpaRepository<Batata, Integer>, QueryByExampleExecutor<Batata>, JpaSpecificationExecutor<Batata>, SpecificationUtils<Batata> {

    /**
     * @return a little bit more complex matcher removing dtUpdate and setting values to contains (Like) matcher, ignore case and ignores all null values
     */
    default ExampleMatcher pageableMatcher() {
        return ExampleMatcher.matching()
                             .withIgnorePaths("dtUpdate")
                             .withMatcher("name", contains().ignoreCase())
                             .withMatcher("type", contains().ignoreCase());
    }

    /**
     * @return a simple matcher examples, removing dtUpdate and setting values to exact matcher and ignores all null
     */
    default ExampleMatcher simpleMatcher() {
        return ExampleMatcher.matching()
                .withIgnorePaths("dtUpdate")
                .withMatcher("name", exact())
                .withMatcher("type", exact());
    }
}