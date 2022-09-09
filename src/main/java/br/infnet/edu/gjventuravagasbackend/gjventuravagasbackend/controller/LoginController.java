package br.infnet.edu.gjventuravagasbackend.gjventuravagasbackend.controller;

import br.infnet.edu.gjventuravagasbackend.gjventuravagasbackend.domain.Empresa;
import br.infnet.edu.gjventuravagasbackend.gjventuravagasbackend.domain.Usuario;
import br.infnet.edu.gjventuravagasbackend.gjventuravagasbackend.domain.Vaga;
import br.infnet.edu.gjventuravagasbackend.gjventuravagasbackend.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginRepository repository;

    @GetMapping
    Iterable<Empresa> list() {
        return repository.findAll();
    }

    List<Usuario> usuarios;

    public LoginController() {
        this.usuarios = new ArrayList<Usuario>();
    }

    private boolean isFieldsMissing(Usuario usuario) {
        if (usuario.getIdUsuario() == 0)
            return true;
        return false;
    }

    @PostMapping("/cadastrar")
    public Empresa cadastrarEmpresa(@RequestBody Empresa usuario) {

        if (isFieldsMissing(usuario)) {
            var add = usuarios.size() + 1;
            usuario.setIdUsuario(add);
        }
        var usr = repository.save(usuario);
        return usr;

    }

    @PostMapping("/logar")
    public ResponseEntity<Empresa> logarUsuario(@RequestBody Usuario usuario) {

        System.out.println("ususssssssss " + usuario);
        var foundUser = repository.findEmpresaByLogin(usuario.getLogin());
        System.out.println("find foundUser " + foundUser);
        if (foundUser != null) {
            boolean isPasswordCorrect = foundUser.getPassword().equals(usuario.getPassword());
            if (isPasswordCorrect) {
                return ResponseEntity.ok(foundUser);
            }
        }

        return ResponseEntity.notFound().build();

    }

    @PutMapping
    public ResponseEntity editVaga(@RequestBody Vaga vaga) {
        /*
         * if (isFieldsMissing(vaga)) {
         * return fieldsMissingResponse;
         * }
         * Vaga founded = vagas.stream()
         * .filter(vagaInStream -> vagaInStream.getId() == vaga.getId())
         * .toList().get(0);
         *
         * founded.setCargo(vaga.getCargo());
         * founded.setId(vaga.getId());
         */
        return ResponseEntity.ok("founded");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteVaga(@PathVariable long id) {
        /*
         * if (id == 0)
         * return fieldsMissingResponse;
         *
         * int index = 0;
         * for (Vaga vaga : vagas) {
         * if (vaga.getId() == id) {
         * var removed = vagas.remove(index);
         * return ResponseEntity.ok(removed);
         * }
         * index++;
         * }
         */

        return ResponseEntity.status(204).body("Não foi encontrado produto com este Id");

    }
}
