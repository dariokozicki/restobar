package model.dinner;

import db.EntidadPersistente;
import model.dinner.food.Bebida;
import model.dinner.food.Comida;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PLATILLOS")
public class Platillo extends EntidadPersistente {
    @ManyToOne
    private Comida comida;
    @ManyToOne
    private Bebida bebida;

    public Platillo(Comida comida, Bebida bebida){
        this.bebida = bebida;
        this.comida = comida;
    }
    public Platillo(){}

    public double precio(){
        return comida.precio() + bebida.precio();
    }

    public void setComida(Comida comida) {
        this.comida = comida;
    }

    public void setBebida(Bebida bebida) {
        this.bebida = bebida;
    }

    public Comida getComida(){
        return comida;
    }
    public Bebida getBebida(){
        return bebida;
    }

    public boolean tienePropiedad(String nombre){
        return comida.tienePropiedad(nombre);
    }
}
