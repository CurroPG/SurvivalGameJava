package juego.movimientos;

import juego.elementos.Elementos;
import juego.posicion.Posicion;

public interface Movimiento {
    public Posicion mover(Posicion actual, Posicion objetivo, Elementos[][] mapa);
}
