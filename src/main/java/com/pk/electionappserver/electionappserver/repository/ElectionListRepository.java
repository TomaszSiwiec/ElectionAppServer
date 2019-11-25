package com.pk.electionappserver.electionappserver.repository;

import com.pk.electionappserver.electionappserver.domain.ElectionList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ElectionListRepository extends CrudRepository<ElectionList, Integer> {
    @Override
    List<ElectionList> findAll();

    Optional<ElectionList> findById(Long id);

    @Override
    ElectionList save(ElectionList electionList);

    void deleteById(Long id);
}
