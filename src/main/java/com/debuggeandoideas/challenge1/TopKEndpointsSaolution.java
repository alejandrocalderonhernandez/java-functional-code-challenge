package com.debuggeandoideas.challenge1;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopKEndpointsSaolution {


    /**
     * Dado un arreglo de URL's y un número k,
     * retorna las K URL's más visitadas ordenadas
     * de mayor a menor frecuencia.
     * Entrada:  String[] urls, int k
     * Salida:   List<String>
     * Ejemplo:
     *   urls = ["/home", "/api", "/home", "/login", "/api", "/home", "/logout"]
     *   k  = 3
     *   resultado = ["/home", "/api"]
     */
    public List<String> getTopKEndpoints(String[] urls, int k) {
      return Arrays.stream(urls)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ))
              .entrySet().stream()
              .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
              .limit(k)
              .map(Map.Entry::getKey)
              .toList();
    }
}
