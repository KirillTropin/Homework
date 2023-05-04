package org.example;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Main {

    public static void BFS(GraphBFS graph, int v, boolean[] discovered)
    {
        // создаем queue для выполнения BFS
        Queue<Integer> q = new ArrayDeque<>();

        // помечаем исходную вершину как обнаруженную
        discovered[v] = true;

        // поставить исходную вершину в queue
        q.add(v);

        // цикл до тех пор, пока queue не станет пустой
        while (!q.isEmpty())
        {
            // удаляем передний узел из очереди и печатаем его
            v = q.poll();
            System.out.print(v + " ");

            // делаем для каждого ребра (v, u)
            for (int u: graph.adjList.get(v))
            {
                if (!discovered[u])
                {
                    // помечаем его как обнаруженный и ставим в queue
                    discovered[u] = true;
                    q.add(u);
                }
            }
        }
    }
    public static void main(String[] args) {

        GraphDFS g = new GraphDFS(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);

        System.out.println("Following is Depth First Traversal");

        g.DFS(2);


        // Список ребер Graph согласно приведенной выше диаграмме
        List<Edge> edges = Arrays.asList(
                new Edge(1, 2), new Edge(1, 3), new Edge(1, 4), new Edge(2, 5),
                new Edge(2, 6), new Edge(5, 9), new Edge(5, 10), new Edge(4, 7),
                new Edge(4, 8), new Edge(7, 11), new Edge(7, 12)
                // вершины 0, 13 и 14 — отдельные узлы
        );

        // общее количество узлов в Graph (от 0 до 14)
        int n = 15;

        // строим graph из заданных ребер
        GraphBFS graph = new GraphBFS(edges, n);

        // чтобы отслеживать, открыта вершина или нет
        boolean[] discovered = new boolean[n];

        // Выполняем обход BFS от всех необнаруженных узлов к
        // покрываем все связные компоненты Graph
        for (int i = 0; i < n; i++)
        {
            if (discovered[i] == false)
            {
                // начинаем обход BFS с вершины `i`
                BFS(graph, i, discovered);
            }
        }
    }
}