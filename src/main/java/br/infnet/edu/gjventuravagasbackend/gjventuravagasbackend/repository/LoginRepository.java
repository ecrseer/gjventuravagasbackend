package br.infnet.edu.gjventuravagasbackend.gjventuravagasbackend.repository;

import br.infnet.edu.gjventuravagasbackend.gjventuravagasbackend.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Usuario, Long> {
    Usuario findUsuarioByLogin(String login);
}
