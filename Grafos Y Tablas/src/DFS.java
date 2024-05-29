public class DFS {
    private int[] visitados;
    private int[] noVisitados; 
    private Grafo grafo;
    
    public DFS(Grafo gra, int inicio) {
    	this.grafo = gra;
        this.visitados = new int[this.grafo.getVertices()];
        this.noVisitados = inicializarNoVisitados(this.grafo.getVertices());
        
        
        System.out.print("Búsqueda en profundida/DFS: ");
        visitados[inicio-1] = 1; //se añade el vértice a la lista de visitados 
        noVisitados[inicio-1] = 0; // se quita el vértice de la lista de no visitados
        dfs(this.grafo.getMatrizAdyacencia(), inicio-1);
        System.out.println("\n");
    }

    private void dfs(int[][] matrizAdyacencia, int v) {
        System.out.print("V"+(v+1) + " ");

        for (int i = 0; i < matrizAdyacencia[v].length; i++) {
            if (matrizAdyacencia[v][i] != 0 && visitados[i] == 0) {
            	//si tiene conexion y no esta visitado entonces lo analizamos
            	visitados[i] = 1; //se añade el vértice a la lista de visitados
                noVisitados[i] = 0; // se quita el vértice de la lista de no visitados
                dfs(matrizAdyacencia, i);
            }
            	
        }
    }
    
    //Se inicializan todos a uno al principio porque ninguno está visitado
    private int[] inicializarNoVisitados(int vertices) {
    	int[] noVisitados = new int[vertices];
    	
    	for (int i = 0; i < noVisitados.length; i++) {
    		noVisitados[i] = 1;
        }
    	return noVisitados;
    }
}
