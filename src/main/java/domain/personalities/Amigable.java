package domain.personalities;

import domain.dinner.Pedido;

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
