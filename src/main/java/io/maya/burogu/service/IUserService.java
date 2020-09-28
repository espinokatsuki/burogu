package io.maya.burogu.service;

import io.maya.burogu.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> getAll();

    List<User> getAllActives();

    Optional<User> getById(Integer id);

    Optional<User> getByUserNameAndEmail(String userName, String email);

    User save(User user);

    void disable(User user);
}
