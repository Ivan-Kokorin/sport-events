package com.application.sport.service;

import com.application.sport.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public void save(User user);
    public boolean isExist(Long id);
    public User findByUsername(String name);
    public List<User> getAllUser();
}
