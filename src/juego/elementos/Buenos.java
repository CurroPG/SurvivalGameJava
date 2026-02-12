package juego.elementos;

import juego.movimientos.Huir;

public class Buenos extends Elementos {
    public static final String GREEN = "\u001B[32m";
    public static final String RESET = "\u001B[0m";

    /**
     * Constructor que crea un personaje bueno en una posición específica.
     * Automáticamente asigna la estrategia de movimiento Huir.
     * 
     * @param x Coordenada horizontal inicial
     * @param y Coordenada vertical inicial
     */
    public Buenos(int x, int y){
        super(x, y, new Huir());
    }

    /**
     * Retorna la representación visual del personaje bueno.
     * Se muestra como un bloque verde en la consola.
     * 
     * @return String con el carácter de bloque en color verde
     */
    @Override
    public String toString() {
        return GREEN+"█"+RESET;
    }

    /**
     * Identifica a este elemento como un personaje bueno.
     * Sobrescribe el método de la clase base.
     * 
     * @return true siempre, indicando que es un personaje bueno
     */
    @Override
    public boolean esBueno() {
        return true;
    }
}