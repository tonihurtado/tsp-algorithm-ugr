import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Toni on 15/03/2018.
 */
public class TSP {

    public static void main(String args[]) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("src/small10.txt"));
        Problema p = Problema.leerCiudades(scanner);

        Ruta r = new Ruta();
        HeuristicaVecinoMasCercano h = new HeuristicaVecinoMasCercano(p, 6);

        r = h.ObtenerMejorRuta();
        System.out.println("Mejor ruta coste: ");
        System.out.println(p.coste(r));
    }
}
