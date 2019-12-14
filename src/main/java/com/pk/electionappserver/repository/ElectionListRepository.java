package com.pk.electionappserver.repository;

import com.pk.electionappserver.domain.ElectionList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ElectionListRepository extends CrudRepository<ElectionList, Integer> {
    @Override
    List<ElectionList> findAll();

    Optional<ElectionList> findById(long id);

    @Override
    ElectionList save(ElectionList electionList);

    void deleteById(long id);
}
