/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica_inicial;

/**
 *
 * @author VERO VICTUS
 */
public class Email {

    public boolean isValidEmail(String email) {

        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("El correo no puede ser nulo o vacío");
        }

        // Longitud mínima y máxima
        if (email.length() < 6 || email.length() > 254) {
        
        }

        // Debe contener exactamente un @
        if (!email.contains("@") || email.indexOf("@") != email.lastIndexOf("@")) {
            return false;
        }

        String[] parts = email.split("@");
        if (parts.length != 2) return false;

        String local = parts[0];
        String domain = parts[1];

        // Validar parte local
        if (local.startsWith(".") || local.endsWith(".")) return false;
        if (local.contains("..")) return false;
        if (!local.matches("[A-Za-z0-9._-]+")) return false;

        // Validar dominio
        if (!domain.contains(".")) return false;

        int lastDot = domain.lastIndexOf(".");
        String dominioNombre = domain.substring(0, lastDot);
        String extension = domain.substring(lastDot + 1);

        if (dominioNombre.length() < 2) return false;
        if (!extension.matches("[A-Za-z]{2,6}")) return false;

        return true;
    }
}