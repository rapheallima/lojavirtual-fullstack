package backend.lojavirtual.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import backend.lojavirtual.model.Usuario;
import backend.lojavirtual.repository.UsuarioRepository;

public class DataLoader implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public void run(String... args) throws Exception {

		// Verifica se já existe um usuário

		if (usuarioRepository.count() == 0) {
			Usuario admin = new Usuario();
			admin.setUsername("admin");
			admin.setPassword(passwordEncoder.encode("admin123"));
			admin.setRole("ROLE_ADMIN");

			usuarioRepository.save(admin);

			System.out.println("Usuário administrador criado: admin/admin123");
		}
	}

}
