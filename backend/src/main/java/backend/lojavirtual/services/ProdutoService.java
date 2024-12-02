package backend.lojavirtual.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import backend.lojavirtual.model.Produto;
import backend.lojavirtual.repository.ProdutoRepository;
import jakarta.persistence.Entity;

@Entity
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public List<Produto> listarTodosProdutos() {
		return produtoRepository.findAll();
	}

	public Produto obterProdutoPorId(Long id) {
		return produtoRepository.findById(id).orElse(null);
	}

	public Produto salvarProduto(Produto produto) {
		return produtoRepository.save(produto);
	}

	public void excluirProduto(Long id) {
		produtoRepository.deleteById(id);
	}

}
