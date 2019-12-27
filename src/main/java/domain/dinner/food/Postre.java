package domain.dinner.food;

import domain.dinner.food.ingredients.Componente;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.ArrayList;
@Entity
@DiscriminatorValue("postre")
public class Postre extends Comida {
    public Postre(){}
    public Postre(String nombre, ArrayList<Componente> componentes) {
        super(nombre, componentes);
    }
}
