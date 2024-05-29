import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        while(continuar) {
        	Grafo grafo = new Grafo();

            System.out.println("Matriz de Adyacencia Generada aleatoriamente:");
            grafo.imprimirMatriz();

            System.out.println("\nEl algoritmo de búsqueda implementado es profuncidad(DFS):");
            System.out.println("Selecciona el vértice inicial:");
            for (int i = 0; i < grafo.getVertices(); i++) {
    			System.out.println("Para seleccionar Vértice " + (i+1) + ", que corresponde con la fila " + (i+1) + " de la matriz, pulse " + (i+1));
    		}
            int verticeInicial = scanner.nextInt();
            new DFS(grafo, verticeInicial);
           

            System.out.println("El algoritmo de caminos mínimos implementado es el de Prim:");
            System.out.println("Selecciona el vértice inicial:");
            int verticeInicialPrim = scanner.nextInt();
            System.out.println("Camino mínimo:");
            new Prim(grafo, verticeInicialPrim);
            
            // Consumir el salto de línea generado por el nextInt del scanner1
            scanner.nextLine();
            boolean opcionCorrecta = false;
            System.out.println("Si quiere volver a probar los algoritmos diga 'SI', para salir diga 'NO'");
            while(!opcionCorrecta) {
            	String response = scanner.nextLine();
            	if(response.toUpperCase().equals("SI")) {
            		opcionCorrecta = true;
            	}
            	else if(response.toUpperCase().equals("NO")) {
            		opcionCorrecta = true;
            		continuar = false;
            	}
            	else {
            		System.out.println("Opción incorrecta, selecciones una opción correcta");
            	}
            }
            
        }
        
        System.out.println("Gracias por probar nuestros algoritmos, hasta la próxima!!");
        scanner.close();
    }
}

