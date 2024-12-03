package backend.lojavirtual.util;

import java.security.Key;
import java.sql.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.InvalidKeyException;

@Component
public class JwtUtil {

	private final static Key SECRET_KEY = JwtKeyProvider.getSecretKey();

	// Usa a chave gerada com segurança

	public static String generateToken(String username) throws InvalidKeyException {
		return Jwts.builder().setSubject(username).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)).signWith(SECRET_KEY)
				.compact();
	}

	// Valida o token
	public boolean validateToken(String token, String username) {
		final String extractedUsername = extractUsername(token);
		return (extractedUsername.equals(username) && !isTokenExpired(token));
	}

	// Extrai o nome de usuário do token
	public String extractUsername(String token) {
		return extractClaims(token).getSubject();
	}

	// Verifica se o token expirou
	private boolean isTokenExpired(String token) {
		return extractClaims(token).getExpiration().before(new Date(0));
	}

	private Claims extractClaims(String token) {
		return Jwts.parserBuilder().setSigningKey(SECRET_KEY) // Usa a mesma chave segura criada anteriormente
				.build().parseClaimsJws(token).getBody();
	}

}