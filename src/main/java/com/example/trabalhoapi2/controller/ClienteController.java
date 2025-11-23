package com.example.trabalhoapi2.controller;

import com.example.trabalhoapi2.model.entities.Cliente;
import com.example.trabalhoapi2.model.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService; // única instância do service

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping("/criar")
    public ResponseEntity<?> novoCliente(@RequestBody Cliente cliente) {
        try {
            clienteService.criarCliente(cliente);
            return ResponseEntity.status(201).body(true);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> getCliente() {
        List<Cliente> clientes = clienteService.getClientes();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/consulta")
    public ResponseEntity<List<Cliente>> consultarCliente(@RequestParam("nome") String nome) {
        List<Cliente> clientesEncontrados = clienteService.consultarClientes(nome);
        return ResponseEntity.ok(clientesEncontrados);
    }

    @PutMapping("/editar")
    public ResponseEntity<?> editarCliente(@RequestBody Cliente cliente) {
        try {
            boolean atualizou = clienteService.editarCliente(cliente);
            return ResponseEntity.ok(atualizou);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarCliente(@PathVariable("id") Long id) {
        try {
            boolean deletou = clienteService.deletarCliente(id);
            return ResponseEntity.ok(deletou);
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}