package model.dinner.food;

import db.EntidadPersistente;
import model.dinner.food.ingredients.Componente;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PARTES")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Parte extends EntidadPersistente {
    @Column(name="NOMBRE")
    protected String nombre;
    @ManyToMany(fetch = FetchType.EAGER)
    protected List<Componente> componentes;

    public Parte(String nombre, List<Componente> componentes){
        this.nombre = nombre;
        this.componentes = componentes;
    }
    public Parte(){}
    public double precio(){
        return costo()*1.25;
    }

    public double costo(){
        return componentes.stream().mapToDouble(c->c.costo()).sum();
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Componente> getComponentes() {
        return componentes;
    }

    public void setComponentes(List<Componente> componentes) {
        this.componentes = componentes;
    }
}
