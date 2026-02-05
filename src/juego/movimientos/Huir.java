package juego.movimientos;

import juego.posicion.Posicion;

public class Huir implements Movimiento{
    private static final double DISTANCIA_SEGURA = 10.0;

    @Override
    public Posicion mover(Posicion actual, Posicion objetivo) {
        double distanciaEntreAmbos = Posicion.calcularDistancia(actual, objetivo);
        int vx, vy;
        int x = objetivo.getX() - actual.getX(); 
        int y = objetivo.getY() - actual.getY();
        if(distanciaEntreAmbos > DISTANCIA_SEGURA)
            return new Posicion(actual.getX(), actual.getY());
        else{
            vx = (x <= 0) ? 1 : -1;
            vy = ( y <= 0) ? 1 : -1;
        }
        return new Posicion(actual.getX()+vx, actual.getY()+vy);
    }
}
