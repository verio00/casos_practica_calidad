/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica_inicial;


public class EJERCICIO_4 {
    
    public static String reverseAndCapitalize(String input) {

        if (input == null) {
            throw new IllegalArgumentException("El texto no puede ser nulo");
        }

        String trimmed = input.trim();

        if (trimmed.isEmpty()) {
            throw new IllegalArgumentException("El texto no puede estar vacío o contener solo espacios");
        }

        if (trimmed.length() > 1000) {
            throw new IllegalArgumentException("El texto excede el límite de 1000 caracteres");
        }

        String reversed = new StringBuilder(trimmed).reverse().toString();

        return reversed.toUpperCase();
    }   
}
