package models;

import domain.dinner.food.Comestible;

import java.util.List;

public class ComestibleModel extends Model {
    private static ComestibleModel instance;

    public static ComestibleModel getInstance() {
        if(instance == null){
            instance = new ComestibleModel();
        }
        return instance;
    }

    @Override
    public List<Comestible> buscarTodos() {
        return entityManager().createQuery("from Comestible").getResultList();
    }

    @Override
    public Comestible buscar(int id) {
        return entityManager().find(Comestible.class,id);
    }

    @Override
    public Comestible buscar(String nombre){
        return (Comestible) entityManager()
                .createQuery("From Comestible c where c.nombre = :nombre")
                .setParameter("nombre", nombre)
                .getSingleResult();
    }
}

