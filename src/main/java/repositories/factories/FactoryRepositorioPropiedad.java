package repositories.factories;
import models.IngredienteModel;
import models.PropiedadModel;
import repositories.RepositorioIngrediente;
import repositories.RepositorioPropiedad;
import repositories.daos.DAOMySQL;

public class FactoryRepositorioPropiedad {
    private static RepositorioPropiedad repo;

    public static RepositorioPropiedad get(){
        if(repo == null){
            repo = RepositorioPropiedad.getInstance(new DAOMySQL(PropiedadModel.getInstance()));
        }
        return repo;
    }
}