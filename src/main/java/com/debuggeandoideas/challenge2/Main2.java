package com.debuggeandoideas.challenge2;

// Main2.java — Majority Element
public class Main2 {

    public static void main(String[] args) {

        MajorityElement solution = new MajorityElement();

        // caso 1 — ejemplo básico
        int[] test1 = {3, 2, 3};
        IO.println("Caso 1: " + solution.majorityElement(test1));
        // esperado: 3

        // caso 2 — arreglo más largo
        int[] test2 = {2, 2, 1, 1, 1, 2, 2};
        IO.println("Caso 2: " + solution.majorityElement(test2));
        // esperado: 2

        // caso 3 — números negativos
        int[] test3 = {-1, 100, 2, 100, 100, -1, 100};
        IO.println("Caso 3: " + solution.majorityElement(test3));
        // esperado: 100
    }
}