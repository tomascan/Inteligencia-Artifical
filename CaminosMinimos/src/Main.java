import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        // Matriz enunciado

        int[][] matriz = {
                {1, 0, -1, 1, 3, 2, 3, 4, 3, 1},
                {2, 1, -1, 2, 4, 2, 2, 4, 2, 2},
                {5, 3, -1, 2, 3, 2, -1, 3, 3, 3},
                {3, 3, 1, 3, 4, 3, -1, 1, 2, 2},
                {2, 2, 2, 3, 6, 4, -1, 1, 2, 1},
                {-1, -1, -1, -1, 3, 3, -1, 0, 2, -1},
                {-1, -1, -1, -1, 2, 4, -1, 2, 2, -1},
                {2, 3, 4, 3, 1, 3, -1, 3, 2, -1},
                {3, 5, 6, 5, 2, 3, -1, 5, 3, -1},
                {5, 6, 7, 6, 4, 4, -1, 6, 4, 5}};

        // Matriz de tamaño 10x10 aleatoria

        int[][] matrizR = new int[10][10];
        aleatoria(matrizR);

        System.out.println("1. Tablero enunciado \n2. Tablero aleatorio");
        int op = scan.nextInt();
        int tablero = 0;

        switch (op){
            case 1: tablero = 1; imprimir(matriz); break;
            case 2: tablero = 2; imprimir(matrizR); break;
            default:
        }

        Casilla inicial = new Casilla(0, 0, matriz[0][0]);
        Casilla terminal = new Casilla(9, 9, matriz[9][9]);

        Heuristica h = new Heuristica();
        double hs = h.calcularHeuristica(inicial, terminal);

        BestFirst bf = new BestFirst();
        Casilla complete;
        System.out.println("\n Best First");
        complete = bf.result(matriz, inicial, terminal, h);

        System.out.println("\nFilas: " + complete.getF()+" Columnas: "+complete.getC());
        System.out.println("\nHeight of the value: " + complete.getHeight());
        System.out.println("\nPath to reach the target: " + complete.path);
        System.out.println("\nCost to reach the target: " + complete.getTime());



    }


    public static int[][] aleatoria(int[][] matrizR) {
        int vacio = -1;
        for (int x = 0; x < matrizR.length; x++) {
            for (int y = 0; y < matrizR[x].length; y++) {
                matrizR[x][y] = (int) (Math.random() * 9 + 1);
                if ((matrizR[x][y] == 8) || (matrizR[x][y] == 9)) {
                    matrizR[x][y] = vacio;
                }
            }
        }
        return matrizR;
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