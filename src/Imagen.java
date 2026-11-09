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
        //TODO Preguntar

        Imagen copia = duplicar();

        /*
        int aux[][] = new int[ancho][alto];
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                aux[i][j] = pixeles[i][j];
            }
        }
         */
        for (int i = 0; i < ancho ; i++) {
            for (int j = 0; j < alto ; j++) {
                pixeles[i][j] = copia.pixeles[ancho-1-i][j];
            }
        }
    }

    public void espejoVertical() {
        for (int i = 0; i < ancho ; i++) {
            int[] aux = new int[alto];
            for (int j = 0; j < alto; j++) {
                aux[j] = pixeles[i][j];
            }
            for (int j = 0; j < alto ; j++) {
                pixeles[i][j] = aux[alto-1-j];
            }
        }
    }

    public void rotar180() {
        espejoHorizontal();
        espejoVertical();
    }

    public void invertirColores() {
        for (int i = 0; i < numColores; i++) {
            ColorRGB color = paleta.getColorRGB(i);
            ColorRGB colorInv = new ColorRGB(255-color.getR(),255-color.getG(),255-color.getB());
            paleta.setColorRGB(i, colorInv);
        }
    }

    public void convertirAGrises() {
        for (int i = 0; i < numColores; i++) {
            ColorRGB color = paleta.getColorRGB(i);
            int gris = (int) (0.299*color.getR()+0.587*color.getG()+0.114*color.getB());
            ColorRGB colorGris = new ColorRGB(gris, gris, gris);
            paleta.setColorRGB(i, colorGris);
        }
    }
    public Imagen duplicar() {

        int aux[][] = new int[ancho][alto];
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                aux[i][j] = pixeles[i][j];
            }
        }
        Imagen copia = new Imagen(aux, paleta);
        return copia;
    }
/*
    public boolean equals(Imagen imagen) {

    }
    */
}