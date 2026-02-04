package juego.elementos;

public class Buenos extends Elementos {
    public static final String	GREEN= "\u001B[32m";
    public static final String	RESET= "\u001B[0m";

    public Buenos(Elementos objetivo, int x, int y){
        super(objetivo, x, y);
    }

    @Override
    public String toString() {
        return GREEN+"█"+RESET;
    }
}
