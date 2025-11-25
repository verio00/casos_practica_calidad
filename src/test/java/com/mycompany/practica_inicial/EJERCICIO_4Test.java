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


public class EJERCICIO_4Test {
    
    @BeforeEach
    void setup(){
        new EJERCICIO_4();
    }
    
    @Test
    public void textoValidoSimple(){
        String resultadoEsperado = "ALOH";
        
        String resultadoObtenido = EJERCICIO_4.reverseAndCapitalize("hola");
        
        assertEquals(resultadoEsperado, resultadoObtenido);        
    }
    
    @Test
    public void textoValidoConEspaciosAlInicioFinal(){
        String resultadoEsperado = "ALOH";
        
        String resultadoObtenido = EJERCICIO_4.reverseAndCapitalize(" hola ");
        
        assertEquals(resultadoEsperado, resultadoObtenido);  
    }
    
    @Test
    public void textoConEspaciosInternosYmayusMinus(){
        String resultadoEsperado = "AL OH";
        
        String resultadoObtenido = EJERCICIO_4.reverseAndCapitalize("Ho La");
        
        assertEquals(resultadoEsperado, resultadoObtenido);
    }
    
    @Test
    public void textoNulo(){
        String resultadoEsperado = "El texto no puede ser nulo";
        
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> EJERCICIO_4.reverseAndCapitalize(null));
        
        assertEquals(resultadoEsperado, ex.getMessage());
    }
    
    @Test
    public void textoVacio(){
        String resultadoEsperado = "El texto no puede estar vacío o contener solo espacios";
        
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> EJERCICIO_4.reverseAndCapitalize(""));
        
        assertEquals(resultadoEsperado, ex.getMessage());        
    }
    
    @Test
    public void textoConSoloEspacios(){
        String resultadoEsperado = "El texto no puede estar vacío o contener solo espacios";
        
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> EJERCICIO_4.reverseAndCapitalize(" "));
        
        assertEquals(resultadoEsperado, ex.getMessage());   
    }
    
    @Test
    public void textoConLongitudQueSuperaElLimite(){
        String resultadoEsperado = "El texto excede el límite de 1000 caracteres";
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1001; i++) {
            sb.append('A');
        }
        String input = sb.toString();
        
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> EJERCICIO_4.reverseAndCapitalize(input));
        
        assertEquals("El texto excede el límite de 1000 caracteres", ex.getMessage());
        
    }
    
    @Test
    public void textoConLongitudExacta(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 250; i++) {
            sb.append("hola");
        }
        String entrada = sb.toString();
        
        StringBuilder sb2 = new StringBuilder();
        for(int i = 0; i< 250; i++){
            sb2.append("ALOH");
        }
        String resultadoEsperado = sb2.toString();
        
        String resultadoObtenido = EJERCICIO_4.reverseAndCapitalize(entrada);
        
        assertEquals(resultadoEsperado, resultadoObtenido);
        
    }
}
