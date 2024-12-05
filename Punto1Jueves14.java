public class EjercicioSeleccion {
    public static void main(String[] args) {
        int[] numeros={35,7,67,52,31,28,6,50,25,55};
        ordenaSeleccion(numeros);
    }

    public static void ordenaSeleccion(int[] numeros){
        int n = numeros.length;

        // Recorremos la numeros
        for (int i = 0; i < n; i++) {
            // Suponemos que el mínimo es el primer elemento sin ordenar
            int indiceMinimo = i;

            // Recorremos el resto de la numeros para encontrar el mínimo
            for (int j = i + 1; j < n; j++) {
                if (numeros[j] < numeros[indiceMinimo]) {  // Cambié el signo para ordenar de menor a mayor
                    indiceMinimo = j;
                }
            }

            // Intercambiamos el elemento mínimo encontrado con el primero
            int tempC = numeros[i];
            numeros[i] = numeros[indiceMinimo];
            numeros[indiceMinimo] = tempC;

            System.out.println("Secuencia "+ i );
            for(int k=0;k<n;k++) {

                System.out.print(numeros[k]+ " ");
            }
            System.out.println();

        }


    }

}
