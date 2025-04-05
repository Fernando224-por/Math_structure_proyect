/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.graphwithhashmap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author andfe
 */
public class simpleGraph {
    private Map<String, Map<String, Integer>> graph = new HashMap<>();
    public void addNodes(String node) {
        graph.putIfAbsent(node, new HashMap<>());
    }
    
    public void addEdges (String from, String to, int weight) {
        graph.putIfAbsent(to, new HashMap<>());
        graph.putIfAbsent(from, new HashMap<>());
        
        graph.get(to).put(from, weight);
        graph.get(from ).put(to, weight);
    }
    
    public void printGraph(){
        for (String node: graph.keySet()) {
            System.out.println("El nodo "+ node + " esta unido a: " + graph.get(node));
        }
    }
    
    static class Node {
        String name;
        int priority;

        Node(String name, int priority) {
            this.name = name;
            this.priority = priority;
        }        
    }
    
    public PathResult findShortestPath (String startNode, String finalNode) {
        Map<String, Integer> distance = new HashMap<>();
        Map<String, String> previus = new HashMap<>();
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n.priority));
        
        for (String node: graph.keySet()) {
            if (node.equals(startNode)) {
                distance.put(node, 0);
                queue.add(new Node(node, 0));
            } else {
                distance.put(node, Integer.MAX_VALUE);
                queue.add(new Node( node, Integer.MAX_VALUE));
            }
            previus.put(node, null);
        }
        
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            String CurrentNode = current.name;
            
            if (CurrentNode.equals(finalNode)) {
                List<String> path = new ArrayList<>();
                String step = finalNode;
                while (step != null) {
                    path.add(0, step);
                    step = previus.get(step);
                }
                return new PathResult(path, distance.get(finalNode));
            }
            if (distance.get(CurrentNode) == Integer.MAX_VALUE) break;
            
            for (Map.Entry<String, Integer> neighbor : graph.get(CurrentNode). entrySet()) {
                String neighborNode = neighbor.getKey();
                int newDist = distance.get(CurrentNode) + neighbor.getValue();
                
                if (newDist < distance.get(neighborNode)) {
                    distance.put(neighborNode, newDist);
                    previus.put(neighborNode, CurrentNode);
                    queue.add(new Node(neighborNode, newDist));
                }
            }
        }
        return new PathResult(Collections.EMPTY_LIST, Integer.MAX_VALUE);
        
    }    
    
    static class PathResult {
        List<String> path;
        int distance;

        PathResult(List<String> path, int distance) {
            this.path = path;
            this.distance = distance;
        }

        @Override
        public String toString() {
            return "Camino: " + path + ", Distancia: " + distance;
        }
    }
}

