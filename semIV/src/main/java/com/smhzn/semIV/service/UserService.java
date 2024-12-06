package com.smhzn.semIV.service;

import com.smhzn.semIV.model.User;

import java.util.List;

public interface UserService{//METHODS HARU DEFINE GAREKO
    User add (User user);
    List<User> getAll();
    User findByUsername(String username);
    void deleteById(int id);
    User updateUser(User user,int id);
    User getById(int id);
    User getCurrentUser();
}