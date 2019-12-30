package repositories;

import domain.dinner.food.Comestible;
import repositories.daos.DAO;

import java.util.List;

public class RepositorioComestible extends Repositorio {
    private static RepositorioComestible instance;

    public static RepositorioComestible getInstance(DAO dao) {
        if (instance == null) {
            instance = new RepositorioComestible(dao);
        }
        return instance;
    }

    private RepositorioComestible(DAO dao) {
        this.setDao(dao);
    }

    public List<Comestible> buscarTodos() {
        return this.dao.buscarTodos();
    }

    public Comestible buscar(int id) {
        return this.dao.buscar(id);
    }
    public Comestible buscar(String nombre){
        return this.dao.buscar(nombre);
    }

}