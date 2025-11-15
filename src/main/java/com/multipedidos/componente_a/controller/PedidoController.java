package com.multipedidos.componentea.controller;

import com.multipedidos.componentea.model.Pedido;
import com.multipedidos.componentea.service.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    // Crear pedido - Responde con 201 si se crea correctamente
    @Operation(summary = "Crear un nuevo pedido")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Pedido creado"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    @PostMapping
    public ResponseEntity<Pedido> crear(@RequestBody Pedido pedido) {
        Pedido p = pedidoService.crearPedido(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(p);
    }

    // Listar todos los pedidos
    @Operation(summary = "Listar todos los pedidos")
    @GetMapping
    public ResponseEntity<List<Pedido>> listar() {
        List<Pedido> pedidos = pedidoService.listarPedidos();
        return ResponseEntity.ok(pedidos);
    }

    // Obtener detalles de un pedido por ID
    @Operation(summary = "Obtener un pedido por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pedido encontrado"),
            @ApiResponse(responseCode = "404", description = "Pedido no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Pedido> obtener(@PathVariable Long id) {
        Pedido pedido = pedidoService.obtenerPedido(id);
        return ResponseEntity.ok(pedido);
    }
}
