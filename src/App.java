import juego.mapa.Mapa;

public class App {
    public static void main(String[] args) throws Exception {
        Mapa mapa = new Mapa(40, 80);
        mapa.generarElementos();
        mapa.limpiar();
        mapa.pintar();
    }
}
