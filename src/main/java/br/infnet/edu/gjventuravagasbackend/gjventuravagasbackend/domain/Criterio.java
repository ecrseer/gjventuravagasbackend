package br.infnet.edu.gjventuravagasbackend.gjventuravagasbackend.domain;

public class Criterio {
    String descricao;
    int perfilMinimo;

    public Criterio(String descricao, int perfilMinimo) {
        this.descricao = descricao;
        this.perfilMinimo = perfilMinimo;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getPerfilMinimo() {
        return perfilMinimo;
    }
}
