package juego.movimientos;

import juego.elementos.Elementos;
import juego.posicion.Posicion;

public class Huir implements Movimiento{
    /**
     * Calcula la nueva posición que maximiza la distancia al objetivo.
     * 
     * El algoritmo:
     * 1. Evalúa las 8 posiciones adyacentes (incluyendo diagonales)
     * 2. Filtra posiciones inválidas (fuera del mapa, obstáculos, otros buenos)
     * 3. Calcula la distancia euclidiana al objetivo para cada posición válida
     * 4. Selecciona la posición con mayor distancia
     * 
     * Si no hay posiciones válidas disponibles, el elemento permanece en su lugar.
     * 
     * @param actual Posición actual del elemento que huye
     * @param objetivo Posición del elemento del que se está huyendo
     * @param mapa Matriz del mapa para verificar obstáculos y límites
     * @return Nueva posición que maximiza la distancia al objetivo,
     *         o la posición actual si no hay movimientos válidos
     */
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
