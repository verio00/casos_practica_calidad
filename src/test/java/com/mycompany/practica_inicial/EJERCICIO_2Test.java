/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.practica_inicial;

import java.util.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class EJERCICIO_2Test {
    
    @Test
    void cantidadMayorA1000_lanzaExcepcionMensajeCorrecto() {
        EJERCICIO_2 inv = new EJERCICIO_2();

        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> inv.addItem("Monitor", 1500)
        );

        assertEquals("La cantidad máxima permitida es 1000", ex.getMessage());
    }
    
    @Test
    void cantidadNegativa_lanzaExcepcionMensajeCorrecto() {
        EJERCICIO_2 inv = new EJERCICIO_2();

        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> inv.addItem("Mouse", -1)
        );

        assertEquals("La cantidad debe ser mayor que 0", ex.getMessage());
    }   

    @Test
    void nombreMuyCorto_lanzaExcepcionMensajeCorrecto() {
        EJERCICIO_2 inv = new EJERCICIO_2();

        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> inv.addItem("A", 3)
        );

        assertEquals(
                "El nombre del producto debe tener entre 2 y 50 caracteres",
                ex.getMessage()
        );
    }
    

    @Test
    void nombreMuyLargo_lanzaExcepcionMensajeCorrecto() {
        EJERCICIO_2 inv = new EJERCICIO_2();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 51; i++) {
            sb.append('A');
        }
        
        String entrada = sb.toString();        

        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> inv.addItem(entrada, 3)
        );

        assertEquals(
                "El nombre del producto debe tener entre 2 y 50 caracteres",
                ex.getMessage()
        );
    }
    
    @Test
    void nombreVacio_lanzaExcepcionMensajeCorrecto() {
        EJERCICIO_2 inv = new EJERCICIO_2();

        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> inv.addItem("", 5)
        );

        assertEquals("El nombre del producto no puede estar vacío", ex.getMessage());
    }
    
    @Test
    void agregarProductoNuevo_valido() {
        EJERCICIO_2 inv = new EJERCICIO_2();

        inv.addItem("Laptop", 5);

        assertEquals(5, inv.getQuantity("Laptop"));
    }
    
    
    @Test
    void cantidadCero_lanzaExcepcionMensajeCorrecto() {
        EJERCICIO_2 inv = new EJERCICIO_2();

        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> inv.addItem("Mouse", 0)
        );

        assertEquals("La cantidad debe ser mayor que 0", ex.getMessage());
    }
    


    @Test
    void nombreNulo_lanzaExcepcionMensajeCorrecto() {
        EJERCICIO_2 inv = new EJERCICIO_2();

        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> inv.addItem(null, 5)
        );

        assertEquals("El nombre del producto no puede estar vacío", ex.getMessage());
    
    }

}
