package ejercicio1;

import java.util.Scanner;

public class Ejercicio1 {

    public static int[] codigo = new int[5];
    public static String[] nombre = new String[5];
    public static double[][] notas = new double[3][5];
    public static double[] definitiva = new double[5];

    public static void llenar() {
        for (int i = 0; i < codigo.length; i++) {
            codigo[i] = (int) (Math.random() * 9000) + 1000;
            nombre[i] = "Estudiante" + (i + 1);

            for (int k = 0; k < 3; k++) {
                notas[k][i] = Math.random() * 5;
            }

            definitiva[i] = (notas[0][i] * 0.3) + (notas[1][i] * 0.3) + (notas[2][i] * 0.3);
        }
    }

    public static void ordenarCodigo() {
        for (int i = 0; i < codigo.length - 1; i++) {
            for (int j = 0; j < codigo.length - 1 - i; j++) {
                if (codigo[j] > codigo[j + 1]) {
                    int tempCodigo = codigo[j];
                    codigo[j] = codigo[j + 1];
                    codigo[j + 1] = tempCodigo;

                    String tempNombre = nombre[j];
                    nombre[j] = nombre[j + 1];
                    nombre[j + 1] = tempNombre;

                    for (int k = 0; k < 3; k++) {
                        double tempNota = notas[k][j];
                        notas[k][j] = notas[k][j + 1];
                        notas[k][j + 1] = tempNota;
                    }

                    double tempDefinitiva = definitiva[j];
                    definitiva[j] = definitiva[j + 1];
                    definitiva[j + 1] = tempDefinitiva;
                }
            }
        }
    }

    public static void ordenarNota() {
        for (int i = 0; i < definitiva.length - 1; i++) {
            for (int j = 0; j < definitiva.length - 1 - i; j++) {
                if (definitiva[j] < definitiva[j + 1]) {  // Orden descendente por nota definitiva
                    // Intercambiar definitiva
                    double tempDefinitiva = definitiva[j];
                    definitiva[j] = definitiva[j + 1];
                    definitiva[j + 1] = tempDefinitiva;

                    int tempCodigo = codigo[j];
                    codigo[j] = codigo[j + 1];
                    codigo[j + 1] = tempCodigo;

                    String tempNombre = nombre[j];
                    nombre[j] = nombre[j + 1];
                    nombre[j + 1] = tempNombre;

                    for (int k = 0; k < 3; k++) {
                        double tempNota = notas[k][j];
                        notas[k][j] = notas[k][j + 1];
                        notas[k][j + 1] = tempNota;
                    }
                }
            }
        }
    }

    public static void mostrar() {
        System.out.println("Codigo  Nombre  \t\tNota 1  Nota 2  Nota 3  Nota Definitiva");
        for (int i = 0; i < codigo.length; i++) {
            System.out.print(codigo[i] + "\t");
            System.out.print(nombre[i] + "\t\t");

            for (int k = 0; k < 3; k++) {
                System.out.print(String.format("%.2f", notas[k][i]) + "\t");
            }
            System.out.println(String.format("%.2f", definitiva[i]));
        }
    }

    public static int busquedaBinaria(int codigoBuscado) {
        int inicio = 0;
        int fin = codigo.length - 1;
        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;
            if (codigo[medio] == codigoBuscado) {
                return medio;
            } else if (codigo[medio] < codigoBuscado) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        llenar();
        System.out.println("Lista ordenada por Codigo:");
        ordenarCodigo();
        mostrar();
        System.out.println("\nLista ordenada por Nota definitiva:");
        ordenarNota();
        mostrar();

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nDigite el codigo del estudiante: ");
        int codigoBuscado = scanner.nextInt();

        int resultado = busquedaBinaria(codigoBuscado);
        if (resultado != -1) {
            System.out.println("Codigo: " + codigo[resultado]);
            System.out.println("Nombre: " + nombre[resultado]);
            System.out.println(String.format("Nota 1: " + "%.2f" , notas[0][resultado]));
            System.out.println(String.format("Nota 2: " + "%.2f" , notas[1][resultado]));
            System.out.println(String.format("Nota 3: " + "%.2f" , notas[2][resultado]));
            System.out.println(String.format("Nota Definitiva: " + "%.2f" , definitiva[resultado]));
        } else {
            System.out.println("El estudiante: " + codigoBuscado + " no se encontro");
        }

        scanner.close();
    }
}
