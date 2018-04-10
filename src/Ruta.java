import java.util.ArrayList;

/**
 * Created by Toni on 15/03/2018.
 */

/**
 * RUTA: Esta clase representa una solucion del problema. La solución se define a traves de una permutación
 * de ciudades, o sea, un orden en el que se visitaran estas.
 *
 * Constructor:
 * @param ciudades representa un array con la solución cerrada
 * @param nCiudades longitud de la solución
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

    public int getPosRuta(int n){
        return ciudades[n];
    }

    /**
     * add: Función que añade una nueva solución al final de la ruta. Utilizada para generar la solución
     * @param ciudad
     */
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

    /**
     * find: Función que comprueba si una ciudad ya existe en la solución actual, util para no repetir
     * las ciudades en la ruta
     * @param f posición de la ciudad
     * @return boolean (si existe o no)
     */
    public boolean find(int f){

        boolean exist = false;
        for(int i : ciudades){
            if(i == f) exist = true;
        }
        return exist;
    }

    /**
     * printRuta: Muestra por consola la solución
     */

    public void printRuta() {

        System.out.println("Mejor ruta: \n");
        int j = 0;
        for(int i : ciudades){
            j++;
            j %= 20;
            if(j==0) System.out.println("\n");
            System.out.print(" -> " + i);

        }
        System.out.println("\n");
    }
}