package backend.lojavirtual.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import backend.lojavirtual.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
