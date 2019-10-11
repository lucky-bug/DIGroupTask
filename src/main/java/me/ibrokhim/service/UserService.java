package me.ibrokhim.service;

import me.ibrokhim.entity.User;
import me.ibrokhim.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository taskRepository) {
        this.userRepository = taskRepository;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(UUID id) {
        return userRepository.getOne(id);
    }

    public User insert(User user) {
        return userRepository.save(user);
    }

    public User update(User user) {
        return userRepository.save(user);
    }

    public User delete(UUID id) {
        User user = userRepository.getOne(id);

        if (user != null) {
            userRepository.delete(user);
        }

        return null;
    }
}
