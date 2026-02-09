package juego.elementos;

import juego.movimientos.Huir;

public class Buenos extends Elementos {
    public static final String	GREEN= "\u001B[32m";
    public static final String	RESET= "\u001B[0m";

    public Buenos(int x, int y){
        super(x, y, new Huir());
    }

    @Override
    public String toString() {
        return GREEN+"█"+RESET;
    }

    @Override
    public boolean esBueno() {
        return true;
    }
}
