package model.personalities;

import db.EntidadPersistente;
import model.dinner.Pedido;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="ENOJONES")
public class Enojon  extends Personalidad {
    public Enojon(){}

    @Override
    public boolean leGusta(Pedido pedido) {
        return pedido.getPlatillos().stream().anyMatch(p->p.tienePropiedad("picante"));
    }
}
