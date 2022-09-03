package br.infnet.edu.gjventuravagasbackend.gjventuravagasbackend.domain;

import javax.persistence.*;
import java.util.List;
    
@Entity(name = "vaga")
public class Vaga {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long idVaga;
    String cargo;

    @OneToMany(mappedBy = "vagaFk")
    List<Criterio> criterios;

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
