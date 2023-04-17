package br.com.vinicius.viniflix.repository;

import br.com.vinicius.viniflix.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {
    UserDetails findByLogin(String login);
}
