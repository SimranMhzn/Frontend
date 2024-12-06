package com.smhzn.semIV.controller;

import com.smhzn.semIV.dto.LoginDto;
import com.smhzn.semIV.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public Map<String,String> login (@RequestBody LoginDto loginDto){

        String isSuccess = authService.login(loginDto.username(), loginDto.password(), loginDto.role());
        return Map.of("Token",isSuccess);
    }
}
