package com.smhzn.semIV.service;

import com.smhzn.semIV.model.User;

public interface AuthService {
    String login(String username, String password, String role);
    boolean changePassword(String oldpassword, String newpassword);
}
