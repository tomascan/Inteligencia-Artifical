import java.util.LinkedList;

public class BestFirst {

    public boolean result(int [][] matriz,Casilla inicial, Casilla end) {
        boolean found = false;
        int i = 0;
        // Lista casillas pendientes
        LinkedList<Casilla> pendents = new LinkedList<Casilla>();
        pendents.add(inicial);

        // Lista casillas revisadas
        LinkedList<Casilla> reviewed = new LinkedList<Casilla>();

        while ((!found ) && (!pendents.isEmpty())) {
            inicial = pendents.remove(); // Quita de la lista de pendientes


        }

        return found;
    }
}
