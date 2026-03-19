package juego.movimientos;

import juego.elementos.Elementos;
import juego.posicion.Posicion;

public interface Movimiento {
    /**
     * Calcula la nueva posición del elemento basándose en su estrategia de movimiento.
     * 
     * Este método evalúa las posiciones adyacentes disponibles y selecciona
     * la óptima según la estrategia implementada (maximizar o minimizar distancia).
     * 
     * @param actual Posición actual del elemento que se va a mover
     * @param objetivo Posición del elemento objetivo (al que perseguir o del que huir)
     * @param mapa Matriz bidimensional del mapa que contiene todos los elementos.
     *             Se usa para verificar obstáculos y colisiones.
     * @return Nueva posición calculada según la estrategia de movimiento
     */
    public Posicion mover(Posicion actual, Posicion objetivo, Elementos[][] mapa);
}