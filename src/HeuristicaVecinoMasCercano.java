
/**
 * Created by Toni on 15/03/2018.
 */

import java.util.Arrays;

/**
 * HEURISTICAVECINOMASCERCANO: En esta clase se incluiran los métodos que resuelvan el problema
 * mediante el calculo de un objeto Ruta.
 *
 * Constructor:
 * @param p problema a resolver mediante el algoritmo
        */

public class HeuristicaVecinoMasCercano {

    private Problema p;

    public HeuristicaVecinoMasCercano(Problema problema){
        p = problema;
    }

    /**
     * ObtenerMejorRuta: Función que ejecuta ObtenerRuta() desde todos los posible inicios, y busca
     * la ruta con el menor coste posible.
     *
     * @return Ruta mejor ruta
     */

    public Ruta ObtenerMejorRuta(){

        double cost;
        Ruta best = new Ruta();

        cost = p.coste(ObtenerRuta(0));

        for (int init = 1; init < p.nCities; init ++){

            Ruta r = ObtenerRuta(init);
            if(p.coste(r) < cost ){
                cost = p.coste(r);
                best = r;
            }
        }
        return best;
    }

    /**
     * ObtenerRuta: Función que utiliza la heurística del vecino más cercano para calcula la mejor ruta
     * posible a partir de una posición de inicio init
     *
     * @param init inicio de la ruta.
     * @return Ruta
     */

    private Ruta ObtenerRuta(int init){

        Ruta r = new Ruta();
        r.add(init);
        int search = init;

        for (int i=0;i<p.nCities-1; i++){
            double[] row = p.matrix[search].clone();
            boolean y = true;
            int j = 0, next = 0;
            while(y && j<p.nCities-1) {
                j++;
                Arrays.sort(row);
                double key = row[j];
                double[] original = p.matrix[search];

                for(int q=0;q<original.length; q++){

                    if(original[q] == key){

                        next = q;
                        break;
                    }
                }

                if(next > -1) {
                    y = r.find(next);
                }
            }

            r.add(next);
            search = next;
        }
        r.add(r.getPosRuta(0));

        return r;
    }
}
