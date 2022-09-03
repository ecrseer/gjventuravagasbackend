package br.infnet.edu.gjventuravagasbackend.gjventuravagasbackend.domain;


import javax.persistence.*;

@Entity(name = "criterio")
public class Criterio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long idCriterio;
    String descricao;
    int perfilMinimo;

    @ManyToOne
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
