package juego.posicion;

public class Posicion {
    private int x;
    private int y;

    /**
     * Constructor que inicializa una posición con coordenadas específicas.
     * 
     * @param x Coordenada horizontal (eje X)
     * @param y Coordenada vertical (eje Y)
     */
    public Posicion(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * Obtiene la coordenada horizontal de la posición.
     * 
     * @return El valor de la coordenada x
     */
    public int getX() {
        return x;
    }
    
    /**
     * Establece la coordenada horizontal de la posición.
     * 
     * @param x Nuevo valor para la coordenada x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Obtiene la coordenada vertical de la posición.
     * 
     * @return El valor de la coordenada y
     */
    public int getY() {
        return y;
    }
    
    /**
     * Establece la coordenada vertical de la posición.
     * 
     * @param y Nuevo valor para la coordenada y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Calcula la distancia euclidiana entre dos posiciones.
     * Utiliza el teorema de Pitágoras: d = √[(x₂-x₁)² + (y₂-y₁)²]
     * 
     * @param personaje1 Primera posición
     * @param personaje2 Segunda posición
     * @return La distancia euclidiana entre las dos posiciones como valor double
     */
    public static double calcularDistancia(Posicion personaje1, Posicion personaje2){
        return Math.sqrt(Math.pow(personaje1.getX()-personaje2.getX(), 2) + Math.pow(personaje1.getY()-personaje2.getY(), 2));
    }
}
