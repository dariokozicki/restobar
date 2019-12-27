package model;

import db.EntidadPersistente;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="JUNTADAS")
public class Juntada extends EntidadPersistente {
    @ManyToMany
    private List<Cena> cenas;
    @Column(name="NOMBRE")
    private String nombre;

    public Juntada(List<Cena> cenas, String nombre) {
        this.cenas = cenas;
        this.nombre = nombre;
    }

    public Juntada(){}

    public double laCuenta(){
        return cenas.stream().mapToDouble(c->c.precio()).sum() + propina();
    }

    public boolean estaBuena(){
        return cenas.stream().allMatch(c->c.estaBuena());
    }


    public Double propina(){
        return estaBuena() ? 100.0 : 0.0;
    }

    public List<Cena> getCenas() {
        return cenas;
    }

    public void setCenas(List<Cena> cenas) {
        this.cenas = cenas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
