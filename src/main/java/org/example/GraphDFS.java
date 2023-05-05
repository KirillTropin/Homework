package org.example;

import java.util.Iterator;
import java.util.LinkedList;

public class GraphDFS extends Graph{
    private int numVertices;
    private LinkedList<Integer> adjLists[];
    private boolean visited[];

    GraphDFS(int vertices) {
        numVertices = vertices;
        adjLists = new LinkedList[vertices];
        visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++)
            adjLists[i] = new LinkedList<Integer>();
    }

    void addEdge(int src, int dest) {
        adjLists[src].add(dest);
    }

    void DFS(int vertex) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        Iterator ite = adjLists[vertex].listIterator();
        while (ite.hasNext()) {
            int adj = (Integer) ite.next();
            if (!visited[adj])
                DFS(adj);
        }
    }
}
