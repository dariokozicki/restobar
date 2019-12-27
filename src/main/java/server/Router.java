package server;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;
import spark.utils.BooleanHelper;
import spark.utils.HandlebarsTemplateEngineBuilder;
import controllers.*;


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
        IngredienteController ingredienteController = new IngredienteController();

        Spark.path("/api", ()->{
            Spark.before("/*", (request, response) -> {
                log.println("Received api call");
            });
            Spark.path("/ingredientes",()->{
                Spark.get("/:id", ingredienteController::mostrar);
                Spark.get("", ingredienteController::mostrarTodos);
            });

        });

    }
}
