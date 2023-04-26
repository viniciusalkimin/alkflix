package br.com.vinicius.viniflix.endpoint;

import br.com.vinicius.viniflix.model.AuthenticationsData;
import br.com.vinicius.viniflix.model.TokenJWT;
import br.com.vinicius.viniflix.model.User;
import br.com.vinicius.viniflix.security.TokenService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/login")
@AllArgsConstructor
public class AuthenticationController {

    private AuthenticationManager manager;

    private TokenService tokenService;

    @PostMapping
    public ResponseEntity doLogin(@RequestBody @Valid AuthenticationsData data) {
        var authenticationToken= new UsernamePasswordAuthenticationToken(data.getLogin(), data.getPassword());
        var authentication = manager.authenticate(authenticationToken);

        var tokenJWT = tokenService.tokenGenerator((User) authentication.getPrincipal());
        return ResponseEntity.ok(new TokenJWT(tokenJWT));
    }

    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {

        return configuration.getAuthenticationManager();
    }
}
