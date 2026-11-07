import java.io.*;

public class GestionImagen {

    private static final int PIXELADO = 10; // pixelado de NxN de la imagen de prueba

    public static void main(String[] args) {
        Imagen imagen = null;
        int opcion;
        do {
            opcion = menu();
            switch (opcion) {
                case 1:
                    imagen = cargarImagenDePrueba();
                    break;
                case 2:
                    VisorImagen.mostrar(imagen);
                    break;
                case 3:
                    // Aplicar espejo horizontal
                    break;
                case 4:
                    // Aplicar espejo vertical
                    break;
                case 5:
                    // Rotar 180º
                    break;
                case 6:
                    // Invertir colores
                    break;
                case 7:
                    // Convertir a grises
                    break;
                case 8:
                    // Guardar la imagen .txt
                    break;
                case 9:
                    // Cargar la imagen .txt
            }
        } while (opcion != 0);
        VisorImagen.cerrarVentanas();
    }

    public static int menu() {
        String mensaje = "MENU\n" +
                "====\n" +
                "1. Cargar imagen de prueba.\n" +
                "2. Mostrar imagen.\n" +
                "3. Aplicar espejo horizontal.\n" +
                "4. Aplicar espejo vertical.\n" +
                "5. Rotar la imagen 180 grados.\n" +
                "6. Invertir los colores.\n" +
                "7. Convertir a grises.\n" +
                "8. Guardar la imagen en un fichero .txt.\n" +
                "9. Cargar la imagen desde un fichero .txt.\n" +
                "0. Salir.";
        return Teclado.leerEntero(0,9, mensaje);
    }

    public static Imagen cargarImagenDePrueba() {
        return new Imagen(cargarPixeles(), cargarPaleta());
    }

    private static Paleta cargarPaleta() {
        int tam = ImagenDePrueba.PALETA.length;
        Paleta paleta = new Paleta(tam);
        for (int i = 0; i < tam; i++) {
            int r = ImagenDePrueba.PALETA[i][0];
            int g = ImagenDePrueba.PALETA[i][1];
            int b = ImagenDePrueba.PALETA[i][2];
            paleta.setColorRGB(i, r, g, b);
        }
        return paleta;
    }

    private static int[][] cargarPixeles() {
        int ancho = ImagenDePrueba.PIXELES.length;
        int alto = ImagenDePrueba.PIXELES[0].length;
        int[][] pixeles = new int[ancho*PIXELADO][alto*PIXELADO];
        for (int i = 0; i < ancho; i++)
            for (int j = 0; j < alto; j++)
                for (int k = 0; k < PIXELADO; k++)
                    for (int l = 0; l < PIXELADO; l++)
                        pixeles[i*PIXELADO+k][j*PIXELADO+l] = ImagenDePrueba.PIXELES[i][j];
        return pixeles;
    }

    /* Formato del fichero binario de imagen
     * ANCHO                (int)
     * ALTO                 (int)
     * NÚMERO DE COLORES    (int)
     * COMPRESION           (int)  // 0: no tiene, 1: RLE
     * PALETA               (int int int) x NÚMERO DE COLORES
     * PIXELES              (int) x ANCHO x ALTO sin comprimir
     */
    public static void guardarImagen(Imagen imagen, String fichero, boolean comprimida) {

    }

    public static Imagen cargarImagen(String fichero) {
        return new Imagen(0,0,0);
    }
}
