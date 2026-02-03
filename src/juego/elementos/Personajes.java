package juego.elementos;

import juego.posicion.Posicion;

public abstract class Personajes {
    protected Posicion posi;
    protected int vida;

    public Personajes(int vida, int x, int y) {
    this.posi = new Posicion(x, y);
    this.vida = vida;
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

    public int getVida() {
        return vida;
    }

    public abstract String toString();
}
