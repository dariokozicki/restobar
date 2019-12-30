package controllers;
import domain.dinner.food.ingredients.Ingrediente;
import repositories.RepositorioIngrediente;
import repositories.factories.FactoryRepositorioIngrediente;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IngredienteController extends Controller {
    private RepositorioIngrediente repo;

    public IngredienteController(){
        this.repo = FactoryRepositorioIngrediente.get();
    }

    public ModelAndView mostrarTodos(Request request, Response response) {
        try {
            Map<String, Object> parametros = new HashMap<>();
            List<Ingrediente> ingredientes = this.repo.buscarTodos();
            ingredientes.stream().forEach(i->i.setColorString());
            parametros.put("ingredientes", ingredientes);
            return new ModelAndView(parametros, "ingredientes.hbs");
        }catch(Exception e){
            return mostrarError();
        }
    }

    public ModelAndView mostrar(Request request, Response response){
        try{
            Ingrediente ingrediente = this.repo.buscar(new Integer(request.params("id")));
            Map<String, Object> parametros = new HashMap<>();
            ingrediente.setColorString();
            parametros.put("ingrediente", ingrediente);
            return new ModelAndView(parametros, "ingrediente.hbs");
        }catch(Exception e){
            return mostrarError();
        }
    }

    public ModelAndView mostrarPorNombre(Request request, Response response){
        try{
            Ingrediente ingrediente = this.repo.buscar(request.queryParams("nombre"));
            Map<String, Object> parametros = new HashMap<>();
            ingrediente.setColorString();
            parametros.put("ingrediente", ingrediente);
            return new ModelAndView(parametros, "ingrediente.hbs");
        }catch(Exception e){
            return mostrarError();
        }
    }


}