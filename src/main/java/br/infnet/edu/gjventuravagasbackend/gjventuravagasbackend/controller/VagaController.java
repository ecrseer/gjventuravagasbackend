package br.infnet.edu.gjventuravagasbackend.gjventuravagasbackend.controller;

import br.infnet.edu.gjventuravagasbackend.gjventuravagasbackend.domain.Vaga;
import br.infnet.edu.gjventuravagasbackend.gjventuravagasbackend.repository.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/vagasEmpresa")
public class VagaController {
    List<Vaga> vagas;

    @Autowired
    VagaRepository vagaRepository;



    private boolean isFieldsMissing(Vaga vaga) {
        if (vaga.getIdVaga() == 0 || vaga.getCargo() == null)
            return true;
        return false;
    }

    ResponseEntity fieldsMissingResponse = ResponseEntity
            .status(500).body("Não foi possivel inserir faltam info");

    @GetMapping
    public ResponseEntity<List<Vaga>> getAllvagas() {
        return ResponseEntity.ok(vagaRepository.findAll());
    }

    @PostMapping
    public ResponseEntity addVaga(@RequestBody Vaga vaga) {

        Vaga saved = vagaRepository.save(vaga);
        if (saved != null) {
            return ResponseEntity.status(201).body(saved);
        }
        return ResponseEntity.status(500).body("Não foi possivel inserir faltam info");

    }

    @PutMapping
    public ResponseEntity editVaga(@RequestBody Vaga vaga) {

        if (isFieldsMissing(vaga)) {
            return fieldsMissingResponse;
        }
        Vaga founded = vagas.stream()
                .filter(vagaInStream -> vagaInStream.getIdVaga() == vaga.getIdVaga())
                .toList().get(0);

        founded.setCargo(vaga.getCargo());
        founded.setIdVaga(vaga.getIdVaga());

        return ResponseEntity.ok(founded);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteVaga(@PathVariable long id) {
        if (id == 0)
            return fieldsMissingResponse;

        int index = 0;
        for (Vaga vaga : vagas) {
            if (vaga.getIdVaga() == id) {
                var removed = vagas.remove(index);
                return ResponseEntity.ok(removed);
            }
            index++;
        }

        return ResponseEntity.status(204).body("Não foi encontrado produto com este Id");

    }
}
