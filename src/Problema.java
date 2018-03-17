import java.util.ArrayList;
import java.util.Scanner;

public class Problema {

    ArrayList<Ciudad> listaCiudades = new ArrayList<>();
    double[][] matrix;
    int nCities;

    private Problema(int n) {
        listaCiudades = new ArrayList<Ciudad>();
        matrix = new double[n][n];
        nCities = n;
    }

    public static Problema leerCiudades(Scanner scanner) {
        Problema p;
        int n;

        //LEER NCITIES
        scanner.next();
        System.out.println("Introduce el numero de ciudades: ");
        n = scanner.nextInt();

        p = new Problema(n);
        p.nCities = n;

        System.out.println("Introduce la lista de ciudades: ");


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

    public Ciudad getCiudad(int pos) {
        return listaCiudades.get(pos);
    }

    private int getNumeroCiudades() {
        return nCities;
    }

    private double getDistancia(int pos1, int pos2) {
        return matrix[pos1][pos2];
    }

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
}
