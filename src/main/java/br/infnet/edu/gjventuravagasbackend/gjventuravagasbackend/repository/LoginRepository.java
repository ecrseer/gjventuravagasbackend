package br.infnet.edu.gjventuravagasbackend.gjventuravagasbackend.repository;

import br.infnet.edu.gjventuravagasbackend.gjventuravagasbackend.domain.Empresa;
import br.infnet.edu.gjventuravagasbackend.gjventuravagasbackend.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Empresa, Long> {
    Empresa findEmpresaByLogin(String login);
}
