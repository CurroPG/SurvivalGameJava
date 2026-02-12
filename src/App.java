import juego.mapa.Mapa;

public class App {
    public static void main(String[] args) throws Exception {
        Mapa mapa = new Mapa(25, 100);
        mapa.generarElementos();
        do{
            mapa.limpiar();
            mapa.pintar();
            mapa.refrescarMapa();
            Thread.sleep(50);
        }while(true);
    }
}