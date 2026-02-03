package juego.mapa;

import juego.elementos.Buenos;
import juego.elementos.Malos;
import juego.elementos.Obstaculos;
import juego.elementos.Personajes;
import juego.mapa.rellenar.Rellenar;

public class Mapa implements Rellenar{
    private int alto;
    private int ancho;
    private Personajes mapa[][];

    public Mapa(int alto, int ancho) {
        this.alto = alto;
        this.ancho = ancho;
        this.mapa = new Personajes[alto][ancho];
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

    @Override
    public boolean comprobarCasillas(int x, int y) {
        return mapa[y][x] != null;
    }

    @Override
    public void generarObstaculos() {
        int numObstaculos = (int)(Math.random()*(getArea()*0.01)+1);
        int x = 0;
        int y = 0;
        for(int i = 0; i < numObstaculos; i++){
            do{
                x = (int)(Math.random()*ancho);
                y = (int)(Math.random()*alto);
            }while(comprobarCasillas(x, y));
            mapa[y][x] = new Obstaculos(x, y);
        }
    }

    public void generarElementos(){
        generarBuenos();
        generarMalos();
        generarObstaculos();
    }

    @Override
    public void generarBuenos() {
        int numBuenos = (int)(Math.random()*(getArea()*0.02)+1);
        int x = 0;
        int y = 0;
        for(int i = 0; i < numBuenos; i++){
            do{
                x = (int)(Math.random()*ancho);
                y = (int)(Math.random()*alto);
            }while(comprobarCasillas(x, y));
            mapa[y][x] = new Buenos(10,x, y);
        }
    }

    @Override
    public void generarMalos() {
        int numMalos = (int)(Math.random()*(getArea()*0.02)+1);
        int x = 0;
        int y = 0;
        for(int i = 0; i < numMalos; i++){
            do{
                x = (int)(Math.random()*ancho);
                y = (int)(Math.random()*alto);
            }while(comprobarCasillas(x, y));
            mapa[y][x] = new Malos(10,x, y);
        }
    }

    public void pintar() {
        System.out.print("+");
        for (int i = 0; i < ancho; i++) {
            System.out.print("-");
        }
        System.out.println("+");

        for (int y = 0; y < alto; y++) {
            System.out.print("|"); 
            for (int x = 0; x < ancho; x++) {
                if (mapa[y][x] == null) {
                    System.out.print(" "); 
                } else {
                    System.out.print(mapa[y][x]); 
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
}
