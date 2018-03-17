import java.util.ArrayList;

/**
 * Created by Toni on 15/03/2018.
 */
public class Ruta {

    private int[] ciudades ;
    private int nCiudades;

    public Ruta(){
        ciudades = new int[0];
        nCiudades = 0;
    }

    public int[] getRuta(){
        return ciudades;
    }

    public int getnCiudades(){
        return nCiudades;
    }

    public int getPosRuta(int n){ return ciudades[n]; }

    public void add(int ciudad){

            int[] aux = ciudades.clone();
            ciudades = new int[nCiudades+1];
            int j = 0;
            for(int i : aux){
                ciudades[j] = i;
                j++;
            }

        ciudades[nCiudades] = ciudad;
        nCiudades++;
    }

    public boolean find(int f){

        boolean exist = false;
        for(int i : ciudades){
            if(i == f) exist = true;
        }
        return exist;
    }
}
