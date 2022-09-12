package com.deft.service;

import com.deft.entity.User;

import java.util.List;

public interface UserService {
    User create(User user);
    User update(Long id, User user);
    void delete(Long id);
    User findById(Long id);
    Iterable<User> findAll();
}
