package model;

import db.EntidadPersistente;
import model.dinner.Pedido;

import javax.persistence.*;

@Entity
@Table(name="CENAS")
public class Cena  extends EntidadPersistente {

    @OneToOne
    private Pedido pedido;
    @OneToOne
    private Invitado invitado;

    public Cena(Pedido pedido, Invitado invitado) {
        this.pedido = pedido;
        this.invitado = invitado;
    }

    public Cena(){}

    public double precio(){
        return pedido.precio();
    }

    public Invitado getInvitado(){
        return invitado;
    }

    public void setInvitado(Invitado invitado) {
        this.invitado = invitado;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public boolean estaBuena(){
        return invitado.leGusta(pedido);
    }

}
