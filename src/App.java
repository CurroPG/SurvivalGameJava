import juego.mapa.Mapa;

public class App {
    public static void main(String[] args) throws Exception {
        Mapa mapa = new Mapa(20, 40);
        
        mapa.limpiar();
        mapa.pintar();
    }
}
