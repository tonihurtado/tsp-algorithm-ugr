/**
 * Created by Toni on 15/03/2018.
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
       System.out.println( _tag + _x + _y );
    }

    public double calcularDistancia(Ciudad ciudad){
        double dist = Math.sqrt( Math.pow(Math.abs(getX() - ciudad.getX()),2) +  Math.pow(Math.abs(getY() - ciudad.getY()),2));
        return (double) Math.round(dist * 100) / 100;
    }
}
