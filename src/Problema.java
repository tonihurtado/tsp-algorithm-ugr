import java.util.ArrayList;
import java.util.Scanner;

/**
 * PROBLEMA: Clase que almacena información soble el problema a resolver, tal y como la lista de ciudades que lee
 * de la entrada, la distancia entre estas.
 *
*/

public class Problema {

    ArrayList<Ciudad> listaCiudades = new ArrayList<>();
    double[][] matrix;
    int nCities;

    /**
     * Constructor:
     * @param listaCiudades Lista que contiene las diferentes ciudades
     * @param nCities Numero de ciudades en la lista
     * @param matrix Matriz que contiene la distancia entre todos los pares de ciudades.
     */

    private Problema(int n) {
        listaCiudades = new ArrayList<Ciudad>();
        matrix = new double[n][n];
        nCities = n;
    }

    /**
     * LeerCiudades: Clase que lee de la entrada los datos sobre las ciudades a incluir en el problema
     * @param scanner Entrada de datos a leer.
     * @see Problema
     * @returns Crea un nuevo problema a partir de los datos leidos.
     */

    public static Problema leerCiudades(Scanner scanner) {
        Problema p;
        int n;

        //LEER NCITIES
        scanner.next();
        n = scanner.nextInt();

        p = new Problema(n);
        p.nCities = n;

        //LEER CIUDADES

        for (int i = 0; i < n; i++) {
            Ciudad ciudad = new Ciudad();
            scanner.nextLine();
            String tag = scanner.next();
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            ciudad.setData(tag, x, y);
            p.listaCiudades.add(ciudad);
        }

        //CALCULAR DISTANCIAS

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                Ciudad cityOne = p.listaCiudades.get(i);
                Ciudad cityTwo = p.listaCiudades.get(k);
                p.matrix[i][k] = cityOne.calcularDistancia(cityTwo);
            }
        }

        return p;
    }

    /**
     * getCiudad: Funcion que a partir de la posición de una ciudad dada, devuelve los parametros de esta.
     * @param pos posición de la ciudad en la lista
     * @see Ciudad
     * @returns devuelve un objeto de tipo Ciudad con los parámetros requeridos
     */

    public Ciudad getCiudad(int pos) {
        return listaCiudades.get(pos);
    }

    private int getNumeroCiudades() {
        return nCities;
    }

    /**
     * getDistancia: Funcion que devuelve la distancia entre dos ciudades dada su posición en la lista
     * @param pos1 posición de la primera ciudad
     * @param pos2 posición de la segunda ciudad
     * @returns devuelve un valor de tipo doble con la distancia entre ambas ciudades en función de sus
     *          coordenadas, y obteniendo esta información de la matriz de distancias.
     */

    public double getDistancia(int pos1, int pos2) {
        return matrix[pos1][pos2];
    }

    /**
     * coste: Funcion que calcula la suma de las distancias entre los pares de ciudades de una ruta dada
     * @param ruta ruta
     * @see Ruta
     * @returns el coste total de la ruta.
     */

    public double coste(Ruta ruta){
        int[] rut = ruta.getRuta();
        double coste = 0;
        int j = 1;
        for(int i = 0; i<ruta.getnCiudades(); i++){
            j=j%ruta.getnCiudades();
            coste += matrix[rut[i]][rut[j]];
            j++;
        }

        return coste;
    }

    /**
     * getSolución: Función que imprime en la consola una ruta como los pares de coordenadas de las ciudades
     *              que la componen
     * @param r ruta

     */

    public void getSolucion(Ruta r){
        System.out.println(" Coordenadas ruta: \n");
       for(int c : r.getRuta()){
           listaCiudades.get(c).getString();
       }
    }
}
