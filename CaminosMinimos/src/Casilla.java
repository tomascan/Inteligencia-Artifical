import java.util.ArrayList;
import java.util.List;


public class Casilla {

    private int f, c;                   //Filas y Columnas
    private int height;                 // Valor de la casilla
    private int time;                   // Coste total de desplazamientos
    private List <Casilla> path;        // Ruta a seguir



    public Casilla(int f, int c, int height, int cost) {
        this.f = f;
        this.c = c;
        this.height = height;
        this.time = this.time + cost;
        this.path = new ArrayList<>();
        this.path.add(this);
    }

    public int getF() {
        return f;
    }

    public int getC() {
        return c;
    }

    public int getHeight() {
        return height;
    }

    public String toString() {
        return Integer.toString(height);
    }

    public int getTime() {
        return time;
    }

    public List <Casilla> getPath() {
        return path;
    }

    public static double getDesnivel(Casilla actual, Casilla next){
        int dif = next.height - actual.height;
        if(dif >= 0)
            return 1 + dif;
        else
            return 0.5;
    }

}
