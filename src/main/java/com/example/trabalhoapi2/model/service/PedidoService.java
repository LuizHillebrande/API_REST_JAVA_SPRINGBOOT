package com.example.trabalhoapi2.model.service;

import com.example.trabalhoapi2.model.entities.Pedido;
import com.example.trabalhoapi2.model.repository.ClienteRepository;
import com.example.trabalhoapi2.model.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;

    public PedidoService(PedidoRepository pedidoRepository, ClienteRepository clienteRepository) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
    }

    public Pedido novoPedido(Pedido pedido) {
        if (!clienteRepository.existsById(pedido.getCliente().getId())) {
            throw new RuntimeException("Cliente não encontrado");
        }
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    public List<Pedido> listarPorCliente(Long clienteId) {
        return pedidoRepository.findByClienteId(clienteId);
    }

    public boolean atualizarPedido(Pedido pedido) {
        if (!pedidoRepository.existsById(pedido.getId())) {
            throw new RuntimeException("Pedido não encontrado");
        }
        pedidoRepository.save(pedido);
        return true;
    }

    public boolean deletarPedido(Long id) {
        if (!pedidoRepository.existsById(id)) {
            throw new RuntimeException("Pedido não encontrado");
        }
        pedidoRepository.deleteById(id);
        return true;
    }
}
