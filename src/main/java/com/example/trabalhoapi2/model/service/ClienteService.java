package com.example.trabalhoapi2.model.service;

import com.example.trabalhoapi2.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.trabalhoapi2.model.entities.Cliente;
import java.util.List;


@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    public Cliente criarCliente(Cliente cliente) {
        if (cliente.getNome() == null || cliente.getNome().isBlank()) {
            throw new IllegalArgumentException("Nome é obrigatório.");
        }

        if (cliente.getCpf() == null || cliente.getCpf().isBlank()) {
            throw new IllegalArgumentException("CPF é obrigatório.");
        }

        return clienteRepository.save(cliente);
    }

    public List<Cliente> getClientes() {
        return clienteRepository.findAll();
    }

    public List<Cliente> consultarClientes(String nome) {
        List<Cliente> clientesEncontrados = clienteRepository.findByNome(nome);

        return clientesEncontrados;
    }

    public boolean deletarCliente(Long id) throws Exception {
        try {
            clienteRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new Exception("Ocorreu um erro " + e.getMessage());
        }
    }

    public Boolean editarCliente(Cliente cliente) throws Exception {
        try {
            clienteRepository.save(cliente);
            return true;
        } catch(Exception e) {
            throw new Exception("Ocorreu um erro " + e.getMessage());
        }
    }

}




