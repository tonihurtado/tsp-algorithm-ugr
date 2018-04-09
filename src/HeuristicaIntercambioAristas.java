/**
 * Created by Toni on 08/04/2018.
 */

public class HeuristicaIntercambioAristas {

    private Problema p;

    public HeuristicaIntercambioAristas(Problema problema){
        p = problema;
    }

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

    public Ruta busquedaMejorRuta(Ruta ruta){

        Ruta mejorRuta = ruta;
        double minimoCambio, cambio;
        int mini = 0,minj = 0;

        do{
            minimoCambio = 0;
            for(int i=0; i < ruta.getnCiudades()-2; i++){
                for (int j= i+2; j < ruta.getnCiudades()-2; j++){
                    cambio = p.getDistancia(i,j) + p.getDistancia(i+1,j+1) - p.getDistancia(i,i+1) - p.getDistancia(j,j+1);
                    if(minimoCambio > cambio){
                        minimoCambio = cambio;
                        mini = i;
                        minj = j;
                    }
                }
            }

            if(minimoCambio < 0){
                mejorRuta = intercambioAristas(mejorRuta,mini,minj);
                System.out.println("minimocambio = " + minimoCambio);
            }
        } while (minimoCambio < 0);

        return mejorRuta;
    }
}

