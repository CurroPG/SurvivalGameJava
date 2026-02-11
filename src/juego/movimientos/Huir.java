package juego.movimientos;

import juego.elementos.Elementos;
import juego.posicion.Posicion;

public class Huir implements Movimiento{

    @Override
    public Posicion mover(Posicion actual, Posicion objetivo, Elementos[][] mapa) {
        int[] posiblesX = { -1, 0, 1, -1, 1, -1, 0, 1 };
        int[] posiblesY = { -1, -1, -1, 0, 0, 1, 1, 1 };

        double mayorDistancia = 0;
        int vx = 0;
        int vy = 0;

        for (int i = 0; i < posiblesX.length; i++) {
            int nuevaX = actual.getX() + posiblesX[i];
            int nuevaY = actual.getY() + posiblesY[i];

            if (nuevaX >= 0 && nuevaX < mapa[0].length && nuevaY >= 0 && nuevaY < mapa.length) {
                if (mapa[nuevaY][nuevaX] == null || (!mapa[nuevaY][nuevaX].esObstaculo() && !mapa[nuevaY][nuevaX].esBueno())) {
                    Posicion posicionPrueba = new Posicion(nuevaX, nuevaY);
                    double distancia = Posicion.calcularDistancia(posicionPrueba, objetivo);

                    if (distancia > mayorDistancia) {
                        mayorDistancia = distancia;
                        vx = posiblesX[i];
                        vy = posiblesY[i];
                    }
                }
            }
        }
        return new Posicion(actual.getX() + vx, actual.getY() + vy);
    }
}
