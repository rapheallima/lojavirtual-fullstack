package backend.lojavirtual.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import backend.lojavirtual.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
