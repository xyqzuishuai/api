package com.neu.aqimanagementsystem.sercice.impl;

import com.neu.aqimanagementsystem.sercice.PasswordEncryptionService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordEncryptionServicelmpl implements PasswordEncryptionService {

//    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    public String encryptPassword(String password) {
        String salt = BCrypt.gensalt(10);
        return BCrypt.hashpw(password, salt);
    }

    public boolean checkPassword(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }

}
