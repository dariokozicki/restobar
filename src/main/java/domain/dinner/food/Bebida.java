package domain.dinner.food;

import domain.dinner.food.ingredients.Componente;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
@Entity
@Table(name="BEBIDAS")
public class Bebida extends Parte {

    private Double valorAlcoholico;
    public Bebida(){}
    public Bebida(String nombre, ArrayList<Componente> componentes, Double valorAlcoholico){
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
