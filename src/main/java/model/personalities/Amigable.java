package model.personalities;

import db.EntidadPersistente;
import model.dinner.Pedido;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="AMIGABLES")
public class Amigable extends Personalidad {

    public Amigable(){}

    @Override
    public boolean leGusta(Pedido pedido) {
        return true;
    }
}
