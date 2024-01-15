package com.example.forumapi.service.impl;

import com.example.forumapi.entity.Role;
import com.example.forumapi.entity.User;
import com.example.forumapi.config.ResourceNotExisted;
import com.example.forumapi.repository.UserRepository;
import com.example.forumapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public UserDetailsService userDetailsService(){
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
                return userRepository.findByEmail(username);
            }
        };
    }

    @Override
    public User updateToModerator(long id) {
        User u = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotExisted("user",
                        "Id", id));
        u.setRole(Role.MODERATOR);
        userRepository.save(u);
        return u;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getUserInfo(String username) {
        return userRepository.findUserByEmail(username);
    }


}
