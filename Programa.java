package ejercicio3;

import java.util.ArrayList;

public class Programa {
    static ArrayList<Producto> lista= new ArrayList<>();
    public static void main(String[] args) {
        llenarLista();
        mostrarLista();
        totalizarLista();
    }

    public void llenarLista() {
        int codigo = (int) (Math.random() * 9000) + 1000;
        int cantidad = (int) (Math.random() * 9000) + 1000;
        long precio = (long) (Math.random() * 9000) + 1000;

        lista.add(new Producto(codigo, cantidad, precio));
        
        if (Math.random() < 0.5) {
            int nuevaCantidad = (int) (Math.random() * 100);
            lista.add(new Producto(codigo, nuevaCantidad, precio));
        }
    }

    public void mostrarLista() {
        System.out.println("Codigo \tCantidad \tPrecio");
        for (Producto producto : lista) {
            System.out.printf(producto.getCodigo(),"\t"producto.getCantidad(),"\t"producto.getPrecio());
        }
    }
    

}

/*
    public void mostrarLista() {
        System.out.println("Lista de Productos Vendidos (Entrada):");
        Producto actual = cabeza;
        while (actual != null) {
            System.out.printf("Codigo: %d, Cantidad: %d, Precio: %.2f%n",
                    actual.codigo, actual.cantidad, actual.precio);
            actual = actual.siguiente;
        }
    }

    public Programa totalizarLista() {
        Programa listaTotalizada = new Programa();
        while (cabeza != null) {
            Producto actual = cabeza;
            cabeza = cabeza.siguiente;

            Producto nodoTotalizado = listaTotalizada.buscarProducto(actual.codigo);
            if (nodoTotalizado == null) {
                listaTotalizada.agregarProductoTotalizado(actual.codigo, actual.cantidad, actual.precio);
            } else {
                nodoTotalizado.cantidad += actual.cantidad;
                nodoTotalizado.precio = ((nodoTotalizado.precio * (nodoTotalizado.cantidad - actual.cantidad)) + (actual.precio * actual.cantidad)) / nodoTotalizado.cantidad;
            }
        }
        return listaTotalizada;
    }

    private void agregarProductoTotalizado(int codigo, int cantidad, double precio) {
        Producto nuevo = new Producto(codigo, cantidad, precio);
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
    }


    private Producto buscarProducto(int codigo) {
        Producto actual = cabeza;
        while (actual != null) {
            if (actual.codigo == codigo) {
                return actual;
            }
            actual = actual.siguiente;
        }
        return null;
    }

    public void mostrarListaTotalizada() {
        System.out.println("\nLista de Productos Vendidos (Totalizada):");
        int totalCantidad = 0;
        double totalVentas = 0;

        Producto actual = cabeza;
        while (actual != null) {
            System.out.printf("Código: %d, Cantidad: %d, Precio Promedio: %.2f%n",
                    actual.codigo, actual.cantidad, actual.precio);
            totalCantidad += actual.cantidad;
            totalVentas += actual.cantidad * actual.precio;
            actual = actual.siguiente;
        }

        System.out.printf("\nTotal General de Productos Vendidos: %d%n", totalCantidad);
        System.out.printf("\nTotal General de Ventas: %.2f%n", totalVentas);
    }

    public static void ordenarCodigo() {
        for (int i = 0; i < .size() - 1; i++) {
            for (int j = 0; j < id.length - 1 - i; j++) {
                if (id[j] > id[j + 1]) {
                    int tempId = id[j];
                    id[j] = id[j + 1];
                    id[j + 1] = tempId;

                    String tempNombre = nombre[j];
                    nombre[j] = nombre[j + 1];
                    nombre[j + 1] = tempNombre;

                    for (int k = 0; k < 3; k++) {
                        double tempSueldo = sueldo[k][j];
                        sueldo[k][j] = sueldo[k][j + 1];
                        sueldo[k][j + 1] = tempSueldo;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Programa listaEntrada = new Programa();

        for (int i = 0; i < 10; i++) {
            listaEntrada.agregarProducto();
        }

        listaEntrada.mostrarListaEntrada();

        Programa listaTotalizada = listaEntrada.totalizarProductos();
        listaTotalizada.mostrarListaTotalizada();
    }
}

 */
