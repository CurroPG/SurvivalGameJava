package juego.movimientos;

import juego.posicion.Posicion;

public interface Movimiento {
    public Posicion mover(Posicion actual, Posicion objetivo);
}
