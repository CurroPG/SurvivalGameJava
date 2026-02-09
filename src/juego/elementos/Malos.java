package juego.elementos;

import juego.movimientos.Perseguir;

public class Malos extends Elementos {
    public static final String	RED= "\u001B[31m";
    public static final String	RESET= "\u001B[0m";
    

    public Malos(int x, int y){
        super(x, y, new Perseguir());
    }

    @Override
    public String toString() {
        return RED+"█"+RESET;
    }

    @Override
    public boolean esMalo() {
        return true;
    }
}
