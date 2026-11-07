import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VisorImagen {
    // Atributos estáticos
    private static int contadorVentanas = 0;
    private static List<JFrame> ventanas = new ArrayList<>();

    // Método que muestra en una ventana gráfica la imagen
    public static void mostrar(Imagen imagen) {
        BufferedImage imagenBuffered = convertir(imagen);
        JFrame ventana = new JFrame("Ventana " + contadorVentanas);
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventana.add(new JLabel(new ImageIcon(imagenBuffered)));
        ventana.pack();
        ventana.setLocationRelativeTo(null);
        ventana.setLocation(10+50*contadorVentanas,10+50*contadorVentanas);
        contadorVentanas++;
        ventana.setVisible(true);
        ventanas.add(ventana);
    }

    // Método que cierra todas las ventanas gráficas abiertas
    public static void cerrarVentanas() {
        for (JFrame ventana : ventanas) {
            ventana.dispose();
        }
        ventanas.clear();
    }

    // Método privado que convierte una objeto de la clase Imagen a
    //   una imagen AWT de Java
    private static BufferedImage convertir(Imagen imagen) {
        int ancho = imagen.getAncho();
        int alto = imagen.getAlto();
        BufferedImage resultado = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_RGB);
        int[][] pixeles = imagen.getPixeles();
        Paleta paleta = imagen.getPaleta();
        // Recorremos la imagen usando (x,y)
        for (int x = 0; x < ancho; x++) {
            for (int y = 0; y < alto; y++) {
                // Índice del color en la paleta
                int indice = pixeles[x][y];
                // Obtenemos el color RGB de la paleta
                ColorRGB colorRGB = paleta.getColorRGB(indice);
                // Convertimos nuestro ColorRGB a java.awt.Color
                Color color = new Color(colorRGB.getR(), colorRGB.getG(), colorRGB.getB());
                // Asignamos el color al píxel
                resultado.setRGB(x, y, color.getRGB());
            }
        }
        return resultado;
    }
}
