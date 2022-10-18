import java.util.*;

public class BestFirst {

    public Casilla result(int [][] matriz,Casilla start, Casilla end, Heuristica h) {
        int i = 0;
        // Lista casillas pendientes
        LinkedList<Casilla> pendents = new LinkedList<Casilla>();
        pendents.add(start);

        // Lista casillas revisadas
        LinkedList<Casilla> walked = new LinkedList<Casilla>();

        while (!pendents.isEmpty()) {
            i++;
            Casilla p = pendents.poll();
            //System.out.println("Fila "+p.f+" Col: "+p.c+" Altura de p: "+p.height);
            if (p.checkEquals(end)) {
                p.path = p.path + "F.";
                System.out.println("Ended. Total iterations:" + i);
                return p; //Devuelve la última casilla con el coste y el path completos
            } else {
                for (Casilla vecina : getNext(p, matriz)) { //Casillas vecinas disponibles
                    if (!pendents.contains(vecina) && !walked.contains(vecina)) {
                        pendents.add(vecina);

                    }
                }
            }
            walked.add(p);


            System.out.println("Walked:");
            for(int j = 0; j< walked.size();j++){
                System.out.println(walked.get(j).height);}

           /* pendents.sort(new Comparator<Casilla>() {
                @Override
                public int compare(Casilla o1, Casilla o2) {
                    return o1.getHeight() - o2.getHeight(); // no entiendo too much
                }
            });*/
        }
        return null;
    }


    public List<Casilla> getNext(Casilla x, int[][] tablero){
        Casilla v;
        int f = x.getF();
        int c = x.getC();
        double desnivel;

        List<Casilla> step = new ArrayList<>();

        if((f-1>=0) && (tablero[f-1][c]!=-1)){ //Si no se sale de limites y la casilla es valida
            v = new Casilla(f-1,c,tablero[f-1][c]);
            desnivel = x.getDesnivel(x,v);
            v.path =  x.path + "L-";
            step.add(new Casilla(f-1, c, tablero[f-1][c], desnivel, v.path));
        }
        if((f+1 < tablero.length) && (tablero[f+1][c]!=-1)){
            v = new Casilla(f+1,c,tablero[f+1][c]);
            desnivel = x.getDesnivel(x,v);
            v.path =  x.path + "R-";
            step.add(new Casilla(f+1, c, tablero[f+1][c], desnivel, v.path));

        }
        if((c-1>=0) && (tablero[f][c-1]!=-1)){
            v = new Casilla(f,c-1,tablero[f][c-1]);
            desnivel = x.getDesnivel(x,v);
            v.path =  x.path + "U-";
            step.add(new Casilla(f, c-1, tablero[f][c-1], desnivel, v.path));
        }
        if((c+1 < tablero.length) && (tablero[f][c+1]!=-1)){
            v = new Casilla(f,c+1,tablero[f][c+1]);
            desnivel = x.getDesnivel(x,v);
            v.path =  x.path + "D-";
            step.add(new Casilla(f+1, c, tablero[f][c+1], desnivel, v.path));
        }
        System.out.println("Step:");
        for(int j = 0; j< step.size();j++){
            System.out.println(step.get(j).height);}
        return step;
    }

    @Override
    public boolean equals(Object obj) {
        Casilla x = (Casilla) obj;
        return ((x.f == ((Casilla) obj).getF()) && (x.c == ((Casilla) obj).getC()));
    }

}
