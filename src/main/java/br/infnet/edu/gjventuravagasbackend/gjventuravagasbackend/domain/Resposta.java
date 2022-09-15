package br.infnet.edu.gjventuravagasbackend.gjventuravagasbackend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Resposta {
    /*    @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int idResposta;

    private RespostaVaga resposta;*/
    private int conhecimento;
}
