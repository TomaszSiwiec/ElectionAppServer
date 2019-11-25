package com.pk.electionappserver.repository;

import com.pk.electionappserver.domain.Constituency;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConstituencyRepository extends CrudRepository<Constituency, Integer> {
    @Override
    List<Constituency> findAll();

    Optional<Constituency> findById(Long id);

    @Override
    Constituency save(Constituency constituency);

    void deleteById(Long id);
}
