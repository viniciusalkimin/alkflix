package br.com.vinicius.viniflix.service;

import br.com.vinicius.viniflix.model.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class TokenService {

    public String tokenGenerator(User user) {
        try {
            var algorithm = Algorithm.HMAC256("myPassSuperSecret");
            return JWT.create()
                    .withIssuer("API alkFlix")
                    .withSubject(user.getLogin())
                    .withClaim("id", user.getId())
                    .withExpiresAt(expirationDate())
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
           throw new RuntimeException("Error on Token creation!", exception);
        }

    }

    private Instant expirationDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
