package com.pk.electionappserver.electionappserver.repository;

import com.pk.electionappserver.electionappserver.domain.Candidate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface CandidateRepository extends CrudRepository<Candidate, Integer> {
    @Override
    List<Candidate> findAll();

    Optional<Candidate> findById(Long id);

    @Override
    Candidate save(Candidate candidate);

    void deleteById(Long id);
}
