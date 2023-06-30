package com.neu.aqimanagementsystem.sercice;

public interface PasswordEncryptionService {

    String encryptPassword(String password);

    boolean checkPassword(String password, String hashedPassword);

}
