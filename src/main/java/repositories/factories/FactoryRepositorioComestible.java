package repositories.factories;

import models.ComestibleModel;
import repositories.RepositorioComestible;
import repositories.daos.DAOMySQL;

public class FactoryRepositorioComestible {
    private static RepositorioComestible repo;

    public static RepositorioComestible get(){
        if(repo == null){
            repo = RepositorioComestible.getInstance(new DAOMySQL(ComestibleModel.getInstance()));
        }
        return repo;
    }
}