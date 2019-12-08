package com.pk.electionappserver.repository;

import com.pk.electionappserver.domain.Candidate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CandidateRepository extends CrudRepository<Candidate, Integer> {
    @Override
    List<Candidate> findAll();

    Optional<Candidate> findById(long id);

    @Override
    Candidate save(Candidate candidate);

    void deleteById(long id);
}
