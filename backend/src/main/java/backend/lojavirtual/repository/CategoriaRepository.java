package backend.lojavirtual.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import backend.lojavirtual.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}