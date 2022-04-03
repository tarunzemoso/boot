package com.tarun.service;

import com.tarun.entity.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();

    public User findByUserName(String userName);

    public void save(User theUser);

    public void deleteByUserName(String theUserName);

    public void register(User user);
}
