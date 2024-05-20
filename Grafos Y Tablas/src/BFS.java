import java.util.*;

public class BFS {
    private boolean[] visitados;

    public BFS(Grafo grafo, int inicio) {
        visitados = new boolean[grafo.getVertices()];
        System.out.print("BFS: ");
        bfs(grafo.getMatrizAdyacencia(), inicio);
        System.out.println();
    }

    private void bfs(int[][] matrizAdyacencia, int inicio) {
        Queue<Integer> cola = new LinkedList<>();
        visitados[inicio] = true;
        cola.add(inicio);

        while (!cola.isEmpty()) {
            int v = cola.poll();
            System.out.print(v + " ");

            for (int i = 0; i < matrizAdyacencia[v].length; i++) {
                if (matrizAdyacencia[v][i] != 0 && !visitados[i]) {
                    visitados[i] = true;
                    cola.add(i);
                }
            }
        }
    }
}
