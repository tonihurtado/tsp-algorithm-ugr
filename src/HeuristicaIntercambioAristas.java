/**
 * Created by Toni on 08/04/2018.
 */

/**
 * HEURISTICAINTERCAMBIOARISTAS: Clase suplementaria que mejora las rutas generadas con la heurística del
 * vecino mas cercano inspeccionando la ruta en busca de modificaciones que reduzcan el coste. Para ello
 * utiliza el algoritmo de intercambio de aristas
 *
 * Constructor:
 * @param p problema a resolver mediante el algoritmo
 */

public class HeuristicaIntercambioAristas {

    private Problema p;

    public HeuristicaIntercambioAristas(Problema problema){
        p = problema;
    }

    /**
     * intercambioAristas: Algoritmo que dada una ruta y dos posiciones a cambiar de esta
     * genera una nueva ruta invirtiendo las aristas, es decir, intercambiando la ruta entre
     * i y j por los valores de j a i+1.
     * @param ruta
     * @param i
     * @param j
     * @return
     */

    private Ruta intercambioAristas(Ruta ruta,int i,int j){
        Ruta nuevaRuta = new Ruta();
        for (int k = 0; k <= i; k++ ) {
            nuevaRuta.add(ruta.getPosRuta(k));
        }
        for (int k = j; k >= i+1; k-- ) {
            nuevaRuta.add(ruta.getPosRuta(k));
        }
        for (int k = j+1; k < ruta.getnCiudades(); k++ ) {
            nuevaRuta.add(ruta.getPosRuta(k));
        }

        return nuevaRuta;
    }

    /**
     * busquedaMejorRuta: Algoritmo que analiza la ruta en busca de posibles cambios que mejoren el coste
     * en la ruta actual. Este finalizara cuando no haya cambios mejores.
     *
     * @param ruta
     * @return
     */

    public Ruta busquedaMejorRuta(Ruta ruta){

        Ruta mejorRuta = ruta;
        double minimoCambio, cambio;
        int mini = 0,minj = 0;

        do{
            minimoCambio = 0;
            for(int i=0; i < p.nCities-2; i++){
                for (int j= i+2; j < p.nCities-1; j++){
                    cambio = p.getDistancia(mejorRuta.getPosRuta(i),mejorRuta.getPosRuta(j)) +
                             p.getDistancia(mejorRuta.getPosRuta(i+1),mejorRuta.getPosRuta(j+1)) -
                             p.getDistancia(mejorRuta.getPosRuta(i),mejorRuta.getPosRuta(i+1)) -
                             p.getDistancia(mejorRuta.getPosRuta(j),mejorRuta.getPosRuta(j+1));
                    if(minimoCambio > cambio){
                        minimoCambio = cambio;
                        mini = i;
                        minj = j;
                    }
                }
            }

            if(minimoCambio < -0.01){
                mejorRuta = intercambioAristas(mejorRuta,mini,minj);
                System.out.println("minimocambio = " + minimoCambio);
            }
        } while (minimoCambio < -0.01);

        return mejorRuta;
    }
}

