package domain.personalities;

import db.EntidadPersistente;
import domain.dinner.Pedido;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Personalidad extends EntidadPersistente {

    public Personalidad(){}
    public abstract boolean leGusta(Pedido pedido);
}
