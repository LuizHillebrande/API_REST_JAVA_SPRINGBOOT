package com.example.trabalhoapi2.controller;

import com.example.trabalhoapi2.model.entities.Pedido;
import com.example.trabalhoapi2.model.service.ClienteService;
import com.example.trabalhoapi2.model.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    PedidoService pedidoService;

    @Autowired
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping("/novo")
    public ResponseEntity<?> novoPedido(@RequestBody Pedido pedido) {
        try {
            pedidoService.novoPedido(pedido);
            return ResponseEntity.status(201).body(true);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> listarPedidos() {
        return ResponseEntity.ok(pedidoService.listarPedidos());
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<List<Pedido>> listarPorCliente(@PathVariable Long id) {
        return ResponseEntity.ok(pedidoService.listarPorCliente(id));
    }

}
