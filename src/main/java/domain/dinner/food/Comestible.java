package domain.dinner.food;

import db.EntidadPersistente;
import domain.dinner.food.ingredients.Componente;
import domain.dinner.food.ingredients.Ingrediente;

import javax.persistence.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Comestible <T extends Ingrediente> extends EntidadPersistente {

    @Column(name="NOMBRE")
    protected String nombre;

    @ManyToMany(fetch = FetchType.EAGER)
    protected List<Componente<T>> componentes;

    public Comestible(String nombre, List<Componente<T>> componentes){
        this.nombre = nombre;
        this.componentes = componentes;
    }
    public Comestible(){}

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

    public List<Componente<T>> getComponentes() {
        return componentes;
    }

    public void sortComponentes(){
        componentes.sort((a,b)->b.getPosicion() - (a.getPosicion()));
    }

    public void setComponentes(List<Componente<T>> componentes) {
        this.componentes = componentes;
    }
}
