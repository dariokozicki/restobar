package domain.dinner.food;

import domain.dinner.food.ingredients.Componente;
import domain.dinner.food.ingredients.Liquido;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
@Entity
@Table(name="BEBIDAS")
public class Bebida extends Comestible<Liquido> {

    @Column(name="VALOR_ALCOHOLICO")
    private Double valorAlcoholico;

    public Bebida(){}

    public Bebida(String nombre, ArrayList<Componente<Liquido>> componentes, Double valorAlcoholico){
        super(nombre, componentes);
        this.valorAlcoholico = valorAlcoholico;
    }

    public double precio(){
        return super.precio() + valorAlcoholico*10;
    }


    public Double getValorAlcoholico(){
        return valorAlcoholico;
    }

    public void setValorAlcoholico(Double valorAlcoholico) {
        this.valorAlcoholico = valorAlcoholico;
    }
}
