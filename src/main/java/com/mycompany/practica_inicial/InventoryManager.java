/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica_inicial;


import java.util.HashMap;
import java.util.Map;

public class InventoryManager {

    private Map<String, Integer> inventory = new HashMap<>();

    public void addItem(String item, int quantity) {
        if (item == null || item.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del producto no puede estar vacío");
        }

        if (item.length() < 2 || item.length() > 50) {
            throw new IllegalArgumentException("El nombre del producto debe tener entre 2 y 50 caracteres");
        }

        if (quantity <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que 0");
        }

        if (quantity > 1000) {
            throw new IllegalArgumentException("La cantidad máxima permitida es 1000");
        }

        inventory.put(item, inventory.getOrDefault(item, 0) + quantity);
    }

    public int getQuantity(String item) {
        return inventory.getOrDefault(item, 0);
    }

    public Map<String, Integer> getInventory() {
        return inventory;
    }
}

