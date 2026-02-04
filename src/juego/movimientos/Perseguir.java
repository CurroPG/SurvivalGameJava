package juego.movimientos;

import juego.posicion.Posicion;

public class Perseguir implements Movimiento{

    @Override
    public Posicion mover(Posicion actual, Posicion objetivo) {
        int vx, vy;
        do{
            vx = (int)(Math.random()*3-1);
            vy = (int)(Math.random()*3-1);
        }while(vy == 0 && vx == 0);
        return new Posicion(actual.getX()+vx, actual.getY()+vy);
    }
    
}
