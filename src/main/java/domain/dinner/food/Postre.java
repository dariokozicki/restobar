package domain.dinner.food;

import domain.dinner.food.ingredients.Componente;
import domain.dinner.food.ingredients.Solido;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.ArrayList;
@Entity
@DiscriminatorValue("postre")
public class Postre extends Comida {
    public Postre(){}
    public Postre(String nombre, ArrayList<Componente<Solido>> componentes) {
        super(nombre, componentes);
    }
}
