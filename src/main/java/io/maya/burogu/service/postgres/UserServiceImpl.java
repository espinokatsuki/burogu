package io.maya.burogu.service.postgres;

import io.maya.burogu.model.User;
import io.maya.burogu.repository.UserRepository;
import io.maya.burogu.service.IUserService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Primary
@Service
public class UserServiceImpl implements IUserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getAllActives() {
        return userRepository.findByActiveIsTrue();
    }

    @Override
    public Optional<User> getById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> getByUserNameAndEmail(String userName, String email) {
        return userRepository.findByUserNameAndEmail(userName, email);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void disable(User user) {

    }
}
