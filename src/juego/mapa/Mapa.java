package juego.mapa;

import juego.elementos.Personajes;

public class Mapa {
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
