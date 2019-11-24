package com.pk.electionappserver.electionappserver.repository;

import com.pk.electionappserver.electionappserver.domain.ElectionType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ElectionTypeRepository extends CrudRepository<ElectionType, Integer> {
    @Override
    List<ElectionType> findAll();

    Optional<ElectionType> findById(Long id);

    @Override
    ElectionType save(ElectionType electionType);

    void deleteById(Long id);
}
