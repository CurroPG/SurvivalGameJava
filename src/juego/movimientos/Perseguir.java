package juego.movimientos;

import juego.posicion.Posicion;

public class Perseguir implements Movimiento {

    //Metodo con la distancia Manhattan
    @Override
    public Posicion mover(Posicion actual, Posicion objetivo) {
        if (objetivo == null)
            return new Posicion(actual.getX(), actual.getY());
        // Probar todas las direcciones posibles
        int[] posiblesX = { -1, 0, 1, -1, 1, -1, 0, 1 };
        int[] posiblesY = { -1, -1, -1, 0, 0, 1, 1, 1 };

        double mejorDistancia = Double.MAX_VALUE;
        int mejorVx = 0;
        int mejorVy = 0;

        for (int i = 0; i < posiblesX.length; i++) {
            int nuevaX = actual.getX() + posiblesX[i];
            int nuevaY = actual.getY() + posiblesY[i];

            Posicion posicionPrueba = new Posicion(nuevaX, nuevaY);
            double distancia = Posicion.calcularDistancia(posicionPrueba, objetivo);

            if (distancia < mejorDistancia) {
                mejorDistancia = distancia;
                mejorVx = posiblesX[i];
                mejorVy = posiblesY[i];
            }
        }
        return new Posicion(actual.getX() + mejorVx, actual.getY() + mejorVy);
    }

}
