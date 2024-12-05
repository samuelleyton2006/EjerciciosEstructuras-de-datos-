public class Ejercicio2 {
    public static void main(String[] args) {
        int[] numeros={35,7,67,52,31,28};
        seleccion(numeros);
        int[] numeros1={35,7,67,52,31,28};
        System.out.println("Insercion");
        insertionSort(numeros1);
    }
    public static void seleccion(int[] arr){
        int n = arr.length;
        int esfuerzo=0;

        for (int i = 0; i < n; i++) {

            int indiceMinimo = i;


            for (int j = i + 1; j < n; j++) {
                esfuerzo++;
                if (arr[j] < arr[indiceMinimo]) {
                    indiceMinimo = j;
                }
            }


            esfuerzo+=2;
            int tempC = arr[i];
            arr[i] = arr[indiceMinimo];
            arr[indiceMinimo] = tempC;


            System.out.println("Secuencia "+ i );
            for(int k=0;k<n;k++) {

                System.out.print(arr[k]+ " ");
            }
            System.out.println();

        }
        System.out.println("Esfuerzo total "+ esfuerzo);

    }
    public static void insertionSort(int[] array) {
        int esfuerzo=0;
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            System.out.println("Paso " + i + ": ");
            for (int k = 0; k < array.length; k++) {

                System.out.print(array[k] + " ");
            }
            System.out.println();

            while (j >= 0) {
                esfuerzo++;
                if (array[j] > key) {
                    array[j + 1] = array[j];
                    esfuerzo += 2;
                } else {
                    break;
                }
                j--;
            }
                array[j + 1] = key;

               System.out.println("Después de insertar " + key + ": ");
               for (int k = 0; k < array.length; k++) {

                    System.out.print(array[k] + " ");
                }
                System.out.println();

            }
                System.out.println("Esfuerzo total "+ esfuerzo);
    }
}

