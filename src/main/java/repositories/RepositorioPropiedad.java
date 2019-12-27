package repositories;

import domain.dinner.food.ingredients.Propiedad;
import repositories.daos.DAO;

import java.util.List;
public class RepositorioPropiedad extends Repositorio {
    private static RepositorioPropiedad instance;

    public static RepositorioPropiedad getInstance(DAO dao) {
        if (instance == null) {
            instance = new RepositorioPropiedad(dao);
        }
        return instance;
    }

    private RepositorioPropiedad(DAO dao) {
        this.setDao(dao);
    }

    public List<Propiedad> buscarTodos() {
        return this.dao.buscarTodos();
    }

    public Propiedad buscar(int id) {
        return this.dao.buscar(id);
    }
}