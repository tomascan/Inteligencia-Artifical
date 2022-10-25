import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class Algoritmo {

    LinkedList<Casilla> pendents = new LinkedList<Casilla>();
    LinkedList<Casilla> walked = new LinkedList<Casilla>();
    public abstract Casilla result(int[][] matriz, Casilla start, Casilla end, Heuristica h);

    public List<Casilla> getNext(Casilla x, int[][] tablero) {
        Casilla v;
        int f = x.getF();
        int c = x.getC();
        double desnivel;

        List<Casilla> step = new ArrayList<>();

        if ((c - 1 >= 0) && (tablero[f][c - 1] != -1)) { //Si no se sale de limites y la casilla es valida
            v = new Casilla(f, c - 1, tablero[f][c - 1]);
            desnivel = x.getDesnivel(x, v);
            v.path = x.path + "L-";
            step.add(new Casilla(f, c - 1, tablero[f][c - 1], x.getTime(),desnivel, v.path));
        }
        if ((f - 1 >= 0) && (tablero[f - 1][c] != -1)) {
            v = new Casilla(f - 1, c, tablero[f - 1][c]);
            desnivel = x.getDesnivel(x, v);
            v.path = x.path + "U-";
            step.add(new Casilla(f - 1, c, tablero[f - 1][c],x.getTime(), desnivel, v.path));
        }
        if ((c + 1 < tablero.length) && (tablero[f][c + 1] != -1)) {
            v = new Casilla(f, c + 1, tablero[f][c + 1]);
            desnivel = x.getDesnivel(x, v);
            v.path = x.path + "R-";
            step.add(new Casilla(f, c+1, tablero[f][c + 1], x.getTime(), desnivel, v.path));
        }
        if ((f + 1 < tablero.length) && (tablero[f + 1][c] != -1)) {
            v = new Casilla(f + 1, c, tablero[f + 1][c]);
            desnivel = x.getDesnivel(x, v);
            v.path = x.path + "D-";
            step.add(new Casilla(f + 1, c, tablero[f + 1][c],x.getTime(), desnivel, v.path));

        }

        return step;
    }


}
