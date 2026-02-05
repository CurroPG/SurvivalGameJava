package juego.movimientos;

import juego.posicion.Posicion;

public class Perseguir implements Movimiento{

    @Override
    public Posicion mover(Posicion actual, Posicion objetivo) {
        int vx, vy;
        int x = objetivo.getX() - actual.getX(); 
        int y = objetivo.getY() - actual.getY();
        
        do{
            vx = (x >= 0) ? 1 : -1;
            vy = ( y >= 0) ? 1 : -1;
        }while(vy == 0 && vx == 0);
        return new Posicion(actual.getX()+vx, actual.getY()+vy);
    }
    
}
