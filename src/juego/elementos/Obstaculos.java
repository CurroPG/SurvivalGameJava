package juego.elementos;



public class Obstaculos extends Personajes{

    public Obstaculos(int x, int y){
        super(0, x, y);
    }
    
    @Override
    public String toString() {
        return "*";
    }
}
