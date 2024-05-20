import java.util.*;

public class Dijkstra {
    public Dijkstra(Grafo grafo, int inicio) {
        dijkstra(grafo.getMatrizAdyacencia(), inicio, grafo.getVertices());
    }

    private void dijkstra(int[][] grafo, int inicio, int vertices) {
        int[] dist = new int[vertices];
        boolean[] visitados = new boolean[vertices];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[inicio] = 0;

        for (int count = 0; count < vertices - 1; count++) {
            int u = minDist(dist, visitados, vertices);
            visitados[u] = true;

            for (int v = 0; v < vertices; v++) {
                if (!visitados[v] && grafo[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + grafo[u][v] < dist[v]) {
                    dist[v] = dist[u] + grafo[u][v];
                }
            }
        }

        printSolution(dist, vertices);
    }

    private int minDist(int[] dist, boolean[] visitados, int vertices) {
        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int v = 0; v < vertices; v++) {
            if (!visitados[v] && dist[v] < min) {
                min = dist[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    private void printSolution(int[] dist, int vertices) {
        System.out.println("Vértice \t Distancia desde el origen");
        for (int i = 0; i < vertices; i++) {
            System.out.println(i + " \t\t " + dist[i]);
        }
    }
}
