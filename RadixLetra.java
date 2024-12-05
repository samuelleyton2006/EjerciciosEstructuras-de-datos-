import java.util.ArrayList;
import java.util.List;

public class RadixLetra {

    public static void main(String[] args) {
        String cadena = "qwertyuiopasdfghjklzxcvbnm";
        System.out.println("Cadena de Caracteres original: " + cadena);

        String cadenaOrdenada = ordenarCadena(cadena);
        System.out.println("Cadena de Caracteres ordenada: " + cadenaOrdenada);
    }

    public static String ordenarCadena(String cadena) {
        char[] caracteres = cadena.toCharArray();

        int pasadas = 26;

        for (int i = 0; i < pasadas; i++) {
            List<Character>[] buckets = new ArrayList[26];

            for (int j = 0; j < 26; j++) {
                buckets[j] = new ArrayList<>();
            }

            for (char c : caracteres) {
                int bucketIndex = c - 'a';
                buckets[bucketIndex].add(c);
            }

            int index = 0;
            for (List<Character> bucket : buckets) {
                for (char c : bucket) {
                    caracteres[index++] = c;
                }
            }
        }
        return new String(caracteres);
    }
}
