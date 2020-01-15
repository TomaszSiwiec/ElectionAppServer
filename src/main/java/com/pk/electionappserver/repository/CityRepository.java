package com.pk.electionappserver.repository;

import com.pk.electionappserver.domain.City;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CityRepository extends CrudRepository<City, Integer> {
    @Override
    List<City> findAll();

    Optional<City> findById(long id);

    @Override
    City save(City city);

    void deleteById(long id);
}
