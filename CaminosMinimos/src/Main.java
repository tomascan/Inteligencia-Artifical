import java.util.Arrays;

public class Main {
    int r_matrizR[][] = aleatoria();


    public static void imprimir(int[][] matrizR) {
        for (int x=0; x < matrizR.length; x++) {
            System.out.print("|");
            for (int y=0; y < matrizR[x].length; y++) {
            System.out.print (matrizR[x][y]);
                if (y!=matrizR[x].length-1) System.out.print("\t");
            }
            System.out.println("|");
        }
    }
    public static int[][] aleatoria () {

        int matrizR[][] = new int[10][10];

        for (int x=0; x < matrizR.length; x++) {
            for (int y=0; y < matrizR[x].length; y++) {
                matrizR[x][y] = (int) (Math.random()*9+1);
            }
        }

        return matrizR;
    }
}