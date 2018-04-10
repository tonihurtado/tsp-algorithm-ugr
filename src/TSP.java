/**
 * Created by Jose Antonio Hurtado Morón on 15/03/2018.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * TSP: Esta es la clase principal del proyecto (main). Agrupa al resto de subclases y lleva a cabo el
 * programa en sí. Por una parte, crea las distintas instancias de las clases y las relaciona entre ellas,
 * y por otro lado analiza los argumentos con los que es llamado el programa, y llama a unas funciones u otras
 * en función de estos.
 *
 * @param args[] Argumentos para especificar el algoritmo a utilizar, así como el tipo de solución esperada
 *
 * @see console Muestra en la consola la solución
 * @throws FileNotFoundException
 */
public class TSP {

    public static void main(String args[]) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("examples/berlin52.tsp"));

        Problema p = Problema.leerCiudades(scanner);
        HeuristicaVecinoMasCercano h = new HeuristicaVecinoMasCercano(p);
        HeuristicaIntercambioAristas ia = new HeuristicaIntercambioAristas(p);
        Ruta r = h.ObtenerMejorRuta();
        String algo = "Algorithm 1 (Vecino mas Cercano) ";

        for (int i=0; i < args.length; i++){
            if (args[i].equals("-algo")){
                if(args[i+1].equals("2")) {
                    r = ia.busquedaMejorRuta(r);
                    algo = "Algorithm 2 (Intercambio Aristas) ";
                }
            }
        }

        System.out.println( "\n" + "TSP SOLUTION FOR: " + algo +"\n");

        for (String arg : args){
            switch (arg){
                case "-solucion":
                    p.getSolucion(r);
                    break;
                case "-ruta":
                    r.printRuta();
                    break;
                case "-coste":
                    System.out.println("\n" + "MEJOR SOLUCIÓN: " + p.coste(r));
                    break;
                default:
                    break;
            }
        }
    }
}
