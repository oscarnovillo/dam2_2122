package main;


import pedidos.dao.modelo.LineaPedido;
import pedidos.dao.modelo.PedidoCompuesto;
import pedidos.dao.modelo.PedidoSimple;
import pedidos.servicios.ServiciosPedido;

import java.util.List;
import java.util.stream.Collectors;


public class StreamsPedidos {
    ServiciosPedido sp = new ServiciosPedido();
    List<PedidoCompuesto> pedidos = sp.getTodosPedidos();

    // un map con nombre de producto y cantidad de veces pedido
    public void productosAgrupadosPorCantidadDeVecesPedidos() {
        System.out.println(pedidos.stream().flatMap(pedidoCompuesto -> pedidoCompuesto.getPedidosSimples().stream())
                .flatMap(pedidoSimple -> pedidoSimple.getLineasPedido().stream())
                .map(LineaPedido::getProducto)
                .collect(Collectors.groupingBy(
                        producto -> pedidos.stream().flatMap(pedidoCompuesto -> pedidoCompuesto.getPedidosSimples().stream())
                        .flatMap(pedidoSimple -> pedidoSimple.getLineasPedido().stream())
                        .filter(lineaPedido -> lineaPedido.getProducto().equals(producto)).count())));
    }

    public void clienteQueMasDineroSehaGastado() {
        setFacturaTotal();
        System.out.println(pedidos.stream().reduce((pedidoCompuesto, pedidoCompuesto2) ->
                pedidoCompuesto.getTotalFactura() >= pedidoCompuesto2.getTotalFactura()
                        ? pedidoCompuesto : pedidoCompuesto2).get().getCliente().getNombre());
    }

    // La cantidad media de producto por pedido simple, sumando todas las lineas de pedido de cada simple
    public void lacantidadMediaPedidaDeCadaProductoEnCadaPedidoCompuesto() {
        pedidos.stream().forEach(pedidoCompuesto ->
        {
            System.out.println(pedidoCompuesto + ":" + pedidoCompuesto.getPedidosSimples().stream()
                    .flatMap(pedidoSimple -> pedidoSimple.getLineasPedido().stream())
                    .mapToDouble(LineaPedido::getCantidad).average().orElse(0));
        });
    }


    public void pedidoSimpleConMasLineasdePedido() {
        System.out.println(pedidos.stream().flatMap(pedidoCompuesto -> pedidoCompuesto.getPedidosSimples().stream())
                .reduce(((pedidoSimple, pedidoSimple2) ->
                        pedidoSimple.getLineasPedido().size() >= pedidoSimple2.getLineasPedido().size() ?
                                pedidoSimple : pedidoSimple2)));
    }


    public void todoelDineroFacturadoEnTotalentodosLosPedidos() {
        System.out.println(pedidos.stream().flatMap(pedidoCompuesto -> pedidoCompuesto.getPedidosSimples().stream())
                .flatMap(pedidoSimple -> pedidoSimple.getLineasPedido().stream())
                .mapToDouble(LineaPedido::getPrecioTotal).sum());
    }

    public void setFacturaTotal() {
        pedidos.stream().forEach(pedidoCompuesto -> pedidoCompuesto.getPedidosSimples().stream()
                .forEach(pedidoSimple -> pedidoSimple.setTotal(pedidoSimple.getLineasPedido().stream()
                        .mapToInt(LineaPedido::getPrecioTotal).sum())));
        pedidos.stream().forEach(pedidoCompuesto -> pedidoCompuesto.setTotalFactura(pedidoCompuesto.getPedidosSimples().stream()
                .mapToInt(PedidoSimple::getTotal).sum()));
    }
}
