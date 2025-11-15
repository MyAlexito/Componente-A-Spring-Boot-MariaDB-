package com.multipedidos.componentea.repository;

import com.multipedidos.componentea.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
