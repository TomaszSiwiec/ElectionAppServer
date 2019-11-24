package com.pk.electionappserver.electionappserver.repository;

import com.pk.electionappserver.electionappserver.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    @Override
    List<User> findAll();

    Optional<User> findById(Long id);

    @Override
    User save(User user);

    void deleteById(Long id);
}
