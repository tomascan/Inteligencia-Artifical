public class Heuristica {
    public double calcularHeuristica(Casilla c1, Casilla c2){
        return ((c2.getF() - c1.getF())+ (c2.getC() - c1.getC()));
    }
}

