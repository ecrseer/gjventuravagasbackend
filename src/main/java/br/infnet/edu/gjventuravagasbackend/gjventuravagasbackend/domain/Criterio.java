package br.infnet.edu.gjventuravagasbackend.gjventuravagasbackend.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "criterio")
public class Criterio implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long idCriterio;
    String descricao;
    int perfilMinimo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vagaFk")
    @JsonBackReference
    Vaga vagaFk;

    public Criterio(String descricao, int perfilMinimo) {
        this.descricao = descricao;
        this.perfilMinimo = perfilMinimo;
    }

    public Criterio() {

    }

    public String getDescricao() {
        return descricao;
    }

    public int getPerfilMinimo() {
        return perfilMinimo;
    }
}
