package br.infnet.edu.gjventuravagasbackend.gjventuravagasbackend.controller;

import br.infnet.edu.gjventuravagasbackend.gjventuravagasbackend.domain.Vaga;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/vagas")
public class VagaController {
    List<Vaga> vagas;

    public VagaController() {
        this.vagas = new ArrayList<Vaga>();
    }

    private boolean isFieldsMissing(Vaga vaga) {
        if (vaga.getId() == 0 || vaga.getCargo() == null)
            return true;
        return false;
    }

    ResponseEntity fieldsMissingResponse = ResponseEntity
            .status(500).body("Não foi possivel inserir faltam info");

    @GetMapping
    public ResponseEntity getAllvagas() {
        return ResponseEntity.ok(vagas);
    }

    @PostMapping
    public ResponseEntity addVaga(@RequestBody Vaga vaga) {
        // long nsei = null;
        if (isFieldsMissing(vaga))
            return fieldsMissingResponse;

        if (vagas.add(vaga))
            return ResponseEntity.ok(vaga);

        return ResponseEntity.status(500).body("Não foi possivel inserir faltam info");

    }

    @PutMapping
    public ResponseEntity editVaga(@RequestBody Vaga vaga) {

        if (isFieldsMissing(vaga)) {
            return fieldsMissingResponse;
        }
        Vaga founded = vagas.stream()
                .filter(vagaInStream -> vagaInStream.getId() == vaga.getId())
                .toList().get(0);

        founded.setCargo(vaga.getCargo());
        founded.setId(vaga.getId());

        return ResponseEntity.ok(founded);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteVaga(@PathVariable long id) {
        if (id == 0)
            return fieldsMissingResponse;

        int index = 0;
        for (Vaga vaga : vagas) {
            if (vaga.getId() == id) {
                var removed = vagas.remove(index);
                return ResponseEntity.ok(removed);
            }
            index++;
        }

        return ResponseEntity.status(204).body("Não foi encontrado produto com este Id");

    }
}
