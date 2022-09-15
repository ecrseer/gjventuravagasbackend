package br.infnet.edu.gjventuravagasbackend.gjventuravagasbackend.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RespostaVaga {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idRespostaVaga;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vagaFk")
    @JsonBackReference(value="respostaVagas")
    private Vaga vagaFk;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "candidatoFk")
    @JsonBackReference
    private Candidato candidatoFk;

    private String respostas;

}
