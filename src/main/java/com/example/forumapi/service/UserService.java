package com.example.forumapi.service;

import com.example.forumapi.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService {
     UserDetailsService userDetailsService();
    User updateToModerator(long id);
    List<User> getAll();
    User getUserInfo(String email);
}
