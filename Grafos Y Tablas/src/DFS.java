public class DFS {
    private int[] visitados;
    private int[] noVisitados; 
    private Grafo grafo;
    
    public DFS(Grafo gra, int inicio) {
        this.visitados = new int[grafo.getVertices()];
        this.noVisitados = inicializarNoVisitados(grafo.getVertices());
        this.grafo = gra;
        
        System.out.print("Búsqueda en profundida/DFS: ");
        dfs(this.grafo.getMatrizAdyacencia(), inicio);
        System.out.println();
    }

    private void dfs(int[][] matrizAdyacencia, int v) {
        visitados[v-1] = 1; //se añade el vértice a la lista de visitados
        noVisitados[v-1] = 0; // se quita el vértice de la lista de no visitados
        System.out.print(v + " ");

        for (int i = 0; i < matrizAdyacencia[v].length; i++) {
            if (matrizAdyacencia[v][i] != 0 && visitados[i] == 0)
            	//si tiene conexion y no esta visitado entonces lo analizamos
                dfs(matrizAdyacencia, i);
        }
    }
    
    //Se inicializan todos a uno al principio porque ninguno está visitado
    public int[] inicializarNoVisitados(int vertices) {
    	int[] noVisitados = new int[vertices];
    	
    	for (int i = 0; i < noVisitados.length; i++) {
    		noVisitados[i] = 1;
        }
    	return noVisitados;
    }
}
