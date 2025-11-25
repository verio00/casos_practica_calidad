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
public class EmailTest {
    
    Email validator = new Email();

    @Test
    void correoNulo_LanzaExcepcion() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> validator.isValidEmail(null));

        assertEquals("El correo no puede ser nulo o vacío", ex.getMessage());
    }

    @Test
    void correoVacio_LanzaExcepcion() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> validator.isValidEmail(""));

        assertEquals("El correo no puede ser nulo o vacío", ex.getMessage());
    }

    @Test
    void correoSinArroba_esInvalido() {
        assertFalse(validator.isValidEmail("usuario.gmail.com"));
    }

    @Test
    void dominioInvalido_esInvalido() {
        assertFalse(validator.isValidEmail("usuario@com"));
    }

    @Test
    void correoValido_esAceptado() {
        assertTrue(validator.isValidEmail("cliente123@tienda.com"));
    }

    @Test
    void parteLocalConErrores_esInvalido() {
        assertAll(
            () -> assertFalse(validator.isValidEmail(".user@correo.com")),
            () -> assertFalse(validator.isValidEmail("us..er@correo.com"))
        );
    }

}
