/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.graphwithhashmap;

/**
 *
 * @author andfe
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.File;
import java.io.IOException;

public class GraphWithHashMap {
    
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        simpleGraph g = new simpleGraph();
        
        File myFile = new File("testFile.json");
        
        if (myFile.exists()) {
            JsonNode readJson = objectMapper.readTree(new File("testFile.json"));
            JsonNode ubicaciones = readJson.get("Puntos");
            for (JsonNode ubicacion : ubicaciones) {
                String from = ubicacion.get("from").asText();
                String to = ubicacion.get("to").asText();
                Double weight = ubicacion.get("weight").asDouble();
                
                g.addEdges(from, to, weight);
                
                System.out.println("Los nodos " + from + " y " + to + " han sido añadidos");
                
            }
        } else {
            System.out.println("El archivo no existe");
        }
        
        simpleGraph.PathResult resultTestOne = g.findShortestPath("Casa", "Konrad_lorenz");
        System.out.println("El camino mas corto posible es: ");
        System.out.println(resultTestOne);
        
    }
}
