package com.smhzn.semIV.service.Impl;

import com.smhzn.semIV.model.User;
import com.smhzn.semIV.repository.UserRepository;
import com.smhzn.semIV.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User add(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void deleteById(int id) {
        getById(id);
        userRepository.deleteById(id);
    }

    @Override
    public User updateUser(User user, int id) {
        getById(id);
        user.setUserId(id);//update garda id chutyo bhane pani previous id nai set gardincha
        return null;
    }

    @Override
    public User getById(int id) { //database bata value lincha, cha bhane value dincha, chaina bhane error faldincha
        Optional<User> optionalUser = userRepository.findById(id);
        User user = optionalUser.orElseThrow((() -> new RuntimeException("User not found")));
        return user;
    }

    @Override
    public User getCurrentUser() {
        // Fetch the principal from SecurityContextHolder
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            String username = ((UserDetails) principal).getUsername();
            // Retrieve user by username
            return userRepository.findByUsername(username);
        }

        throw new RuntimeException("User is not authenticated");
    }

}
