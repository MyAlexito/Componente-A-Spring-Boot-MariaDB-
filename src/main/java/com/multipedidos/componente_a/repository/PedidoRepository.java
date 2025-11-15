package com.multipedidos.componentea.repository;

import com.multipedidos.componentea.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
