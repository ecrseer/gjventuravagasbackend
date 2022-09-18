package br.infnet.edu.gjventuravagasbackend.gjventuravagasbackend.controller;

import br.infnet.edu.gjventuravagasbackend.gjventuravagasbackend.domain.Empresa;
import br.infnet.edu.gjventuravagasbackend.gjventuravagasbackend.domain.Usuario;
import br.infnet.edu.gjventuravagasbackend.gjventuravagasbackend.domain.Vaga;
import br.infnet.edu.gjventuravagasbackend.gjventuravagasbackend.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/loginEmpresa")
public class LoginController {

    @Autowired
    LoginRepository repository;

    @GetMapping
    List<Empresa> list() {
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
        /*BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        usuario.setPassword(encoder.encode(usuario.getPassword()));*/
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

        return ResponseEntity.ok("TODO");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteVaga(@PathVariable long id) {

        return ResponseEntity.status(204).body("Não foi encontrado   com este Id");

    }
}
