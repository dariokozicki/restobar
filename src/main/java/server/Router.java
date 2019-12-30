package server;

import javassist.NotFoundException;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;
import spark.Spark;
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

        Spark.path("/api", ()->{
            Spark.before("/*", (request, response) -> {
                log.println("Received api call");
            });
            Spark.path("/ingredientes",()->{
                Spark.get("", controllers.get("ingrediente")::mostrarTodos, Router.engine);
            });
            Spark.path("/ingrediente", ()->{
                Spark.get("/:id", controllers.get("ingrediente")::mostrar, Router.engine);
                Spark.get("", controllers.get("ingrediente")::mostrarPorNombre, Router.engine );
            });
            Spark.path("/comestibles", ()->{
                Spark.get("", controllers.get("comestible")::mostrarTodos, Router.engine);
            });
            Spark.path("/comestible", ()->{
                Spark.get("/:id", controllers.get("comestible")::mostrar, Router.engine);
                Spark.get("", controllers.get("comestible")::mostrarPorNombre, Router.engine );
            });
        });
    }

    private static HashMap<String,Controller> getControllers(){
        HashMap<String,Controller> controllers = new HashMap<>();
        controllers.put("ingrediente", new IngredienteController());
        controllers.put("comestible", new ComestibleController());


        return controllers;
    }
}
