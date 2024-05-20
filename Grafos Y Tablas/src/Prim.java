import java.util.Arrays;

public class Prim {
    public Prim(Grafo grafo) {
        prim(grafo.getMatrizAdyacencia(), grafo.getVertices());
    }

    private void prim(int[][] grafo, int vertices) {
        boolean[] visitados = new boolean[vertices];
        int[] key = new int[vertices];
        int[] parent = new int[vertices];

        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < vertices - 1; count++) {
            int u = minKey(key, visitados, vertices);
            visitados[u] = true;

            for (int v = 0; v < vertices; v++) {
                if (grafo[u][v] != 0 && !visitados[v] && grafo[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = grafo[u][v];
                }
            }
        }

        printMST(parent, grafo, vertices);
    }

    private int minKey(int[] key, boolean[] visitados, int vertices) {
        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int v = 0; v < vertices; v++) {
            if (!visitados[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    private void printMST(int[] parent, int[][] grafo, int vertices) {
        System.out.println("Arista \tPeso");
        for (int i = 1; i < vertices; i++) {
            if (parent[i] != -1) {
                System.out.println(parent[i] + " - " + i + "\t" + grafo[i][parent[i]]);
            }
        }
    }
}
