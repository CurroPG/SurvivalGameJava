package juego.movimientos;

import juego.posicion.Posicion;

public class Huir implements Movimiento{
    private static final double DISTANCIA_SEGURA = 5.0;

    @Override
    public Posicion mover(Posicion actual, Posicion objetivo) {
        double distanciaEntreAmbos = Posicion.calcularDistancia(actual, objetivo);
        int vx, vy;

        if(distanciaEntreAmbos > DISTANCIA_SEGURA)
            return new Posicion(actual.getX(), actual.getY());
        do{
            vx = (int)(Math.random()*2-1);
            vy = (int)(Math.random()*2-1);
        }while(vy == 0 && vx == 0);
        return new Posicion(actual.getX()+vx, actual.getY()+vy);
    }
}
