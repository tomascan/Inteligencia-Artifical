import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        // Matriz enunciado

        int[][] matriz = {
                { 1, 0,-1, 1, 3, 2, 3, 4, 3, 1},
                { 2, 1,-1, 2, 4, 2, 2, 4, 2, 2},
                { 5, 3,-1, 2, 3, 2,-1, 3, 3, 3},
                { 3, 3, 1, 3, 4, 3,-1, 1, 2, 2},
                { 2, 2, 2, 3, 6, 4,-1, 1, 2, 1},
                {-1,-1,-1,-1, 3, 3,-1, 0, 2,-1},
                {-1,-1,-1,-1, 2, 4,-1, 2, 2,-1},
                { 2, 3, 4, 3, 1, 3,-1, 3, 2,-1},
                { 3, 5, 6, 5, 2, 3,-1, 5, 3,-1},
                { 5, 6, 7, 6, 4, 4,-1, 6, 4, 5}};

        // Matriz de tamaño 10x10 aleatoria

        int[][] matrizR = {
                { 7, 4, 6,-1, 3, 2,-1, 4, 3, 1},
                {-1, 4, 5,-1, 4, 2,-1, 4, 2, 2},
                {-1,-1, 5,-1, 3, 2, 3, 3, 3, 3},
                { 3, 3, 4, 4, 4, 3,-1, 5, 7, 2},
                { 2, 2, 2, 3, 6, 2, 5, 1, 6, 1},
                {-1,-1,-1,-1, 3, 4,-1, 0, 2,-1},
                {-1,-1,-1,-1, 2, 2,-1, 2, 2,-1},
                { 2, 3, 4, 3, 6, 3,-1, 3, 2,-1},
                { 3, 5, 6, 5, 2, 5, 2, 2, 1,-1},
                { 5, 6, 7, 6, 4, 2, 1, 3, 1, 0}};

        // SELECCIONAR TABLERO
        System.out.println("1. Tablero enunciado \n2. Tablero aleatorio");
        int op = scan.nextInt();
        int[][] tablero = new int[10][10];

        switch (op){
            case 1: tablero = matriz;  imprimir(tablero); break;
            case 2: tablero = matrizR; imprimir(tablero); break;
            default:
        }
        Casilla inicial = new Casilla(0, 0, tablero[0][0]);
        Casilla terminal = new Casilla(9, 9, tablero[9][9]);

        //SELECCIONAR HEURISTICA
        Heuristica hs = null;
        System.out.println("Selecciona heuristica: \n1. Distancia Euclidiana \n2. Distancia Manhattan \n3. Alturas");
        int heu = scan.nextInt();

        switch (heu){
            case 1: hs = new H1(); break;
            case 2: hs = new H2(); break;
            case 3: hs = new H3(); break;
            default:
        }

        //SELECCIONAR ALGORITMO
        BestFirst bf = new BestFirst();
        A a = new A();
        Casilla complete = null;

        System.out.println("Seleccionar algoritmo: \n\t 1.Best First \n\t 2.A*");
        int alg = scan.nextInt();

        switch (alg){
            case 1: System.out.println("\n Best First");
                    complete = bf.result(tablero, inicial, terminal, hs);
                    break;
            case 2: System.out.println("\n A*");
                    complete = a.result(tablero, inicial, terminal, hs);
                    break;
            default:
        }

        System.out.println("\nPath to reach the target: " + complete.path);
        System.out.println("\nCost to reach the target: " + complete.getTime());
    }

    public static void imprimir(int[][] matriz) {
        for (int[] ints : matriz) {
            System.out.print("|");
            for (int y = 0; y < ints.length; y++) {
                System.out.print(ints[y]);
                if (y != ints.length - 1) System.out.print("\t");
            }
            System.out.println("|");
        }
    }

}