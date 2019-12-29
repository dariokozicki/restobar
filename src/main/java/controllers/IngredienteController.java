package controllers;
import domain.dinner.food.ingredients.Ingrediente;
import domain.dinner.food.ingredients.Propiedad;
import repositories.RepositorioIngrediente;
import repositories.RepositorioPropiedad;
import repositories.factories.FactoryRepositorioIngrediente;
import repositories.factories.FactoryRepositorioPropiedad;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IngredienteController {
    private RepositorioIngrediente repo;

    public IngredienteController(){
        this.repo = FactoryRepositorioIngrediente.get();
    }

    public ModelAndView mostrarTodos(Request request, Response response) {
        Map<String, Object> parametros = new HashMap<>();
        List<Ingrediente> ingredientes = this.repo.buscarTodos();
        parametros.put("ingredientes", ingredientes);
        return new ModelAndView(parametros, "ingredientes.hbs");
    }

    public ModelAndView mostrar(Request request, Response response){
        Ingrediente ingrediente = this.repo.buscar(new Integer(request.params("id")));
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("ingrediente", ingrediente);
        return new ModelAndView(parametros, "ingrediente.hbs");
    }

    public ModelAndView mostrarPorNombre(Request request, Response response){
        Ingrediente ingrediente = this.repo.buscar(request.queryParams("nombre"));
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("ingrediente", ingrediente);
        return new ModelAndView(parametros, "ingrediente.hbs");
    }

    public Response modificar(Request request, Response response){
        Ingrediente ingrediente = this.repo.buscar(new Integer(request.params("id")));
        asignarAtributosA(ingrediente, request);
        this.repo.modificar(ingrediente);
        response.redirect("/ingredientes");
        return response;
    }

    private void asignarAtributosA(Ingrediente ingrediente, Request request){
        if(request.queryParams("costo") != null){
            double costo = new Double(request.queryParams("costo"));
            ingrediente.setCosto(costo);
        }

        if(request.queryParams("nombre") != null){
            ingrediente.setNombre(request.queryParams("nombre"));
        }

        if(request.queryParams("propiedades") != null){
            List<Propiedad> propiedades = new ArrayList<>();
            RepositorioPropiedad repoProp = FactoryRepositorioPropiedad.get();
            for (String id : request.queryParams("propiedades").split(",")){
                propiedades.add(repoProp.buscar(Integer.valueOf(id)));
            }
            ingrediente.setPropiedades(propiedades);
        }
    }

    public ModelAndView crear(Request request, Response response){
        Map<String, Object> parametros = new HashMap<>();
        RepositorioIngrediente repositorioIngrediente = FactoryRepositorioIngrediente.get();

        parametros.put("ingredientes", repositorioIngrediente.buscarTodos());
        return new ModelAndView(parametros, "ingredientes.hbs");
    }

    public Response guardar(Request request, Response response){
        Ingrediente ingrediente = new Ingrediente();
        asignarAtributosA(ingrediente, request);
        this.repo.agregar(ingrediente);
        response.redirect("/ingredientes");
        return response;
    }

    public Response eliminar(Request request, Response response){
        Ingrediente ingrediente = this.repo.buscar(new Integer(request.params("id")));
        this.repo.eliminar(ingrediente);
        return response;
    }
}