package models;

import domain.dinner.food.ingredients.Ingrediente;

import java.util.List;

public class IngredienteModel extends Model {
    private static IngredienteModel instance;

    public static IngredienteModel getInstance() {
        if(instance == null){
            instance = new IngredienteModel();
        }
        return instance;
    }

    @Override
    public List<Ingrediente> buscarTodos() {
        return entityManager().createQuery("from Ingrediente").getResultList();
    }

    @Override
    public Ingrediente buscar(int id) {
        return entityManager().find(Ingrediente.class,id);
    }

    @Override
    public Ingrediente buscar(String nombre){
        return (Ingrediente) entityManager()
                .createQuery("From Ingrediente i where i.nombre = :nombre")
                .setParameter("nombre",nombre)
                .getSingleResult();
    }
}
