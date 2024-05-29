import java.util.Random;

public class Grafo {
    public int[][] matrizAdyacencia;
    private int vertices;
    private double densidadAristas;

    public Grafo() {
        Random random = new Random();
        this.vertices = random.nextInt(20) + 1;
        this.matrizAdyacencia = new int[vertices][vertices];
        this.densidadAristas = random.nextDouble();
        generarMatrizAdyacencia(random);
    }

    private void generarMatrizAdyacencia(Random random) {
        for (int i = 0; i < vertices; i++) {
            for (int j = i + 1; j < vertices; j++) {
                if (random.nextDouble() < densidadAristas) {
                    int peso = random.nextInt(10) + 1;
                    matrizAdyacencia[i][j] = peso;
                    matrizAdyacencia[j][i] = peso;
                } else {
                    matrizAdyacencia[i][j] = 0;
                    matrizAdyacencia[j][i] = 0;
                }
            }
        }
    }
    
    public int getVertices() {
        return vertices;
    }

    public int[][] getMatrizAdyacencia() {
        return matrizAdyacencia;
    }

    public void imprimirMatriz() {
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(matrizAdyacencia[i][j] + " ");
            }
            System.out.println();
        }
    }
}
