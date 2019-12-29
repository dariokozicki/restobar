package models;

import domain.dinner.food.ingredients.Ingrediente;
import domain.dinner.food.ingredients.Propiedad;

import java.util.List;

public class PropiedadModel extends Model {
    private static PropiedadModel instance;

    public static PropiedadModel getInstance() {
        if(instance == null){
            instance = new PropiedadModel();
        }
        return instance;
    }

    @Override
    public List<Propiedad> buscarTodos() {
        return entityManager().createQuery("from Propiedad").getResultList();
    }

    @Override
    public Propiedad buscar(int id) {
        return entityManager().find(Propiedad.class,id);
    }

    @Override
    public Propiedad buscar(String nombre){
        return (Propiedad) entityManager().createQuery("from Propiedad P HAVING P.nombre = ".concat(nombre)).getSingleResult();
    }
}
