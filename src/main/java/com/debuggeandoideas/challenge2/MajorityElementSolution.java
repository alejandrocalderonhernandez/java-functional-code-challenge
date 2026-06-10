package com.debuggeandoideas.challenge2;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.stream.IntStream;

public class MajorityElementSolution {

    /**
     * Dado un arreglo de enteros de tamaño n,
     * retorna el elemento que aparece más de n/2 veces.
     * Se garantiza que siempre existe.
     * Entrada:  int[] nums
     * Salida:   int
     * Ejemplo:
     *   nums = [3, 2, 3]           → 3
     *   nums = [2, 2, 1, 1, 1, 2, 2] → 2
     *   nums = [-1, 100, 2, 100, 100, -1, 100] → 100
     */
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> mapCount = new HashMap<>();

        IntStream.of(nums).forEach(currentNum -> {
            BinaryOperator<Integer> plusOne = Integer::sum;
            mapCount.merge(currentNum, 1, plusOne);
        });

        return mapCount.entrySet().stream()
                .max((entry1, entry2) ->
                        Integer.compare(entry1.getValue(), entry2.getValue()))
                .orElseThrow()
                .getKey();
    }
}