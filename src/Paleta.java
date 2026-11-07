public class Paleta {

    private int tamaño;
    private ColorRGB[] colores;

    public Paleta(int tamaño) {
        colores = new ColorRGB[tamaño];
    }

    public void setColorRGB(int i, ColorRGB color) {
        if (i < tamaño){
            colores[i] = color;
        }
    }

    public void setColorRGB(int i, int r, int g, int b) {
            ColorRGB color = new ColorRGB(r, g, b);
            setColorRGB(i, color);
    }

    public ColorRGB getColorRGB(int i) {
        return colores[i];
    }

    public int getTamaño() {
        return tamaño;
    }
}
