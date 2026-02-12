package juego.mapa;

public interface Rellenar {
    /**
     * Verifica si una casilla específica del mapa está ocupada.
     * 
     * Este método es esencial para evitar solapamientos al generar
     * nuevos elementos en el mapa.
     * 
     * @param x Coordenada horizontal de la casilla a verificar
     * @param y Coordenada vertical de la casilla a verificar
     * @return true si la casilla está ocupada, false si está vacía
     */
    public boolean comprobarCasillas(int x, int y);
    
    /**
     * Genera obstáculos aleatorios en el mapa.
     * 
     * Los obstáculos son elementos estáticos que bloquean el movimiento
     * de los personajes. La cantidad generada se basa en un porcentaje
     * del área total del mapa.
     */
    public void generarObstaculos();
    
    /**
     * Genera personajes buenos aleatorios en el mapa.
     * 
     * Los buenos son personajes que huyen de los malos. Se generan
     * en posiciones aleatorias no ocupadas del mapa.
     */
    public void generarBuenos();
    
    /**
     * Genera personajes malos aleatorios en el mapa.
     * 
     * Los malos son personajes que persiguen a los buenos. Se generan
     * en posiciones aleatorias no ocupadas del mapa.
     */
    public void generarMalos();
}
