import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Ejercicio1 {
    public static void main(String[] args) {
        String[] placas = {"JNT400", "QNA555", "AAA123", "CVY000", "QKA233", "MJO941", "BCM122"};
        int[] matriculas = {40010231, 5055178, 4891230, 14503098, 24353789, 39941452, 7841263};

        System.out.println("Datos:");
        imprimir(placas, matriculas);

        ordenarRadix(placas, matriculas);

        System.out.println("\nDatos ordenados:");
        imprimir(placas, matriculas);

        String buscarPlaca = "JNT400";
        int resultado = busquedaBinaria(placas, buscarPlaca);

        if (resultado != -1) {
            System.out.println("\nBusqueda:" + "\nPlaca: " + buscarPlaca + "\nMatricula: " + matriculas[resultado]);
        } else {
            System.out.println("\nLa placa " + buscarPlaca + " no se encuentra");
        }
    }

    public static void ordenarRadix(String[] placas, int[] matriculas) {
        int maxLongitud = 0;

        for (String placa : placas) {
            maxLongitud = Math.max(maxLongitud, placa.length());
        }

        for (int posicion = maxLongitud - 1; posicion >= 0; posicion--) {

            List<Queue<String>> contenedoresPlacas = new ArrayList<>();
            List<Queue<Integer>> contenedoresMatriculas = new ArrayList<>();
            for (int i = 0; i < 36; i++) {
                contenedoresPlacas.add(new LinkedList<>());
                contenedoresMatriculas.add(new LinkedList<>());
            }

            for (int i = 0; i < placas.length; i++) {
                char caracter = (posicion < placas[i].length()) ? placas[i].charAt(posicion) : '0';
                int indice = (caracter >= 'A') ? caracter - 'A' + 10 : caracter - '0';
                contenedoresPlacas.get(indice).add(placas[i]);
                contenedoresMatriculas.get(indice).add(matriculas[i]);
            }

            int index = 0;
            for (int i = 0; i < 36; i++) {
                while (!contenedoresPlacas.get(i).isEmpty()) {
                    placas[index] = contenedoresPlacas.get(i).poll();
                    matriculas[index] = contenedoresMatriculas.get(i).poll();
                    index++;
                }
            }
        }
    }

    public static void imprimir(String[] placas, int[] matriculas) {
        System.out.println("Placas: \t" + String.join(", \t", placas));
        System.out.print("Matrículas: ");
        for (int matricula : matriculas) {
            System.out.print(matricula + ", \t");
        }
        System.out.println();
    }

    public static int busquedaBinaria(String[] placas, String clave) {
        int inicio = 0;
        int fin = placas.length - 1;

        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;

            int comparacion = placas[medio].compareTo(clave);
            if (comparacion == 0) {
                return medio;
            } else if (comparacion < 0) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }
        return -1;
    }

}
