package juego.elementos;

public class Obstaculos extends Elementos{

    public Obstaculos(int x, int y){
        super(x, y, null);
    }
    
    @Override
    public String toString() {
        return "█";
    }
}
