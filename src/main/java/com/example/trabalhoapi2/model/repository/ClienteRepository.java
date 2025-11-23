package com.example.trabalhoapi2.model.repository;

import com.example.trabalhoapi2.model.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>
 {
    List<Cliente> findByNome(String nome);
}
