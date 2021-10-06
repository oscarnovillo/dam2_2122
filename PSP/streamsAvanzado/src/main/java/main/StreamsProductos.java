package main;

import pedidos.dao.modelo.Producto;
import pedidos.servicios.ServiciosPedido;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamsProductos {
    ServiciosPedido sp = new ServiciosPedido();
    List<Producto> productos = sp.todosProductos();

    // con reduce y con sorted
    public void productoMasCaro() {
        System.out.println(productos.stream()
                .reduce((producto1, producto2) ->
                        producto1.getPrecio() >= producto2.getPrecio() ? producto1 : producto2).get());

        System.out.println(productos.stream().sorted(
                Comparator.comparing(producto -> ((Producto) producto).getPrecio()).reversed()).findFirst().get());
    }

    //con reduce y con sorted
    public void productoMasBarato() {
        System.out.println(productos.stream()
                .reduce((producto1, producto2) ->
                        producto1.getPrecio() <= producto2.getPrecio() ? producto1 : producto2).get());

        System.out.println(productos.stream().sorted(
                Comparator.comparing(producto -> producto.getPrecio())).findFirst().get());
    }


    public void mediaPrecioTodosLosProductos() {
        System.out.println(productos.stream().mapToInt(value -> value.getPrecio()).average().getAsDouble());
    }


    // un grupo de producto por cada franja de 10, de 0 a 10, 11 a 20, etc...
    public void productosAgrupadosPorRangoPrecio10en10() {
        Map<String, List<Producto>> mapRangos = productos.stream().sorted(Comparator.comparing(Producto::getPrecio))
                .collect(Collectors.groupingBy(producto -> {
                    String rango;
                    int division = producto.getPrecio() / 10;
                    if (division == 0) {
                        return rango = division + "-" + (division + 10);
                    } else if (producto.getPrecio() % 10 == 0) {
                        return rango = (((division - 1) * 10) + 1) + "-" + (((division - 1) * 10) + 10);
                    }
                    return rango = (division * 10 + 1) + "-" + (division * 10 + 10);
                }));
        mapRangos.keySet().stream().sorted().forEach(fila -> System.out.println(fila + " " + mapRangos.get(fila).toString()));
    }

    // de los productos que tenga precio de 11 a 20, indicar cuales tienen stock mayor que 5
    public void productosConPrecio11a20YStockMayor5() {
        productos.stream()
                .filter(producto -> producto.getPrecio() >= 11 && producto.getPrecio() <= 20 && producto.getStock() > 5)
                .forEach(System.out::println);
    }
}
