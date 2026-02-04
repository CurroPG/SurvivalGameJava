package juego.elementos;

import juego.posicion.Posicion;

public abstract class Elementos {
    protected Posicion posi;
    protected Elementos objetivo;

    public Elementos(Elementos objetivo, int x, int y) {
    this.posi = new Posicion(x, y);
    this.objetivo = objetivo;
    }

    public int getPosiX() {
        return posi.getX();
    }
    
    public int getPosiY() {
        return posi.getY();
    }

    public Posicion getPosi() {
        return posi;
    }

    public void setObjetivo(Elementos objetivo) {
        this.objetivo = objetivo;
    }

    public abstract String toString();

}
