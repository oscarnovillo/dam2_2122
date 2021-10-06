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

    }

    public void clienteQueMasDineroSehaGastado() {

    }

    // La cantidad media de producto por pedido simple, sumando todas las lineas de pedido de cada simple
    public void lacantidadMediaPedidaDeCadaProductoEnCadaPedidoCompuesto() {

    }


    public void pedidoSimpleConMasLineasdePedido() {

    }


    public void todoelDineroFacturadoEnTotalentodosLosPedidos() {

    }

    public void setFacturaTotal() {

    }
}
