package com.n5_qlsv.service.Impl;

import com.n5_qlsv.entity.User;
import com.n5_qlsv.repository.UserRepository;
import com.n5_qlsv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        user.setUserId(0);
        return userRepository.save(user);
    }

    @Override
    public User findUserById(Long userId) {
        return userRepository.findById(userId).get();
    }

    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUserById(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public User updateUserById(Long userId, User user) {
        user.setUserId(userId);
        return userRepository.save(user);
    }
}
