package juego.elementos;



public class Malos extends Personajes {
    
    public Malos(int vida, int x, int y){
        super(vida, x, y);
    }

    @Override
    public String toString() {
        return "M";
    }
}
