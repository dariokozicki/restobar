package domain.dinner.food;

import domain.dinner.food.ingredients.Componente;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.ArrayList;
@Entity
@DiscriminatorValue("plato principal")
public class PlatoPrincipal extends Comida {
    public PlatoPrincipal(){}
    public PlatoPrincipal(String nombre, ArrayList<Componente> componentes) {
        super(nombre, componentes);
    }
}
