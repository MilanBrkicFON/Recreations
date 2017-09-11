/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.password.hashing;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Milan
 */
public class PasswordHashing {

    private static final String SALT = "moj-salt-tekst";
    private final String password;

    public PasswordHashing(String password) {
        this.password = password;
    }


    public String generateHash() {
        String saltedPassword = SALT + password;
        StringBuilder sb = new StringBuilder();

        try {
            MessageDigest sha2 = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = sha2.digest(saltedPassword.getBytes());
            char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

            for (int i = 0; i < hashedBytes.length; i++) {
                byte b = hashedBytes[i];
                sb.append(digits[(b & 0xf0) >> 4]);
                sb.append(digits[b & 0x0f]);
            }
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(PasswordHashing.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Ne postoji algoritam!!!");
        }
        return sb.toString();
    }
}
