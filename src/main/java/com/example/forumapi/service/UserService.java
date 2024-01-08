package com.example.forumapi.service;

import com.example.forumapi.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService {
     UserDetailsService userDetailsService();
}
