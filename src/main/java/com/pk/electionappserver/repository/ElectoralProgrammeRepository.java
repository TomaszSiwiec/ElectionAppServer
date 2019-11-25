package com.pk.electionappserver.repository;

import com.pk.electionappserver.domain.ElectoralProgramme;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ElectoralProgrammeRepository extends CrudRepository<ElectoralProgramme, Integer> {
    @Override
    List<ElectoralProgramme> findAll();

    Optional<ElectoralProgramme> findById(Long id);

    @Override
    ElectoralProgramme save(ElectoralProgramme electoralProgramme);

    void deleteById(Long id);
}
