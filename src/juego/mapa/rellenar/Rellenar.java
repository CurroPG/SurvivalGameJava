package juego.mapa.rellenar;

public interface Rellenar {
    public boolean comprobarCasillas(int x, int y);
    public void generarObstaculos();
    public void generarBuenos();
    public void generarMalos();
}
