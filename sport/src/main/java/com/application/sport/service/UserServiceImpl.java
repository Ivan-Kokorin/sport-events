package com.application.sport.service;

import com.application.sport.model.User;
import com.application.sport.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public boolean isExist(Long id) {
        List<User> allUser = getAllUser();
        User user = allUser.stream().filter(s -> s.getId() == id).findFirst().orElse(null);
        if(user != null) {
            return true;
        }
        return false;
    }

    @Override
    public User findByUsername(String name) {
        List<User> allUser = getAllUser();
        User user = allUser.stream().filter(u -> u.getUsername().equals(name)).findFirst().orElse(null);
        if(user != null) {
            return user;
        }
        return null;
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}
