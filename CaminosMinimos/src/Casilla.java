import java.util.List;


public class Casilla {

    int f, c;                   //Filas y Columnas
    int height;                 // Valor de la casilla
    double time;                   // Coste total de desplazamientos
    String path = "I-";        // Ruta a seguir


    public Casilla() {
        this.f = f;
        this.c = c;
        this.height = height;
        this.time = this.time;
    }
    public Casilla(int f, int c, int height) { //Constructor para crear siguiente casilla a añadir
        this.f = f;
        this.c = c;
        this.height = height;
    }

    public Casilla(int f, int c, int height, double cost, String camino) { //Constructor para crear siguiente casilla a añadir
        this.f = f;
        this.c = c;
        this.height = height;
        this.time = this.time + cost; //Tiempo total mas coste de desnivel
        this.path = this.getPath() + camino;
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


    public double getTime() {
        return time;
    }

    public String getPath() {
        return path;
    }

    public double getDesnivel(Casilla actual, Casilla next){ //coste a añadir a tiempo
        int dif = next.height - actual.height;
        if(dif >= 0)
            return 1 + dif;
        else
            return 0.5;
    }
    public boolean checkEquals(Casilla casilla) {
        return ((this.f == casilla.getF()) && (this.c == casilla.getC()));
    }

    @Override
    public boolean equals(Object obj) {
        return ((this.f == ((Casilla) obj).getF()) && (this.c == ((Casilla) obj).getC()));
    }

  /*  public String toString() {
        String result = "\nPath len: " + path;
        for (Casilla c : this.path) {
            result += "\nPoint [r=" + c.getF() + ", c=" + c.getC() + ", Cost=" + c.getTime() + "]";
        }
        return result;
    }*/

}
