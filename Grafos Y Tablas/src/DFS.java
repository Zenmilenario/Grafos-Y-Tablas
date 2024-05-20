public class DFS {
    private boolean[] visitados;

    public DFS(Grafo grafo, int inicio) {
        visitados = new boolean[grafo.getVertices()];
        System.out.print("DFS: ");
        dfs(grafo.getMatrizAdyacencia(), inicio);
        System.out.println();
    }

    private void dfs(int[][] matrizAdyacencia, int v) {
        visitados[v] = true;
        System.out.print(v + " ");

        for (int i = 0; i < matrizAdyacencia[v].length; i++) {
            if (matrizAdyacencia[v][i] != 0 && !visitados[i]) {
                dfs(matrizAdyacencia, i);
            }
        }
    }
}
