package juego.elementos;

public class Obstaculos extends Elementos{
    /**
     * Constructor que crea un obstáculo en una posición específica.
     * Los obstáculos no tienen estrategia de movimiento (null).
     * 
     * @param x Coordenada horizontal del obstáculo
     * @param y Coordenada vertical del obstáculo
     */
    public Obstaculos(int x, int y){
        super(x, y, null);
    }
    
    /**
     * Retorna la representación visual del obstáculo.
     * Se muestra como un bloque sin color (blanco) en la consola.
     * 
     * @return String con el carácter de bloque
     */
    @Override
    public String toString() {
        return "█";
    }

    /**
     * Identifica a este elemento como un obstáculo.
     * Sobrescribe el método de la clase base.
     * 
     * @return true siempre, indicando que es un obstáculo
     */
    @Override
    public boolean esObstaculo() {
        return true;
    }
}
