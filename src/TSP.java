import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Toni on 15/03/2018.
 */
public class TSP {

    public static void main(String args[]) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("examples/berlin52.tsp"));

        Problema p = Problema.leerCiudades(scanner);
        HeuristicaVecinoMasCercano h = new HeuristicaVecinoMasCercano(p);
        HeuristicaIntercambioAristas ia = new HeuristicaIntercambioAristas(p);
        Ruta r = h.ObtenerMejorRuta();
        String algo = "Algorithm 1 (Vecino mas Cercano) ";

        for (String arg: args){
            if (arg.equals("-algo2")){
                r = ia.busquedaMejorRuta(r);
                algo = "Algorithm 2 (Intercambio Aristas) ";
            }
        }

        System.out.println("Mejor Ruta encontrada utilizando " + algo);

        for (String arg : args){
            switch (arg){
                case "-solucion":
                    p.getSolucion(r);
                    break;
                case "-ruta":
                    r.printRuta();
                    break;
                case "-coste":
                    System.out.println("MEJOR SOLUCIÓN: " + p.coste(r));
                    break;
                default:
                    break;
            }
        }
    }
}
