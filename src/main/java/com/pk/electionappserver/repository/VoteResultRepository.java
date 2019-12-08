package com.pk.electionappserver.repository;

import com.pk.electionappserver.domain.VoteResult;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VoteResultRepository extends CrudRepository<VoteResult, Integer> {
    @Override
    List<VoteResult> findAll();

    Optional<VoteResult> findById(long id);

    @Override
    VoteResult save(VoteResult voteResult);

    void deleteById(long id);
}
