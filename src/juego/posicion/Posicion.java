package juego.posicion;



public class Posicion {
    private int x;
    private int y;

    public Posicion(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }

    public double calcularDistancia(Posicion personaje1, Posicion personaje2){
        return Math.sqrt(Math.pow(personaje1.getX()-personaje2.getX(), 2) + Math.pow(personaje1.getY()-personaje2.getY(), 2));
    }
}
