package juego.elementos;



public class Obstaculos extends Elementos{

    public Obstaculos(int x, int y){
        super(null, x, y);
    }
    
    @Override
    public String toString() {
        return "█";
    }
}
