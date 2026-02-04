package juego.elementos;

public class Malos extends Elementos {
    public static final String	RED= "\u001B[31m";
    public static final String	RESET= "\u001B[0m";
    

    public Malos(Elementos objetivo, int x, int y){
        super(objetivo, x, y);
    }

    @Override
    public String toString() {
        return RED+"█"+RESET;
    }
}
