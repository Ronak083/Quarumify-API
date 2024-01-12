package com.example.forumapi.Dao;

import lombok.Data;

@Data
public class JwtAuthUserDetails {
    private String username;
    private String userRole;
}
