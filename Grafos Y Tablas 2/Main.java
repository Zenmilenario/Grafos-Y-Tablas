import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            try {
                System.out.println("Desea ingresar manualmente la matriz de adyacencia? (SI/NO)");
                String respuesta = scanner.nextLine().toUpperCase();

                Grafo grafo;
                if (respuesta.equals("SI")) {
                    System.out.println("Ingrese el número de vértices:");
                    int vertices = -1;
                    boolean entradaValida = false;

                    while (!entradaValida) {
                        try {
                            vertices = scanner.nextInt();
                            entradaValida = true;
                        } catch (InputMismatchException e) {
                            System.out.println("Entrada no válida. Por favor, ingrese un número.");
                            scanner.nextLine(); // Consumir la entrada no válida
                        }
                    }

                    int[][] matriz = new int[vertices][vertices];
                    System.out.println("Ingrese la matriz de adyacencia (0 para no adyacente):");

                    for (int i = 0; i < vertices; i++) {
                        for (int j = 0; j < vertices; j++) {
                            entradaValida = false;
                            while (!entradaValida) {
                                try {
                                    matriz[i][j] = scanner.nextInt();
                                    entradaValida = true;
                                } catch (InputMismatchException e) {
                                    System.out.println("Entrada no válida. Por favor, ingrese un número para la posición [" + i + "][" + j + "].");
                                    scanner.nextLine(); // Consumir la entrada no válida
                                }
                            }
                        }
                    }
                    grafo = new Grafo(vertices, matriz);
                } else {
                    grafo = new Grafo();
                }

                System.out.println("Matriz de Adyacencia Generada:");
                grafo.imprimirMatriz();

                boolean verticeValido = false;
                int verticeInicial = -1;

                while (!verticeValido) {
                    try {
                        System.out.println("\nEl algoritmo de búsqueda implementado es profundidad (DFS):");
                        System.out.println("Seleccione el vértice inicial:");
                        for (int i = 0; i < grafo.getVertices(); i++) {
                            System.out.println("Para seleccionar Vértice " + (i + 1) + ", que corresponde con la fila " + (i + 1) + " de la matriz, pulse " + (i + 1));
                        }
                        verticeInicial = scanner.nextInt();
                        if (verticeInicial < 1 || verticeInicial > grafo.getVertices()) {
                            throw new IndexOutOfBoundsException("Vértice inicial fuera de rango.");
                        }
                        verticeValido = true;
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println(e.getMessage());
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada no válida. Por favor, ingrese un número.");
                        scanner.nextLine(); // Consumir la entrada no válida
                    }
                }
                new DFS(grafo, verticeInicial);

                verticeValido = false;
                int verticeInicialPrim = -1;

                while (!verticeValido) {
                    try {
                        System.out.println("El algoritmo de caminos mínimos implementado es el de Prim:");
                        System.out.println("Seleccione el vértice inicial:");
                        verticeInicialPrim = scanner.nextInt();
                        if (verticeInicialPrim < 1 || verticeInicialPrim > grafo.getVertices()) {
                            throw new IndexOutOfBoundsException("Vértice inicial fuera de rango.");
                        }
                        verticeValido = true;
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println(e.getMessage());
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada no válida. Por favor, ingrese un número.");
                        scanner.nextLine(); // Consumir la entrada no válida
                    }
                }
                System.out.println("Camino mínimo:");
                new Prim(grafo, verticeInicialPrim);

                scanner.nextLine(); // Consumir el salto de línea generado por el nextInt del scanner1
                boolean opcionCorrecta = false;
                System.out.println("Si quiere volver a probar los algoritmos diga 'SI', para salir diga 'NO'");
                while (!opcionCorrecta) {
                    String response = scanner.nextLine();
                    if (response.toUpperCase().equals("SI")) {
                        opcionCorrecta = true;
                    } else if (response.toUpperCase().equals("NO")) {
                        opcionCorrecta = true;
                        continuar = false;
                    } else {
                        System.out.println("Opción incorrecta, seleccione una opción correcta");
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                scanner.nextLine(); // Consumir la entrada no válida
            }
        }

        System.out.println("Gracias por probar nuestros algoritmos, ¡hasta la próxima!");
        scanner.close();
    }
}

