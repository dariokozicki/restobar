package domain.personalities;

import domain.dinner.Pedido;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="ALEGRES")
public class Alegre extends Personalidad{
    @Column(name="NIVEL_DE_ALCOHOLEMIA")
    private Double nivelDeAlcoholemia;

    public Alegre(Double nivelDeAlcoholemia) {
        this.nivelDeAlcoholemia = nivelDeAlcoholemia;
    }

    public Alegre(){}

    @Override
    public boolean leGusta(Pedido pedido) {
        return sePuedePonerAlegre(pedido);
    }


    public boolean sePuedePonerAlegre(Pedido pedido){
        return pedido.getPlatillos().stream().
                mapToDouble(platillo->platillo.getBebida().getValorAlcoholico()).sum()
                >=nivelDeAlcoholemia;
    }

    public Double getNivelDeAlcoholemia() {
        return nivelDeAlcoholemia;
    }

    public void setNivelDeAlcoholemia(Double nivelDeAlcoholemia) {
        this.nivelDeAlcoholemia = nivelDeAlcoholemia;
    }
}
