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


public class EJERCICIO_1Test {
    
    @BeforeEach
    void setup(){
        new EJERCICIO_1();
    }
    
    @Test
    void passwordValidaDebeRetornarTrue() {
        assertTrue(EJERCICIO_1.isValid("Secure123!"));
    }

    @Test
    void passwordNullLanzaIllegalArgumentException() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
            () -> EJERCICIO_1.isValid(null));
        assertEquals("La contraseña no puede ser nula o vacía", ex.getMessage());
    }

    @Test
    void passwordVaciaLanzaIllegalArgumentException() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
            () -> EJERCICIO_1.isValid(""));
        assertEquals("La contraseña no puede ser nula o vacía", ex.getMessage());
    }

    @Test
    void passwordDemasiadoCortaRetornaFalse() {
        assertFalse(EJERCICIO_1.isValid("Ab1!cd")); 
    }

    @Test
    void passwordSinMayusculaONumeroRetornaFalse() {
        assertFalse(EJERCICIO_1.isValid("nosecura!")); 
    }

    @Test
    void passwordConEspacioSimpleEnMedioEsValida() {
        assertTrue(EJERCICIO_1.isValid("Abc 123!d")); 
    }

    @Test
    void passwordConEspaciosConsecutivosRetornaFalse() {
        assertFalse(EJERCICIO_1.isValid("Abc  123!d")); 
    }

    @Test
    void passwordSinCaracterEspecialRetornaFalse() {
        assertFalse(EJERCICIO_1.isValid("Abcdefg1")); 
    }

    @Test
    void passwordConCaracterEspecialNoPermitidoRetornaFalse() {
        assertFalse(EJERCICIO_1.isValid("Abcdef1~")); 
    }

    @Test
    void passwordConEspacioInicialRetornaTrueConImplementacionActual() {
        String resultadoEsperado = "La contraseña no puede contener espacio al inicio o al final";
        
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> EJERCICIO_1.isValid(" secura123"));
        
        IllegalArgumentException ex2 = assertThrows(IllegalArgumentException.class,
                () -> EJERCICIO_1.isValid("secura123 "));   
        
        assertAll(
                () -> assertEquals(resultadoEsperado, ex.getMessage()),
                () -> assertEquals(resultadoEsperado, ex2.getMessage())
        );
    }

    @Test
    void passwordQueExcedeLongitudMaximaRetornaFalse() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 65; i++) {
            sb.append('A');
        }
        assertFalse(EJERCICIO_1.isValid(sb.toString()));
    }

    @Test
    void agrupadas_variasValidaciones_assertAll() {
        assertAll(
            () -> assertFalse(EJERCICIO_1.isValid("abcdefgh")),  
            () -> assertFalse(EJERCICIO_1.isValid("ABCDEFGH")),  
            () -> assertFalse(EJERCICIO_1.isValid("Abcdefgh")),  
            () -> assertTrue(EJERCICIO_1.isValid("Abcdef1!"))    
        );
    }
}
