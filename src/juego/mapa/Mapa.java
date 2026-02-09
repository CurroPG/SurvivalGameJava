package juego.mapa;

import juego.posicion.Posicion;

import java.util.ArrayList;

import juego.elementos.Buenos;
import juego.elementos.Malos;
import juego.elementos.Obstaculos;
import juego.elementos.Elementos;

public class Mapa implements Rellenar {
    private int alto;
    private int ancho;
    private Elementos mapa[][];
    private ArrayList<Buenos> buenos;
    private ArrayList<Malos> malos;

    public Mapa(int alto, int ancho) {
        this.alto = alto;
        this.ancho = ancho;
        this.mapa = new Elementos[alto][ancho];
        this.buenos = new ArrayList<>();
        this.malos = new ArrayList<>();
    }

    public int getAlto() {
        return alto;
    }

    public int getAncho() {
        return ancho;
    }

    public int getArea() {
        return this.alto * this.ancho;
    }

    public void limpiar() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void pintar() {
        System.out.print("+");
        for (int i = 0; i < ancho; i++) {
            System.out.print("-");
        }
        System.out.println("+");

        for (int i = 0; i < alto; i++) {
            System.out.print("|");
            for (int j = 0; j < ancho; j++) {
                if (mapa[i][j] == null) {
                    System.out.print(" ");
                } else {
                    System.out.print(mapa[i][j]);
                }
            }
            System.out.println("|");
        }

        System.out.print("+");
        for (int i = 0; i < ancho; i++) {
            System.out.print("-");
        }
        System.out.println("+");
    }

    public void generarElementos() {
        generarBuenos();
        generarMalos();
        generarObstaculos();
    }

    // Comprobacion de casillas para que no se repita

    @Override
    public boolean comprobarCasillas(int x, int y) {
        return mapa[y][x] != null;
    }

    // Generador de elementos del mapa

    @Override
    public void generarObstaculos() {
        int numObstaculos = (int) (Math.random() * (getArea() * 0.01) + 1);
        int x = 0;
        int y = 0;

        for (int i = 0; i < numObstaculos; i++) {
            do {
                x = (int) (Math.random() * ancho);
                y = (int) (Math.random() * alto);
            } while (comprobarCasillas(x, y));
            mapa[y][x] = new Obstaculos(x, y);
        }
    }

    @Override
    public void generarBuenos() {
        int numBuenos = (int) (Math.random() * (getArea() * 0.02) + 1);
        int x = 0;
        int y = 0;

        for (int i = 0; i < numBuenos; i++) {
            do {
                x = (int) (Math.random() * ancho);
                y = (int) (Math.random() * alto);
            } while (comprobarCasillas(x, y));
            Buenos bueno = new Buenos(x, y);
            buenos.add(bueno);
            mapa[y][x] = bueno;
        }
    }

    @Override
    public void generarMalos() {
        int numMalos = (int) (Math.random() * (getArea() * 0.01) + 1);
        int x = 0;
        int y = 0;

        for (int i = 0; i < numMalos; i++) {
            do {
                x = (int) (Math.random() * ancho);
                y = (int) (Math.random() * alto);
            } while (comprobarCasillas(x, y));
            Malos malo = new Malos(x, y);
            mapa[y][x] = malo;
            malos.add(malo);
        }
    }

    // Localizadores de enemigos

    private Malos localizarMaloCercano(Buenos bueno) {
        Malos cercano = null;
        double distanciaMinima = Double.MAX_VALUE;

        for (Malos malo : malos) {
            double distancia = Posicion.calcularDistancia(malo.getPosi(), bueno.getPosi());
            if (distancia < distanciaMinima) {
                distanciaMinima = distancia;
                cercano = malo;
            }
        }
        return cercano;
    }

    private Buenos localizarBuenoCercano(Malos malo) {
        Buenos cercano = null;
        double distanciaMinima = Double.MAX_VALUE;

        for (Buenos bueno : buenos) {
            double distancia = Posicion.calcularDistancia(malo.getPosi(), bueno.getPosi());
            if (distancia < distanciaMinima) {
                distanciaMinima = distancia;
                cercano = bueno;
            }
        }
        return cercano;
    }

    // Metodo que va refrescando el mapa por cada iteraccion

    public void refrescarMapa() {
        for (Buenos bueno : buenos) {
            bueno.setObjetivo(localizarMaloCercano(bueno));
            mapa[bueno.getPosiY()][bueno.getPosiX()] = null;
        }

        for (Malos malo : malos) {
            malo.setObjetivo(localizarBuenoCercano(malo));
            mapa[malo.getPosiY()][malo.getPosiX()] = null;
        }

        for (Buenos bueno : buenos) {
            bueno.mover(mapa);
        }

        for (Malos malo : malos) {
            malo.mover(mapa);
        }

        eliminarMuertos();

        for (Buenos bueno : buenos) {
            mapa[bueno.getPosiY()][bueno.getPosiX()] = bueno;
        }

        for (Malos malo : malos) {
            mapa[malo.getPosiY()][malo.getPosiX()] = malo;
        }
    }

    // Crear arraylist privada para meter los vivos con vida y separarlos de los
    // mjuertos
    // con un for each anidado de buenos y malos que vaya comprobando que el malo
    // haya matado o no
    private void eliminarMuertos() {
        ArrayList<Buenos> buenosVivos = new ArrayList<>();

        for (Buenos bueno : buenos) {
            boolean muerto = false;
            for (Malos malo : malos) {
                if (malo.getPosiX() == bueno.getPosiX() && malo.getPosiY() == bueno.getPosiY()) {
                    muerto = true;
                    break;
                }
            }
            if (!muerto)
                buenosVivos.add(bueno);
        }

        buenos = buenosVivos;
    }
}
