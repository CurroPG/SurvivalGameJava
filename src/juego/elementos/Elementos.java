package juego.elementos;

import juego.movimientos.Movimiento;
import juego.posicion.Posicion;

public abstract class Elementos {
    protected Posicion posi;
    protected Elementos objetivo;
    protected Movimiento tipoMovimiento;

    /**
     * Constructor que inicializa un elemento con una posición y estrategia de movimiento.
     * 
     * @param x Coordenada horizontal inicial
     * @param y Coordenada vertical inicial
     * @param tipoMovimiento Estrategia de movimiento a utilizar (puede ser null para elementos estáticos)
     */
    public Elementos(int x, int y, Movimiento tipoMovimiento) {
        this.posi = new Posicion(x, y);
        this.tipoMovimiento = tipoMovimiento;
    }

    /**
     * Obtiene la coordenada X de la posición del elemento.
     * 
     * @return Coordenada horizontal del elemento
     */
    public int getPosiX() {
        return posi.getX();
    }
    
    /**
     * Obtiene la coordenada Y de la posición del elemento.
     * 
     * @return Coordenada vertical del elemento
     */
    public int getPosiY() {
        return posi.getY();
    }

    /**
     * Obtiene el objeto Posicion completo del elemento.
     * 
     * @return Objeto Posicion que contiene las coordenadas x e y
     */
    public Posicion getPosi() {
        return posi;
    }

    /**
     * Establece el elemento objetivo para este elemento.
     * El objetivo es usado por la estrategia de movimiento para determinar
     * la dirección del desplazamiento.
     * 
     * @param objetivo Elemento a perseguir o del que huir
     */
    public void setObjetivo(Elementos objetivo) {
        this.objetivo = objetivo;
    }

    /**
     * Método abstracto que debe ser implementado por las subclases.
     * Define la representación visual del elemento en el mapa.
     * 
     * @return String que representa visualmente el elemento (puede incluir códigos ANSI de color)
     */
    public abstract String toString();

    /**
     * Indica si este elemento es un obstáculo.
     * Implementación por defecto retorna false.
     * 
     * @return true si el elemento es un obstáculo, false en caso contrario
     */
    public boolean esObstaculo() {
        return false;
    }

    /**
     * Indica si este elemento es un personaje malo (perseguidor).
     * Implementación por defecto retorna false.
     * 
     * @return true si el elemento es un malo, false en caso contrario
     */
    public boolean esMalo() {
        return false;
    }

    /**
     * Indica si este elemento es un personaje bueno (huye).
     * Implementación por defecto retorna false.
     * 
     * @return true si el elemento es un bueno, false en caso contrario
     */
    public boolean esBueno() {
        return false;
    }

    /**
     * Ejecuta el movimiento del elemento utilizando su estrategia de movimiento.
     * Delega el cálculo de la nueva posición a la estrategia asignada (patrón Strategy).
     * Si no hay objetivo asignado, el elemento no se mueve.
     * 
     * @param mapa Matriz bidimensional que representa el estado actual del mapa.
     *             Se utiliza para verificar obstáculos y otros elementos.
     */
    public void mover(Elementos[][] mapa){
        if(objetivo != null){
            Posicion nuevaPosi = tipoMovimiento.mover(this.posi, objetivo.getPosi(), mapa);
            this.posi = nuevaPosi;
        }
    }
}