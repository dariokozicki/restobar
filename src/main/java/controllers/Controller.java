package controllers;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;

public abstract class Controller {
    public ModelAndView mostrarError(){
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("error", "Esta pagina no existe.");
        return new ModelAndView(parametros, "error.hbs");
    }
    public abstract ModelAndView mostrarTodos(Request request, Response response);
    public abstract ModelAndView mostrar(Request request, Response response);
    public abstract ModelAndView mostrarPorNombre(Request request, Response response);

}
