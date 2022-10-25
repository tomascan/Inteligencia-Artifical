public class H3 extends Heuristica{
    public int calcularHeuristica(Casilla c1, Casilla c2){ //Distancia Manhatan
        return (c1.height - c2.height);
    }
}
