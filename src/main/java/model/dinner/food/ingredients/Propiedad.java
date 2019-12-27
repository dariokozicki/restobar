package model.dinner.food.ingredients;

import db.EntidadPersistente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Properties;

@Entity
@Table(name="PROPIEDADES")
public class Propiedad extends EntidadPersistente {
    @Column(name="NOMBRE")
    private String nombre;

    public Propiedad(){}
    public Propiedad(String nombre) {
        this.nombre = nombre;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
