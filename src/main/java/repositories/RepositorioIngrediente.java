
package repositories;

import domain.dinner.food.ingredients.Ingrediente;
import repositories.daos.DAO;

import java.util.List;
public class RepositorioIngrediente extends Repositorio {
    private static RepositorioIngrediente instance;

    public static RepositorioIngrediente getInstance(DAO dao) {
        if (instance == null) {
            instance = new RepositorioIngrediente(dao);
        }
        return instance;
    }

    private RepositorioIngrediente(DAO dao) {
        this.setDao(dao);
    }

    public List<Ingrediente> buscarTodos() {
        return this.dao.buscarTodos();
    }

    public Ingrediente buscar(int id) {
        return this.dao.buscar(id);
    }
}