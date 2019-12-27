package model.dinner.food.ingredients;


import db.EntidadPersistente;

import javax.persistence.*;

@Entity
@Table(name = "COMPONENTES")
public class Componente extends EntidadPersistente {
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "ingrediente_id")
    private Ingrediente ingrediente;
    @Column(name="POSICION")
    private Integer posicion;

    public Componente(Ingrediente ingrediente, int posicion) {
        this.ingrediente = ingrediente;
        this.posicion = posicion;
    }
    public Componente(){}

    public Double costo(){
        return ingrediente.getCosto();
    }

    public Ingrediente getIngrediente(){
        return ingrediente;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

}
