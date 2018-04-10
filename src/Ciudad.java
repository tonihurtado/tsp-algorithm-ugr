/**
 * Created by Toni on 15/03/2018.
 */

/**
 * CIUDAD: Clase que representa los datos asociados a una determinada ciudad. Permite al
 * almacenar un par (x,y) de coordenadas asociadas a la posición de esta, además de una
 * etiqueta que permite describir la ciudad.
 *
 * Constructor:
 * @param _x coordenada x
 * @param _y coordenada y
 * @param _tag string para describir la ciudad
 */
public class Ciudad {

    private double _x;
    private double _y;
    private String _tag;

    Ciudad() {
        _x = 0;
        _y = 0;
        _tag = "";
    }

    /**
     * setData: Dados unos valores, se los asigna a la clase.
     * @param tag
     * @param x
     * @param y
     */
    public void setData(String tag, double x, double y){
       _tag=tag; _x = x; _y = y;
    }

    public double getX(){
        return _x;
    }

    public double getY(){
        return _y;
    }

    public String getTag(){
        return _tag;
    }

    public void getString(){
       System.out.println( _x + " " + _y );
    }

    /**
     * calcularDistancia: Funcion que calcula la distancia euclidea entre la ciudad y otra ciudad dada. Esta función es usada
     * para rellenar la matriz de distancias de la clase problema.
     *
     * @param ciudad ciudad contra la que calcular la distancia
     * @return valor de tipo double de la distancia entre ambas
     */

    public double calcularDistancia(Ciudad ciudad){
        return Math.sqrt( Math.pow(Math.abs(getX() - ciudad.getX()),2) +  Math.pow(Math.abs(getY() - ciudad.getY()),2));
    }
}
