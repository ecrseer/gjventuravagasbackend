package br.infnet.edu.gjventuravagasbackend.gjventuravagasbackend.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Resposta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long idResposta;

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "criterioFK")
    @JsonBackReference(value = "criterioFK")
    Criterio criterio;*/

    long criterioFk;

    private int conhecimento;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "respostaCriterioFk")
    @JsonBackReference(value = "respostaCriterioFk")
    RespostaVaga respostaCriterioFk;
}
