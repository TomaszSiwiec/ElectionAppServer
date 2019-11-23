package com.pk.electionappserver.electionappserver.repository;

import com.pk.electionappserver.electionappserver.domain.Report;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReportRepository extends CrudRepository<Report, Integer> {
    @Override
    List<Report> findAll();

    Optional<Report> findById(Long id);

    @Override
    Report save(Report report);

    void deleteById();
}
