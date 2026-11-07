public class Imagen {
    // Atributos
    private int ancho;
    private int alto;
    private int numColores;
    private Paleta paleta;
    private int[][] pixeles;

    // Constructores
    public Imagen(int ancho, int alto, int numColores) {
        this.ancho = ancho;
        this.alto = alto;
        this.numColores = numColores;
        paleta = new Paleta(numColores);
        pixeles = new int[ancho][alto];
    }

    public Imagen(int[][] pixeles, Paleta paleta) {
        ancho = pixeles.length;
        alto = pixeles[0].length;
        numColores = paleta.getTamaño();
        this.paleta = paleta;
        this.pixeles = pixeles;
    }

    // setters y getters
    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }

    public int getNumColores() {
        return numColores;
    }

    public Paleta getPaleta() {
        return paleta;
    }

    public int[][] getPixeles() {
        return pixeles;
    }

    // Métodos
    public void espejoHorizontal() {

    }

    public void espejoVertical() {

    }

    public void rotar180() {

    }

    public void invertirColores() {

    }

    public void convertirAGrises() {

    }
    /*
    public Imagen duplicar() {

    }

    public boolean equals(Imagen imagen) {

    }

     */
}