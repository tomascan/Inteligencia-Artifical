public class H2 extends Heuristica{
    public int calcularHeuristica(Casilla c1, Casilla c2){ //Distancia Manhatan
        return Math.abs(((c2.getF() - c1.getF()) + (c2.getC() - c1.getC())));
    }
}