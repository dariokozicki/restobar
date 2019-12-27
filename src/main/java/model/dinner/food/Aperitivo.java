package model.dinner.food;

import model.dinner.food.ingredients.Componente;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.ArrayList;
@Entity
@DiscriminatorValue("aperitivo")
public class Aperitivo extends Comida {
    public Aperitivo(){}
    public Aperitivo(String nombre, ArrayList<Componente> componentes) {
        super(nombre, componentes);
    }

}
