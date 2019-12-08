package com.pk.electionappserver.repository;

import com.pk.electionappserver.domain.ElectoralParty;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ElectoralPartyRepository extends CrudRepository<ElectoralParty, Integer> {
    @Override
    List<ElectoralParty> findAll();

    Optional<ElectoralParty> findById(long id);

    @Override
    ElectoralParty save(ElectoralParty electoralParty);

    void deleteById(long id);
}
