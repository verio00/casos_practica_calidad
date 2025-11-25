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


public class EJERCICIO_3Test {
    
    private final EJERCICIO_3 validator = new EJERCICIO_3();

    private String generarCadena(int longitud) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < longitud; i++) {
            sb.append('a');
        }
        return sb.toString();
    }

    @Test
    void caso1_correoValido_retornaTrue() {
        assertTrue(validator.isValidEmail("cliente123@tienda.com"));
    }

    @Test
    void caso2_correoNuloOVacio_lanzaExcepcion() {
        assertAll(
            () -> {
                IllegalArgumentException ex = assertThrows(
                        IllegalArgumentException.class,
                        () -> validator.isValidEmail(null)
                );
                assertEquals("El correo no puede ser nulo o vacío", ex.getMessage());
            },
            () -> {
                IllegalArgumentException ex = assertThrows(
                        IllegalArgumentException.class,
                        () -> validator.isValidEmail("")
                );
                assertEquals("El correo no puede ser nulo o vacío", ex.getMessage());
            },
            () -> {
                IllegalArgumentException ex = assertThrows(
                        IllegalArgumentException.class,
                        () -> validator.isValidEmail("    ")
                );
                assertEquals("El correo no puede ser nulo o vacío", ex.getMessage());
            }
        );
    }

    @Test
    void caso3_correoSinArroba_retornaFalse() {
        assertAll(
            () -> assertFalse(validator.isValidEmail("Vero.edu.pe")),
            () -> assertFalse(validator.isValidEmail("usuario.gmail.com"))
        );
    }

    @Test
    void caso4_correoConMultiplesArrobas_retornaFalse() {
        assertFalse(validator.isValidEmail("user@@dominio.com"));
    }

    @Test
    void caso5_puntosOExtensionInvalidos_retornaFalse() {
        assertAll(
            () -> assertFalse(validator.isValidEmail("cliente123@tienda.com.")),
            () -> assertFalse(validator.isValidEmail(".user@correo.com")),
            () -> assertFalse(validator.isValidEmail("user.@correo.com")),
            () -> assertFalse(validator.isValidEmail("us..er@correo.com"))
        );
    }

    @Test
    void caso6_tamanoInvalido_retornaFalse() {
        assertFalse(validator.isValidEmail("vvrm"));

        String localLargo = generarCadena(251);
        String emailMuyLargo = localLargo + "@a.c";
        assertFalse(validator.isValidEmail(emailMuyLargo));
    }

    @Test
    void caso7_dominioInvalido_retornaFalse() {
        assertAll(
            () -> assertFalse(validator.isValidEmail("usuario@com")),
            () -> assertFalse(validator.isValidEmail("user@a.com"))
        );
    }

    @Test
    void caso8_parteLocalConCaracteresInvalidos_retornaFalse() {
        assertFalse(validator.isValidEmail("us!er@correo.com"));
    }   
}
