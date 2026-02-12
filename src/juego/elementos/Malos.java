package juego.elementos;

import juego.movimientos.Perseguir;

public class Malos extends Elementos {
    public static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m";
    
    /**
     * Constructor que crea un personaje malo en una posición específica.
     * Automáticamente asigna la estrategia de movimiento Perseguir.
     * 
     * @param x Coordenada horizontal inicial
     * @param y Coordenada vertical inicial
     */
    public Malos(int x, int y){
        super(x, y, new Perseguir());
    }

    /**
     * Retorna la representación visual del personaje malo.
     * Se muestra como un bloque rojo en la consola.
     * 
     * @return String con el carácter de bloque en color rojo
     */
    @Override
    public String toString() {
        return RED+"█"+RESET;
    }

    /**
     * Identifica a este elemento como un personaje malo.
     * Sobrescribe el método de la clase base.
     * 
     * @return true siempre, indicando que es un personaje malo
     */
    @Override
    public boolean esMalo() {
        return true;
    }
}