import db.EntityManagerHelper;
import model.Cena;
import model.Invitado;
import model.Juntada;
import model.dinner.Pedido;
import model.dinner.Platillo;
import model.dinner.food.Aperitivo;
import model.dinner.food.Bebida;
import model.dinner.food.Comida;
import model.dinner.food.PlatoPrincipal;
import model.dinner.food.ingredients.Componente;
import model.dinner.food.ingredients.Ingrediente;
import model.dinner.food.ingredients.Propiedad;
import model.personalities.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        );

        tomate = new Ingrediente("tomate",20.0,
                new ArrayList<Propiedad>() {
                    {
                        add(saludable);
                        add(salado);
                    }
                }
        );

        cebolla = new Ingrediente("cebolla",8.0,
                new ArrayList<Propiedad>() {
                    {
                        add(saludable);
                        add(salado);
                    }
                }
        );

        paty = new Ingrediente("paty",25.0,
                new ArrayList<Propiedad>() {
                    {
                        add(grasoso);
                        add(salado);
                    }
                }
        );

        pan = new Ingrediente("pan",7.0,
                new ArrayList<Propiedad>() {
                    {
                        add(saludable);
                        add(salado);
                    }
                }
        );

        queso = new Ingrediente("queso",26.0,
                new ArrayList<Propiedad>() {
                    {
                        add(grasoso);
                        add(salado);
                    }
                }
        );

        aji = new Ingrediente("aji",10.0,
                new ArrayList<Propiedad>() {
                    {
                        add(grasoso);
                        add(salado);
                        add(picante);
                    }
                }
        );

        vodka = new Ingrediente("vodka",30.0,
                new ArrayList<Propiedad>() {
                    {
                        add(alcoholico);
                    }
                }
        );

        jugoDeNaranja = new Ingrediente("Jugo de Naranja",6.0,
                new ArrayList<Propiedad>() {
                    {
                        add(dulce);
                        add(saludable);
                    }
                }
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
