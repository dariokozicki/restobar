package domain.dinner.food.ingredients;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.List;

@Entity
public class Solido extends Ingrediente {

    @Column(name="path")
    private String path;

    public Solido(){
    }

    @Override
    public String getColorString() {
        return null;
    }

    @Override
    public void setColorString() {

    }

    public Solido(String nombre, Double costo, List<Propiedad> propiedades, String path) {
        super(nombre,costo,propiedades);
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String color(){
        return null;
    }
}
