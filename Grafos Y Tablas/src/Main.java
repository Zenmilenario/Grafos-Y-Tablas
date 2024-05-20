import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Grafo grafo = new Grafo();

        System.out.println("Matriz de Adyacencia Generada:");
        grafo.imprimirMatriz();

        System.out.println("Selecciona un algoritmo de búsqueda:");
        System.out.println("1. Búsqueda en Profundidad (DFS)");
        System.out.println("2. Búsqueda en Anchura (BFS)");
        int opcionBusqueda = scanner.nextInt();

        System.out.println("Selecciona el vértice inicial:");
        int verticeInicial = scanner.nextInt();

        if (opcionBusqueda == 1) {
            new DFS(grafo, verticeInicial);
        } else if (opcionBusqueda == 2) {
            new BFS(grafo, verticeInicial);
        } else {
            System.out.println("Opción no válida");
        }

        System.out.println("Selecciona un algoritmo de caminos mínimos:");
        System.out.println("1. Algoritmo de Prim");
        System.out.println("2. Algoritmo de Dijkstra");
        int opcionCaminosMinimos = scanner.nextInt();

        if (opcionCaminosMinimos == 1) {
            new Prim(grafo);
        } else if (opcionCaminosMinimos == 2) {
            new Dijkstra(grafo, verticeInicial);
        } else {
            System.out.println("Opción no válida");
        }

        scanner.close();
    }
}

