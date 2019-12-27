package model.personalities;

import db.EntidadPersistente;
import model.dinner.Pedido;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="TACAÑOS")
public class Tacaño extends Personalidad {
    @Column(name="PRECIO_MAXIMO")
    private Double hastaCuantoSeEstira;

    public Tacaño(Double hastaCuantoSeEstira){
        this.hastaCuantoSeEstira = hastaCuantoSeEstira;
    }
    public Tacaño(){}

    @Override
    public boolean leGusta(Pedido pedido) {
        return pedido.precio()<hastaCuantoSeEstira;
    }
}
