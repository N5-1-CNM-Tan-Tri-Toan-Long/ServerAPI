package com.n5_qlsv.service;

import com.n5_qlsv.entity.LopHoc;
import com.n5_qlsv.entity.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    User findUserById(Long userId);
    List<User> findAllUser();
    void deleteUserById(Long userId);
    User updateUserById(Long userId, User user);
}
