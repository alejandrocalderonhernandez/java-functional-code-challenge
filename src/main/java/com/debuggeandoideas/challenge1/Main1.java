package com.debuggeandoideas.challenge1;

// Main1.java — Top K Endpoints
public class Main1 {

    public static void main(String[] args) {

        TopKEndpoints solution = new TopKEndpoints();

        // caso 1 — ejemplo básico
        String[] urls1 = {"/home", "/api", "/home", "/login", "/api", "/home"};
        IO.println("Caso 1: " + solution.getTopKEndpoints(urls1, 2));
        // esperado: [/home, /api]

        // caso 2 — k igual al número de URLs únicas
        String[] urls2 = {"/products", "/home", "/products", "/cart", "/home", "/products"};
        IO.println("Caso 2: " + solution.getTopKEndpoints(urls2, 3));
        // esperado: [/products, /home, /cart]

        // caso 3 — solo una URL más visitada
        String[] urls3 = {"/api", "/api", "/api", "/login", "/home"};
        IO.println("Caso 3: " + solution.getTopKEndpoints(urls3, 1));
        // esperado: [/api]
    }
}