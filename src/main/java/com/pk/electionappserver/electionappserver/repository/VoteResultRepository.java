package com.pk.electionappserver.electionappserver.repository;

import com.pk.electionappserver.electionappserver.domain.VoteResult;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VoteResultRepository extends CrudRepository<VoteResult, Integer> {
    @Override
    List<VoteResult> findAll();

    Optional<VoteResult> findById(Long id);

    @Override
    VoteResult save(VoteResult voteResult);

    void deleteById(Long id);
}
