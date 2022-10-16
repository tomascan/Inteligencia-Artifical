public class Matriz {

    public static void main(String[] args) {

        // Matriz enunciado

        int[][] matriz = {  {1, 0, -1, 1, 3, 2, 3, 4, 3, 1},
                            {2, 1, -1, 2, 4, 2, 2, 4, 2, 2},
                            {5, 3, -1, 2, 3, 2, -1, 3, 3, 3},
                            {3, 3, 1, 3, 4, 3, -1, 1, 2, 2},
                            {2, 2, 2, 3, 6, 4, -1, 1, 2, 1},
                            {-1, -1, -1, -1, 3, 3, -1, 0, 2, -1},
                            {-1, -1, -1, -1, 2, 4, -1, 2, 2, -1},
                            {2, 3, 4, 3, 1, 3, -1, 3, 2, -1},
                            {3, 5, 6, 5, 2, 3, -1, 5, 3, -1},
                            {5, 6, 7, 6, 4, 4, -1, 6, 4, 5} };

        // Matriz de tamaño 10x10 aleatoria

        int[][] matrizR = new int[10][10];
        int vacio = -1;

        for (int x=0; x < matrizR.length; x++) {
            for (int y=0; y < matrizR[x].length; y++) {
                matrizR[x][y] = (int) (Math.random()*9+1);
                if((matrizR[x][y] == 8) || (matrizR[x][y] == 9))  {
                    matrizR[x][y] = vacio;
                }
            }
        }
        imprimir(matriz);
        System.out.print("\n-------------------------------------\n\n");
        imprimir(matrizR);

        Casilla inicial = new Casilla(0,0, matriz[0][0],0);
        Casilla terminal = new Casilla(9,9,matriz[9][9],0);

        System.out.print("Casilla inicial altura: " +inicial.getHeight()+"\n");
        System.out.print("Casilla final altura: "+terminal.getHeight());

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