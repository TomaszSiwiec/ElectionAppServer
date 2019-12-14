package com.pk.electionappserver.repository;

import com.pk.electionappserver.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    @Override
    List<User> findAll();

    Optional<User> findById(long id);

    @Override
    User save(User user);

    void deleteById(long id);
}
