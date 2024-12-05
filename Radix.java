import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class Radix {
    public static void main(String[] args) throws Exception {
        Random random =new Random();

        List<Integer> lista =new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            lista.add(random.nextInt(9999-1000+1));
        }
        System.out.println("Lista Original");
        System.out.println(lista.toString());
        ordenarList(lista);
    }

    public static List<Integer> ordenarList(List<Integer> lista){
        List<Queue<Integer>> contenedor =new ArrayList<>();
        //Creo 10 colas y las referencio a cada elemento de la lista de coloas contenedor
        for (int i = 0; i < 10; i++) {
            contenedor.add(new LinkedList<>());
        }
        //Busca el mayor dato en el arreglo
        int mayor = Collections.max(lista);
        System.out.println("El número mayor es: " + mayor);
        //
        int pasada = (int) Math.floor(Math.log10(Math.abs(mayor)) + 1);

        System.out.println("Numero Mayor "+mayor+" Número de Pasadas para Ordenar"+pasada);
        int numero;
        int digito;
        int j=1;
        for (int i = 0; i < pasada; i++) {

            while(!lista.isEmpty()) {
                numero = lista.remove(0);

                int n = numero/j;
                digito = n%10;
                contenedor.get(digito).add(numero);
            }
            j*=10;


            System.out.println(contenedor.toString());
            for (Queue cola: contenedor) {
                while(!cola.isEmpty())
                    lista.add((Integer)cola.poll());
            }
            System.out.println((i+1)+" Pasasa");
            System.out.println(lista.toString());
        }
        return lista;

    }

}
