package juego.elementos;

import juego.movimientos.Movimiento;
import juego.posicion.Posicion;

public abstract class Elementos {
    protected Posicion posi;
    protected Elementos objetivo;
    protected Movimiento tipoMovimiento;

    public Elementos(int x, int y, Movimiento tipoMovimiento) {
    this.posi = new Posicion(x, y);
    this.tipoMovimiento = tipoMovimiento;
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

    public boolean esObstaculo() {
        return false;
    }

    public boolean esMalo() {
        return false;
    }

    public boolean esBueno() {
        return false;
    }

    public void mover(Elementos[][] mapa){
        if(objetivo != null){
            Posicion nuevaPosi = tipoMovimiento.mover(this.posi, objetivo.getPosi(), mapa);
            this.posi = nuevaPosi;
        }
    }

}
