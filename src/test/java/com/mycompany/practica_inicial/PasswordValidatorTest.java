/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.practica_inicial;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author VERO VICTUS
 */
public class PasswordValidatorTest {
    
    private static final int MIN_LEN = 8;
    private static final int MAX_LEN = 64;
   
    private static final String SPECIALS = "!@#$%^&*()_-+=\\{}[]|:;'<>.,?/";
    
    public static boolean isValid(String password) {
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("La contraseña no puede ser nula o vacía");
        }

        if (password.length() < MIN_LEN || password.length() > MAX_LEN) return false;

        
        if (Character.isWhitespace(password.charAt(0)) || Character.isWhitespace(password.charAt(password.length()-1))) {
       
        }

        boolean hasUpper = false, hasLower = false, hasDigit = false, hasSpecial = false;
        boolean prevWasSpace = false;

        for (char c : password.toCharArray()) {
            if (c == ' ') {
               
                if (prevWasSpace) return false;
                prevWasSpace = true;
                continue;
            } else {
                prevWasSpace = false;
            }

            if (Character.isUpperCase(c)) hasUpper = true;
            else if (Character.isLowerCase(c)) hasLower = true;
            else if (Character.isDigit(c)) hasDigit = true;
            else {
               
                if (SPECIALS.indexOf(c) >= 0) hasSpecial = true;
        
            }
        }

        return hasUpper && hasLower && hasDigit && hasSpecial;
    }
    
}
