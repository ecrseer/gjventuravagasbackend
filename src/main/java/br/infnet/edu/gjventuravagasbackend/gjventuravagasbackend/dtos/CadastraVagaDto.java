package br.infnet.edu.gjventuravagasbackend.gjventuravagasbackend.dtos;

import br.infnet.edu.gjventuravagasbackend.gjventuravagasbackend.domain.Criterio;
import br.infnet.edu.gjventuravagasbackend.gjventuravagasbackend.domain.Empresa;
import br.infnet.edu.gjventuravagasbackend.gjventuravagasbackend.domain.RespostaVaga;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


public class CadastraVagaDto implements Serializable {
    private static final long serialVersionUID = 1L;

    long idVaga;
    String cargo;

/*

    @OneToMany(mappedBy = "vagaFk", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    List<Criterio> criterios;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empresaFk")
    @JsonBackReference
    Empresa empresaFk;

    @OneToMany(mappedBy = "vagaFk", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JsonManagedReference
    List<RespostaVaga> respostaVagas;

*/
}