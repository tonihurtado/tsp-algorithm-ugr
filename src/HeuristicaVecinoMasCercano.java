import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Toni on 15/03/2018.
 */
public class HeuristicaVecinoMasCercano {

    private Problema p;
    int init;

    public HeuristicaVecinoMasCercano(Problema problema, int initPos){
        p = problema;
        init = initPos;
    }

    public Ruta ObtenerMejorRuta(){

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
