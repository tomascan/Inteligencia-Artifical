import java.util.*;

public class BestFirst extends Algoritmo {

    public Casilla result(int[][] matriz, Casilla start, Casilla end, Heuristica h) {
        int i = 0;

        LinkedList<Casilla> pendents = new LinkedList<Casilla>(); // Lista casillas pendientes
        start.path = "I-";
        pendents.add(start);

        LinkedList<Casilla> walked = new LinkedList<Casilla>(); // Lista casillas revisadas

        while (!pendents.isEmpty()) {
            i++;
            Casilla p = pendents.pop();
             if (p.equals(end)) {
                p.path = p.path + "F.";
                System.out.println("Ended. Total iterations:" + i);
                return p; //Devuelve la última casilla con el coste y el path completos
            } else {
                for (Casilla vecina : getNext(p, matriz)) { //Casillas vecinas disponibles
                    if (!pendents.contains(vecina) && !walked.contains(vecina)) {
                        pendents.add(vecina);
                    }
                }
                walked.add(p);

               pendents.sort(new Comparator<>() {
                   @Override
                   public int compare(Casilla o1, Casilla o2) { // Retorna + o2 va delante, - izquierda va delante, 0 se mantiene el orden
                       int r1 = h.calcularHeuristica(o1, end);
                       int r2 = h.calcularHeuristica(o2, end);
                       return Math.round(r1-r2);
                   }
               });
               System.out.println("Pendents");
               for(int j=0;j<pendents.size();j++){
                   System.out.println(""+pendents.get(j).height);
               }
            }
        }
        return null;
    }
}
