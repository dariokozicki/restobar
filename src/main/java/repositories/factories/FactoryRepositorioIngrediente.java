package repositories.factories;
import models.IngredienteModel;
import repositories.RepositorioIngrediente;
import repositories.daos.DAOMySQL;

public class FactoryRepositorioIngrediente {
    private static RepositorioIngrediente repo;

    public static RepositorioIngrediente get(){
        if(repo == null){
                repo = RepositorioIngrediente.getInstance(new DAOMySQL(IngredienteModel.getInstance()));
        }
        return repo;
    }
}