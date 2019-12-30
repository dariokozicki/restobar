package controllers;

import domain.dinner.food.Comestible;
import repositories.RepositorioComestible;
import repositories.RepositorioIngrediente;
import repositories.factories.FactoryRepositorioComestible;
import repositories.factories.FactoryRepositorioIngrediente;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComestibleController extends Controller{
    private RepositorioComestible repo;

    public ComestibleController(){
        this.repo = FactoryRepositorioComestible.get();
    }

    public ModelAndView mostrarTodos(Request request, Response response) {
        try {
            Map<String, Object> parametros = new HashMap<>();
            List<Comestible> comestible = this.repo.buscarTodos();
            parametros.put("comestibles", comestible);
            return new ModelAndView(parametros, "comestibles.hbs");
        }catch(Exception e){
            return mostrarError();
        }
    }

    public ModelAndView mostrar(Request request, Response response){
        try{
            Comestible comestible = this.repo.buscar(new Integer(request.params("id")));
            Map<String, Object> parametros = new HashMap<>();
            comestible.sortComponentes();
            parametros.put("comestible", comestible);
            return new ModelAndView(parametros, "comestible.hbs");
        }catch(Exception e){
            return mostrarError();
        }
    }

    public ModelAndView mostrarPorNombre(Request request, Response response){
        try{
            Comestible comestible = this.repo.buscar(request.queryParams("nombre"));
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("comestible", comestible);
            return new ModelAndView(parametros, "comestible.hbs");
        }catch(Exception e){
            return mostrarError();
        }
    }
}
