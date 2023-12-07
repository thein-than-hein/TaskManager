package com.example.TaskManager.services;

import com.example.TaskManager.entities.User;
import com.example.TaskManager.repositories.UserRepository;
import org.hibernate.PropertyValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) throws PropertyValueException {
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String userId) throws NoSuchElementException {
        Optional<User> found = userRepository.findById(Integer.valueOf(userId));
        if (found.isPresent()) return found.get();
        throw new NoSuchElementException();
    }

    public void deleteById(String userId) {
        userRepository.deleteById(Integer.valueOf(userId));
    }
}
