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
    
    @Test
    void passwordValidaDebeRetornarTrue() {
        assertTrue(PasswordValidator.isValid("Secure123!"));
    }

    @Test
    void passwordNullLanzaIllegalArgumentException() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
            () -> PasswordValidator.isValid(null));
        assertEquals("La contraseña no puede ser nula o vacía", ex.getMessage());
    }

    @Test
    void passwordDemasiadoCortaRetornaFalse() {
        assertFalse(PasswordValidator.isValid("Ab1!cd")); // <8
    }

    @Test
    void passwordSinMayusculaONumeroRetornaFalse() {
        assertFalse(PasswordValidator.isValid("nosecura!")); 
    }

    @Test
void passwordConEspaciosConsecutivosRetornaFalse_yConEspacioSimpleValido() {
    assertFalse(PasswordValidator.isValid("Abc  123!d")); 
    assertTrue(PasswordValidator.isValid("AbcA123!d"));   
}

    @Test
    void agrupadas_variasValidaciones_assertAll() {
        assertAll(
            () -> assertFalse(PasswordValidator.isValid("abcdefgh")),        
            () -> assertFalse(PasswordValidator.isValid("ABCDEFGH")),         
            () -> assertFalse(PasswordValidator.isValid("Abcdefgh")),        
            () -> assertTrue(PasswordValidator.isValid("Abcdef1!"))           
        );
    }
    
    
}
