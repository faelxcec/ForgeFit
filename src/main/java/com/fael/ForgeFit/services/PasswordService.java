package com.fael.ForgeFit.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordService {
    public PasswordService() {
    }
    public String encryptPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
    public boolean checkPassword(String password, String hashedPassword) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(password, hashedPassword);
    }
}
