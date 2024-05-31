import java.util.Arrays;
import java.util.Iterator;

public class Prim {
	private Grafo grafo; 
	private int[] visitados;
	private int[] noVisitados;
	private int[][]aristas;
	private int[][]aristasFinales;
	
    public Prim(Grafo grafo, int inicio) {
    	this.grafo = grafo;
    	this.visitados = new int[this.grafo.getVertices()];
        this.noVisitados = inicializarNoVisitados(this.grafo.getVertices());
       
        
        this.visitados[inicio -1] = 1;//metemos el primero en visitados
        this.noVisitados[inicio -1] = 0;//sacamos al primero
        fillAristas(inicio - 1,  grafo.matrizAdyacencia[inicio -1]);
        int nextVertice = seleccionarMenorArista();
        algoritmoPrim(nextVertice);
        System.out.println("Fin algoritmo Prim");
    }
    
    private void algoritmoPrim(int vertice) {
    	if(this.aristas.length != 0) 
    	{
	    	this.visitados[vertice] = 1;//metemos el primero en visitados
	        this.noVisitados[vertice] = 0;//sacamos al primero
	        fillAristas(vertice,  grafo.matrizAdyacencia[vertice]);
	        int nextVertice = seleccionarMenorArista();
	        algoritmoPrim(nextVertice);
        }
    }
    
    private void fillAristas(int vertice, int[] conexiones) {
    	
    	for (int i = 0; i < conexiones.length; i++) {
			if(conexiones[i] != 0)
				fillArista(vertice, i, conexiones[i]);
		}
    }
    
    private void fillArista(int vertice1, int vertice2, int peso) {
   
    	int[][] aux = new int[this.aristas == null ? 1 : this.aristas.length +1][3];
    	if(this.aristas != null)
    		aux = copyArrayMatriz(this.aristas, aux);
    	aux[aux.length - 1] = new int[] {vertice1, vertice2, peso};
    	this.aristas = aux;
    }
    
    private int[][] copyArrayMatriz(int[][]original, int[][]toCopy){
    	for (int i = 0; i < original.length; i++) {
			toCopy[i] = original[i];
		}
    	return toCopy;
    }
    
    private int seleccionarMenorArista() {
    	comprobarAristas();
    	int pesoMin = 0;
    	int[]aristaFinal = new int[2];
    	for (int i = 0; i < this.aristas.length; i++) {
			if(pesoMin == 0 || this.aristas[i][2] < pesoMin) {
				aristaFinal[0] = this.aristas[i][0];
				aristaFinal[1] = this.aristas[i][1];
				pesoMin = this.aristas[i][2];
			}	
		}
    	addAristaFinal(aristaFinal);
    	eliminarArista(aristaFinal[0], aristaFinal[1]);
    	comprobarAristas();
    	return aristaFinal[1];
    }
    
    private void addAristaFinal(int[] newArista) {
    	
    	int[][]aux = new int[this.aristasFinales == null ? 1: this.aristasFinales.length +1][2];
    	if(this.aristasFinales != null)
    		aux = copyArrayMatriz(this.aristasFinales, aux);
    	aux[aux.length-1] = newArista;
    	this.aristasFinales = aux;
    	System.out.println("(V" +(aux[aux.length-1][0] +1) + " , V" + (aux[aux.length-1][1] +1)+ ")");
    }
    
    private void comprobarAristas() {
    	int contador = 0;//lo hacemos porque en caso de borrar una arista podemos iterar
    	int[][] aux = new int[this.aristas.length][3];
    	aux = copyArrayMatriz(this.aristas, aux);
    	for (int i = 0; i < aux.length; i++) {
			if(this.visitados[this.aristas[i - contador][0]] == 1 && this.visitados[this.aristas[i - contador][1]] == 1) {
				eliminarArista(this.aristas[i - contador][0], this.aristas[i - contador][1]);
				contador++;
			}
		}
    }
    
    private void eliminarArista(int vertice1, int vertice2) {
    	int[][]aux = new int[this.aristas.length-1][3];
    	int contador = 0;
    	for (int i = 0; i < this.aristas.length; i++) {
			if(this.aristas[i][1] != vertice2) {
				aux[contador] = this.aristas[i];
				contador++;
			}	
		}
    	this.aristas = aux;
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
