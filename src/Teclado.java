import java.util.Scanner;

public class Teclado {
    // Método que lee un entero
    public static int leerEntero(int menor, int mayor, String mensaje) {
		Scanner entrada = new Scanner(System.in);
        int resultado = 0;
        boolean correcto = false;
        do {
            System.out.print(mensaje);
			if (entrada.hasNextInt()) {
				resultado = entrada.nextInt();
				correcto = resultado >= menor && resultado <= mayor;
			} else {
				entrada.nextLine();
			}
        } while (!correcto);
        return resultado;
    }

    // Método que lee una cadena de texto
    public static String leerString(String mensaje) {
		Scanner entrada = new Scanner(System.in);
        System.out.print(mensaje);
        String resultado = entrada.nextLine();
        return resultado;
    }

    // Método que lee una S o una N
    public static char leerSiNo(String mensaje) {
		Scanner entrada = new Scanner(System.in);
        char resultado = ' ';
        boolean correcto = false;
        do {
            System.out.print(mensaje);
            String cadena = entrada.nextLine();
			if (cadena.equals("S") || cadena.equals("s")) {
                resultado = 'S';
                correcto = true;
            } else if (cadena.equals("N") || cadena.equals("n")) {
                resultado = 'N';
                correcto = true;
            }
        } while (!correcto);
        return resultado;
    }
}
