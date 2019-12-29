import domain.dinner.food.Aperitivo;
import domain.dinner.food.Bebida;
import domain.dinner.food.Comida;
import domain.dinner.food.PlatoPrincipal;
import domain.dinner.food.ingredients.Componente;
import domain.dinner.food.ingredients.Ingrediente;
import domain.dinner.food.ingredients.Propiedad;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

public class TestBasicObjects {
    Propiedad picante, saludable, grasoso, amargo, dulce, salado, alcoholico;

    Ingrediente lechuga, tomate, paty, cebolla, pan, queso, aji, jugoDeNaranja, vodka;

    Comida hamburguesa, hamburguesaPicante, ensalada;

    Bebida jugo, destornillador;

    @BeforeEach
    protected void init(){
        picante = new Propiedad("picante");
        saludable = new Propiedad("saludable");
        grasoso = new Propiedad("grasoso");
        amargo = new Propiedad("amargo");
        dulce = new Propiedad("dulce");
        salado = new Propiedad("salado");
        alcoholico = new Propiedad("alcoholico");

        lechuga = new Ingrediente("lechuga",15.0,
                new ArrayList<Propiedad>() {
                    {
                        add(saludable);
                        add(salado);
                    }
                }
                ,"https://i.imgur.com/ii4y3fs.png"
        );

        tomate = new Ingrediente("tomate",20.0,
                new ArrayList<Propiedad>() {
                    {
                        add(saludable);
                        add(salado);
                    }
                }, "https://i.imgur.com/3rK13nf.png"
        );

        cebolla = new Ingrediente("cebolla",8.0,
                new ArrayList<Propiedad>() {
                    {
                        add(saludable);
                        add(salado);
                    }
                }
                ,"https://i.imgur.com/lGvDNgU.png"
        );

        paty = new Ingrediente("paty",25.0,
                new ArrayList<Propiedad>() {
                    {
                        add(grasoso);
                        add(salado);
                    }
                }, "https://i.imgur.com/j6r7T8T.png"
        );

        pan = new Ingrediente("pan",7.0,
                new ArrayList<Propiedad>() {
                    {
                        add(saludable);
                        add(salado);
                    }
                } ,"https://i.imgur.com/yoetvSl.png"
        );

        queso = new Ingrediente("queso",26.0,
                new ArrayList<Propiedad>() {
                    {
                        add(grasoso);
                        add(salado);
                    }
                }, "https://i.imgur.com/rhXjtvX.png"
        );

        aji = new Ingrediente("aji",10.0,
                new ArrayList<Propiedad>() {
                    {
                        add(grasoso);
                        add(salado);
                        add(picante);
                    }
                }, "https://i.imgur.com/bAmIu31.png"
        );

        vodka = new Ingrediente("vodka",30.0,
                new ArrayList<Propiedad>() {
                    {
                        add(alcoholico);
                    }
                },"https://media-verticommnetwork1.netdna-ssl.com/wines/absolut-vodka-1l-920226.png"
        );

        jugoDeNaranja = new Ingrediente("Jugo de Naranja",6.0,
                new ArrayList<Propiedad>() {
                    {
                        add(dulce);
                        add(saludable);
                    }
                },"https://martinibox.cl/wp-content/uploads/2018/03/Prod-LIQUIDO-CIT003.png"
        );

        hamburguesa = new PlatoPrincipal("Royale with Cheese", new ArrayList<Componente>()
        {
            {
                add(new Componente(pan,1));
                add(new Componente(paty,2));
                add(new Componente(lechuga,3));
                add(new Componente(tomate,4));
                add(new Componente(cebolla,5));
                add(new Componente(queso,6));
                add(new Componente(pan,7));
            }
        });

        ensalada = new Aperitivo("Ensalada Normal", new ArrayList<Componente>(){
            {
                add(new Componente(lechuga,3));
                add(new Componente(tomate,4));
                add(new Componente(cebolla,5));
            }
        });

        hamburguesaPicante = new PlatoPrincipal("Inferno Burger", new ArrayList<Componente>()
        {
            {
                add(new Componente(pan,1));
                add(new Componente(paty,2));
                add(new Componente(aji,3));
                add(new Componente(pan,4));
            }
        });

        destornillador = new Bebida("Destornillador", new ArrayList<Componente>(){
            {
                add(new Componente(vodka,1));
                add(new Componente(jugoDeNaranja,2));
            }
        }, 15.0);

        jugo = new Bebida("Jugo", new ArrayList<Componente>(){
            {
                add(new Componente(jugoDeNaranja,1));
            }
        }, 15.0);
    }

}
