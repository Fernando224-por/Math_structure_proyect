/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.graphwithhashmap;

/**
 *
 * @author andfe
 */

public class GraphWithHashMap {
    
    public static void main(String[] args) {
        simpleGraph g = new simpleGraph();
        g.addEdges("A", "B", 4);
        g.addEdges("A", "C", 2);
        g.addEdges("B", "E", 3);
        g.addEdges("C", "D", 2);
        g.addEdges("C", "F", 4);
        g.addEdges("D", "F", 1);
        g.addEdges("E", "G", 2);
        g.addEdges("F", "G", 1);
        
        simpleGraph.PathResult resultTestOne = g.findShortestPath("A", "G");
        System.out.println(resultTestOne);
        
        simpleGraph.PathResult resultTestTwo = g.findShortestPath("B", "D");
        System.out.println(resultTestTwo);
        
        simpleGraph.PathResult resultTestThree = g.findShortestPath("C", "F");
        System.out.println(resultTestThree);
        
    }
}
