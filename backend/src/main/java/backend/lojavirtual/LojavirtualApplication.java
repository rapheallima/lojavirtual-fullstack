package backend.lojavirtual;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import backend.lojavirtual.model.Produto;
import backend.lojavirtual.services.ProdutoService;

@SpringBootApplication
public class LojavirtualApplication implements CommandLineRunner {

	@Autowired
	private ProdutoService produtoService;

	public static void main(String[] args) {
		SpringApplication.run(LojavirtualApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Adicionando alguns produtos para testar

		Produto produto1 = new Produto();
		produto1.setNome("Produto 1");
		produto1.setDescricao("Descrição do Produto 1");
		produto1.setPreco(100.0);
		produtoService.salvarProduto(produto1);

		Produto produto2 = new Produto();
		produto2.setNome("Produto 2");
		produto2.setDescricao("Descrição do Produto 2");
		produto2.setPreco(150.0);
		produtoService.salvarProduto(produto2);

		Produto produto3 = new Produto();
		produto3.setNome("Produto 3");
		produto3.setDescricao("Descrição do Produto 3");
		produto3.setPreco(200.0);
		produtoService.salvarProduto(produto3);

		System.out.println("Produtos adicionados!");
	}

}
