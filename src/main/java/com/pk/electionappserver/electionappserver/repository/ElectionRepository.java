package com.pk.electionappserver.electionappserver.repository;

import com.pk.electionappserver.electionappserver.domain.Election;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ElectionRepository extends CrudRepository<Election, Integer> {
    @Override
    List<Election> findAll();

    Optional<Election> findById(Long id);

    @Override
    Election save(Election election);

    void deleteById(Long id);
}
