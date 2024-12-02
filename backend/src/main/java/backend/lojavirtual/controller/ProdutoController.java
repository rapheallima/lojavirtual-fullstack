package backend.lojavirtual.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import backend.lojavirtual.model.Produto;
import backend.lojavirtual.services.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@GetMapping
	public List<Produto> listarProdutos() {
		return produtoService.listarTodosProdutos();
	}

	@GetMapping("/{id}")
	public Produto obterProduto(@PathVariable Long id) {
		return produtoService.obterProdutoPorId(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Produto adicionarProduto(@RequestBody Produto produto) {
		return produtoService.salvarProduto(produto);
	}

	@PutMapping("/{id}")
	public Produto atualizarProduto(@PathVariable Long id, @RequestBody Produto produto) {
		produto.setId(id);
		return produtoService.salvarProduto(produto);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluirProduto(@PathVariable Long id) {
		produtoService.excluirProduto(id);
	}

}
