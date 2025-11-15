package com.multipedidos.componentea.service;

import com.multipedidos.componentea.model.Pedido;
import com.multipedidos.componentea.repository.PedidoRepository;
import com.multipedidos.commons.OperacionesNegocio; // Asegúrate de que esta librería esté importada
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepo;

    public Pedido crearPedido(Pedido pedido) {
        // Si tienes productos en el pedido que son de tipo ProductoEmbeddable, conviértelos
        // y calcula el total con la librería commons
        double total = OperacionesNegocio.calcularTotal(pedido.getProductos()); // Aquí debes usar tu lógica de cálculo
        pedido.setTotal(total);
        return pedidoRepo.save(pedido);
    }

    public List<Pedido> listarPedidos() {
        return pedidoRepo.findAll();
    }

    public Pedido obtenerPedido(Long id) {
        return pedidoRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Pedido no encontrado"));
    }
}
