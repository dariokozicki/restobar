package server;

import javassist.NotFoundException;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;
import spark.*;
import spark.template.handlebars.HandlebarsTemplateEngine;
import spark.utils.BooleanHelper;
import spark.utils.HandlebarsTemplateEngineBuilder;
import controllers.*;


import java.util.HashMap;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;
import static spark.utils.urldecoding.UrlDecode.path;

public class Router {
    private static HandlebarsTemplateEngine engine;

    private static void initEngine(){
        Router.engine = HandlebarsTemplateEngineBuilder
                .create()
                .withDefaultHelpers()
                .withHelper("isTrue", BooleanHelper.isTrue)
                .build();
    }

    public static void init(){
        Router.initEngine();
        Spark.staticFileLocation("/public");
        Router.configure();
    }

    private static void configure(){
        HashMap<String,Controller> controllers = getControllers();
            Spark.get("/ingredientes", controllers.get("ingrediente")::mostrarTodos, Router.engine);
            Spark.get("/ingrediente/:id", controllers.get("ingrediente")::mostrar, Router.engine);
            Spark.get("/ingrediente", controllers.get("ingrediente")::mostrarPorNombre, Router.engine );

            Spark.get("/comestibles", controllers.get("comestible")::mostrarTodos, Router.engine);
            Spark.get("/comestible/:id", controllers.get("comestible")::mostrar, Router.engine);
            Spark.get("/comestible", controllers.get("comestible")::mostrarPorNombre, Router.engine );
            Spark.get("/", Router::index,Router.engine);
    }

    private static HashMap<String,Controller> getControllers(){
        HashMap<String,Controller> controllers = new HashMap<>();
        controllers.put("ingrediente", new IngredienteController());
        controllers.put("comestible", new ComestibleController());


        return controllers;
    }

    public static ModelAndView index(Request request, Response response){
        return new ModelAndView(null, "index.hbs");
    }
}
