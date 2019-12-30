package domain.dinner.food;

import domain.dinner.food.ingredients.Componente;
import domain.dinner.food.ingredients.Solido;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import java.util.ArrayList;

@Entity
@Table(name="COMIDAS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Comida extends Comestible<Solido> {

    public Comida(String nombre, ArrayList<Componente<Solido>> componentes) {
        super(nombre, componentes);
    }

    public Comida(){}

    public double precio(){
        return super.precio();
    }

    public boolean tienePropiedad(String descripcion){
        return componentes.stream().flatMap(componente -> componente.getIngrediente().getPropiedades().stream())
                .anyMatch(propiedad -> descripcion.equals(propiedad.getNombre()));
    }
}
