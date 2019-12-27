package domain;

import db.EntidadPersistente;
import domain.dinner.Pedido;
import domain.personalities.Personalidad;

import javax.persistence.*;

@Entity
@Table(name="INVITADOS")
public class Invitado  extends EntidadPersistente {
    @OneToOne
    @JoinColumn(name="PERSONALIDAD_ID")
    private Personalidad personalidad;
    @Column(name="NOMBRE")
    private String nombre;

    public Invitado(Personalidad personalidad, String nombre) {
        this.personalidad = personalidad;
        this.nombre = nombre;
    }
    public Invitado(){

    }
    public boolean leGusta(Pedido pedido){
        return personalidad.leGusta(pedido);
    }

    public String getNombre(){
        return nombre;
    }

    public Personalidad getPersonalidad() {
        return personalidad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPersonalidad(Personalidad personalidad) {
        this.personalidad = personalidad;
    }

}
