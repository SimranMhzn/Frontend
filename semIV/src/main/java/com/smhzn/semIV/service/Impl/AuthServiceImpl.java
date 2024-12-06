package com.smhzn.semIV.service.Impl;

import com.smhzn.semIV.model.User;
import com.smhzn.semIV.service.AuthService;
import com.smhzn.semIV.service.UserService;
import com.smhzn.semIV.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private UserService userService;
    @Override
    public String login(String username, String password, String role) {
        User user = userService.findByUsername(username);
        if (user == null || !user.getPassword().equals(password) || !user.getRole().equals(role)) {
            throw new RuntimeException("login Failed");
        } else {
            return JwtUtil.generateToken(user);
        }
    }
    //return user!=null&&user.getPassword().equals(password);

    @Override
    public boolean changePassword(String oldPassword, String newPassword) {
        return false;
    }
}

