package domain.dinner.food.ingredients;


import db.EntidadPersistente;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "COMPONENTES")
public class Componente <T extends Ingrediente> extends EntidadPersistente {

    @Any(metaColumn = @Column(name = "what_i_contain"))
    @Cascade({org.hibernate.annotations.CascadeType.ALL})
    @AnyMetaDef(
            idType = "integer",
            metaType = "string",
            metaValues = {
                    @MetaValue(value = "Solido", targetEntity = Solido.class),
                    @MetaValue(value = "Liquido", targetEntity = Liquido.class)
            })
    @JoinColumn(name = "property_id")
    private T ingrediente;

    @Column(name="POSICION")
    private Integer posicion;

    public Componente(T ingrediente, int posicion) {
        this.ingrediente = ingrediente;
        this.posicion = posicion;
    }

    public Componente(){}

    public Double costo(){
        return ingrediente.getCosto();
    }

    public T getIngrediente(){
        return ingrediente;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public void setIngrediente(T ingrediente) {
        this.ingrediente = ingrediente;
    }
}
