package org.example;

import java.util.ArrayList;
import java.util.List;

public class GraphBFS extends Graph{
    // Список списков для представления списка смежности
    public List<List<Integer>> adjList = null;

    // Конструктор
    public GraphBFS(List<Edge> edges, int n) {
        adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        // добавляем ребра в неориентированный graph
        for (Edge edge : edges) {
            int src = edge.source;
            int dest = edge.dest;

            adjList.get(src).add(dest);
            adjList.get(dest).add(src);
        }
    }
}
