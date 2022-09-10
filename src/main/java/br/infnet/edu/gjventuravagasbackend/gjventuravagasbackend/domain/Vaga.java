package br.infnet.edu.gjventuravagasbackend.gjventuravagasbackend.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "vaga")
public class Vaga implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long idVaga;
    String cargo;


    @OneToMany(mappedBy = "vagaFk", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    List<Criterio> criterios;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empresaFk")
    @JsonBackReference
    Empresa empresaFk;

    public Vaga(long idVaga, String cargo) {
        this.idVaga = idVaga;
        this.cargo = cargo;
    }

    public Vaga() {
    }

    public long getId() {
        return idVaga;
    }

    public String getCargo() {
        return cargo;
    }

    public List<Criterio> getCriterios() {
        return criterios;
    }

    public void setId(long id) {
        this.idVaga = id;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setCriterios(List<Criterio> criterios) {
        this.criterios = criterios;
    }
}
