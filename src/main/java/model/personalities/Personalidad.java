package model.personalities;

import db.EntidadPersistente;
import model.dinner.Pedido;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Personalidad extends EntidadPersistente {

    public Personalidad(){}
    public abstract boolean leGusta(Pedido pedido);
}
