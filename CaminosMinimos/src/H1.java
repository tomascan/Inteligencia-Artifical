public class H1 extends Heuristica {

    public int calcularHeuristica(Casilla c1, Casilla c2){ //Distancia Euclidiana
        return (int)Math.round(Math.sqrt(Math.pow(c2.getF()-c1.getF(),2) + (Math.pow(c2.getC()-c1.getC(),2))));
    }
}
