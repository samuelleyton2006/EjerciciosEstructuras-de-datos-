package ejercicio2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Ejercicio2 {
    public static int[] id = new int[5];
    public static String[] nombre = new String[5];
    public static long[][] sueldo= new long[3][5];

    public static void llenar() {
        for (int i = 0; i < id.length; i++) {
            id[i] = (int) (Math.random() * 9000) + 1000;
            nombre[i] = "Empleado" + (i + 1);

            sueldo[0][i] = (long) (Math.random() * 5000000) + 1000000;
            sueldo[1][i] = (long) (Math.random() * 500000);

            sueldo[2][i] = sueldo[0][i] - sueldo[1][i];
        }
    }

    public static void ordenarCodigo() {
        for (int i = 0; i < id.length - 1; i++) {
            for (int j = 0; j < id.length - 1 - i; j++) {
                if (id[j] > id[j + 1]) {
                    int tempId = id[j];
                    id[j] = id[j + 1];
                    id[j + 1] = tempId;

                    String tempNombre = nombre[j];
                    nombre[j] = nombre[j + 1];
                    nombre[j + 1] = tempNombre;

                    for (int k = 0; k < 3; k++) {
                        long tempSueldo = sueldo[k][j];
                        sueldo[k][j] = sueldo[k][j + 1];
                        sueldo[k][j + 1] = tempSueldo;
                    }
                }
            }
        }
    }

    public static void mostrar() {
        System.out.println("Id  \tNombre  \tSueldo Basico  \tDeducciones  \tNeto a Pagar");
        for (int i = 0; i < id.length; i++) {
            System.out.printf("%d\t%s\t$%d\t\t$%d\t\t\t$%d%n",
                    id[i], nombre[i], sueldo[0][i], sueldo[1][i], sueldo[2][i]);
        }
    }

    public static int buscarEmpleado(int idBuscado) {
        for (int i = 0; i < id.length; i++) {
            if (id[i] == idBuscado) {
                return i;
            }
        }
        return -1;
    }

    public static void ordenarNombre() {
        Integer[] indices = new Integer[id.length];
        for (int i = 0; i < indices.length; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, Comparator.comparing(i -> nombre[i]));

        int[] idTemp = new int[id.length];
        String[] nombreTemp = new String[id.length];
        long[][] sueldoTemp = new long[3][id.length];

        for (int i = 0; i < indices.length; i++) {
            idTemp[i] = id[indices[i]];
            nombreTemp[i] = nombre[indices[i]];
            sueldoTemp[0][i] = sueldo[0][indices[i]];
            sueldoTemp[1][i] = sueldo[1][indices[i]];
            sueldoTemp[2][i] = sueldo[2][indices[i]];
        }
        id = idTemp;
        nombre = nombreTemp;
        sueldo = sueldoTemp;
    }

    public static void main(String[] args) {
        llenar();
        ordenarCodigo();
        System.out.println("Lista de empleados ordenados por ID:");
        mostrar();
        System.out.println("\nLista de empleados ordenada por nombre:");
        ordenarNombre();
        mostrar();

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nDigite el ID del empleado: ");
        int idBuscado = scanner.nextInt();
        int resultado = buscarEmpleado(idBuscado);

        if (resultado != -1) {
            System.out.printf("Empleado:%nNombre: %s%nSueldo Basico: $%d%nDeducciones: $%d%nNeto a Pagar: $%d%n",
                    nombre[resultado], sueldo[0][resultado], sueldo[1][resultado], sueldo[2][resultado]);
        } else {
            System.out.println("El empleado " + idBuscado + " no se encontro");
        }
        scanner.close();
    }
}
