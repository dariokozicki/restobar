package domain.dinner.food.ingredients;

import db.EntidadPersistente;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="INGREDIENTES")
public class Ingrediente extends EntidadPersistente {
    @Column(name="NOMBRE")
    private String nombre;
    @Column(name="COSTO")
    private Double costo;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Propiedad> propiedades;
    @Column(name="path")
    private String path;

    public Ingrediente(String nombre, Double costo, List<Propiedad> propiedades, String path) {
        this.nombre = nombre;
        this.costo = costo;
        this.propiedades = propiedades;
        this.path = path;
    }
    public Ingrediente(){}
    public double getCosto(){
        return costo;
    }

    public void setCosto(Double costo){
        this.costo = costo;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Propiedad> getPropiedades() {
        return propiedades;
    }

    public void setPropiedades(List<Propiedad> propiedades) {
        this.propiedades = propiedades;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
