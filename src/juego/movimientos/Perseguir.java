package juego.movimientos;

import juego.posicion.Posicion;

public class Perseguir implements Movimiento {

    //Metodo con la distancia Manhattan
    @Override
    public Posicion mover(Posicion actual, Posicion objetivo) {
        // Probar todas las direcciones posibles
        int[] posiblesX = { -1, 0, 1, -1, 1, -1, 0, 1 };
        int[] posiblesY = { -1, -1, -1, 0, 0, 1, 1, 1 };

        double menorDistancia = Double.MAX_VALUE;
        int vx = 0;
        int vy = 0;

        for (int i = 0; i < posiblesX.length; i++) {
            int nuevaX = actual.getX() + posiblesX[i];
            int nuevaY = actual.getY() + posiblesY[i];

            Posicion posicionPrueba = new Posicion(nuevaX, nuevaY);
            double distancia = Posicion.calcularDistancia(posicionPrueba, objetivo);

            if (distancia < menorDistancia) {
                menorDistancia = distancia;
                vx = posiblesX[i];
                vy = posiblesY[i];
            }
        }
        return new Posicion(actual.getX() + vx, actual.getY() + vy);
    }

}
