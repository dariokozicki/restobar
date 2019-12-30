package domain.dinner.food.ingredients;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.awt.*;
import java.util.List;

@Entity
public class Liquido extends Ingrediente {

    @Column(name="color")
    private Color color;

    public Liquido(String nombre, Double costo, List<Propiedad> propiedades, Color color){
        super(nombre,costo,propiedades);
        this.color = color;
    }

    public Liquido(){}

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getColorString(){
        setColorString();
        return colorString;
    }

    public void setColorString(){
        colorString = "rgb("+color.getRed()+","+color.getGreen()+","+color.getBlue()+")";
    }
}
