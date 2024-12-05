import java.util.ArrayList;
import java.util.List;

public class RadixPalabra {

    public static void main(String[] args) {
        String[] palabras = {"manzana", "banana", "pera", "durazno", "cereza", "arandano", "fresa", "kiwi"};
        System.out.println("Lista de palabras original:");
        for (String palabra : palabras) {
            System.out.print(palabra + " ");
        }
        System.out.println();

        String[] palabrasOrdenadas = ordenarPalabrasPorInicial(palabras);
        System.out.println("Lista de palabras ordenada:");
        for (String palabra : palabrasOrdenadas) {
            System.out.print(palabra + " ");
        }
    }

    public static String[] ordenarPalabrasPorInicial(String[] palabras) {
        List<String>[] buckets = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (String palabra : palabras) {
            char inicial = Character.toLowerCase(palabra.charAt(0));
            int bucketIndex = inicial - 'a';
            buckets[bucketIndex].add(palabra);
        }

        int index = 0;
        for (List<String> bucket : buckets) {
            for (String palabra : bucket) {
                palabras[index++] = palabra;
            }
        }
        return palabras;
    }
}

