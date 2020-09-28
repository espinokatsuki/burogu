package io.maya.burogu.repository;

import io.maya.burogu.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUserNameAndEmail(String userName, String email);

    List<User> findByActiveIsTrue();
}
