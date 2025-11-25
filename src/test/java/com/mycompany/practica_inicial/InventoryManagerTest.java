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

/**
 *
 * @author VERO VICTUS
 */
public class InventoryManagerTest {
    
    //CASO 1
    @Test
    void cantidadMayorA1000_lanzaExcepcion() {
        InventoryManager inv = new InventoryManager();
        assertThrows(IllegalArgumentException.class, () -> inv.addItem("Monitor", 1500));
    }
    
    //caso 2
    @Test
    void agregarCantidadNegativa_lanzaExcepcion() {
        InventoryManager inv = new InventoryManager();
        assertThrows(IllegalArgumentException.class,
                () -> inv.addItem("Mouse", -1));
    }

    //CASO 3
    @Test
    void validarLongitudNombre_productoMuyCortoOMuyLargo() {
        InventoryManager inv = new InventoryManager();
        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> inv.addItem("A", 3)),
                () -> assertThrows(IllegalArgumentException.class, () -> inv.addItem("A".repeat(51), 3))
        );
    }
    
    //caso 5
    @Test
    void agregarItemNuevo_stockCorrecto() {
        InventoryManager inv = new InventoryManager();
        inv.addItem("Laptop", 5);
        assertEquals(5, inv.getQuantity("Laptop"));
    }
    

    
    //caso 4
    @Test
    void agregarNombreVacio_lanzaExcepcionConMensajeCorrecto() {
        InventoryManager inv = new InventoryManager();
        IllegalArgumentException ex =
                assertThrows(IllegalArgumentException.class,
                        () -> inv.addItem("", 5));
        assertEquals("El nombre del producto no puede estar vacío", ex.getMessage());
    }

    @Test
    void agregarDosVecesMismoItem_sumaCantidad() {
        InventoryManager inv = new InventoryManager();
        inv.addItem("Teclado", 3);
        inv.addItem("Teclado", 2);
        assertEquals(5, inv.getQuantity("Teclado"));
    }



}
