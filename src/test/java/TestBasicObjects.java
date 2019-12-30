import domain.dinner.food.Aperitivo;
import domain.dinner.food.Bebida;
import domain.dinner.food.Comida;
import domain.dinner.food.PlatoPrincipal;
import domain.dinner.food.ingredients.*;
import org.junit.jupiter.api.BeforeEach;

import java.awt.*;
import java.util.ArrayList;

public class TestBasicObjects {
    Propiedad picante, saludable, grasoso, amargo, dulce, salado, alcoholico;

    Solido lechuga, tomate, paty, cebolla, panSuperior, panInferior, queso, aji;

    Liquido jugoDeNaranja, vodka;

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

        lechuga = new Solido("Lechuga",15.0,
                new ArrayList<Propiedad>() {
                    {
                        add(saludable);
                        add(salado);
                    }
                }
                ,"/images/ingredientes/lechuga.png"
        );

        tomate = new Solido("Tomate",20.0,
                new ArrayList<Propiedad>() {
                    {
                        add(saludable);
                        add(salado);
                    }
                }, "/images/ingredientes/tomate.png"
        );

        cebolla = new Solido("Cebolla",8.0,
                new ArrayList<Propiedad>() {
                    {
                        add(saludable);
                        add(salado);
                    }
                }
                ,"/images/ingredientes/cebolla.png"
        );

        paty = new Solido("Hamburguesa",25.0,
                new ArrayList<Propiedad>() {
                    {
                        add(grasoso);
                        add(salado);
                    }
                }, "/images/ingredientes/hamburguesa.png"
        );

        panSuperior = new Solido("Pan Superior",7.0,
                new ArrayList<Propiedad>() {
                    {
                        add(saludable);
                        add(salado);
                    }
                } ,"/images/ingredientes/pan.png"
        );

        panInferior = new Solido("Pan Inferior",7.0,
                new ArrayList<Propiedad>() {
                    {
                        add(saludable);
                        add(salado);
                    }
                } ,"/images/ingredientes/pan.png"
        );
        queso = new Solido("Queso",26.0,
                new ArrayList<Propiedad>() {
                    {
                        add(grasoso);
                        add(salado);
                    }
                }, "/images/ingredientes/queso.png"
        );

        aji = new Solido("Aji",10.0,
                new ArrayList<Propiedad>() {
                    {
                        add(grasoso);
                        add(salado);
                        add(picante);
                    }
                }, "/images/ingredientes/aji.png"
        );

        vodka = new Liquido("Vodka",30.0,
                new ArrayList<Propiedad>() {
                    {
                        add(alcoholico);
                    }
                },new Color(225,234,234)
        );

        jugoDeNaranja = new Liquido("Jugo de Naranja",6.0,
                new ArrayList<Propiedad>() {
                    {
                        add(dulce);
                        add(saludable);
                    }
                },new Color(250,193,78)
        );

        hamburguesa = new PlatoPrincipal("Royale with Cheese", new ArrayList<Componente<Solido>>()
        {
            {
                add(new Componente<>(panSuperior,1));
                add(new Componente<>(paty,2));
                add(new Componente<>(lechuga,3));
                add(new Componente<>(tomate,4));
                add(new Componente<>(cebolla,5));
                add(new Componente<>(queso,6));
                add(new Componente<>(panInferior,7));
            }
        });

        ensalada = new Aperitivo("Ensalada Normal", new ArrayList<Componente<Solido>>(){
            {
                add(new Componente<>(lechuga,3));
                add(new Componente<>(tomate,4));
                add(new Componente<>(cebolla,5));
            }
        });

        hamburguesaPicante = new PlatoPrincipal("Inferno Burger", new ArrayList<Componente<Solido>>()
        {
            {
                add(new Componente<>(panSuperior,1));
                add(new Componente<>(paty,2));
                add(new Componente<>(aji,3));
                add(new Componente<>(panInferior,4));
            }
        });

        destornillador = new Bebida("Destornillador", new ArrayList<Componente<Liquido>>(){
            {
                add(new Componente<>(vodka,1));
                add(new Componente<>(jugoDeNaranja,2));
            }
        }, 15.0);

        jugo = new Bebida("Jugo", new ArrayList<Componente<Liquido>>(){
            {
                add(new Componente<>(jugoDeNaranja,1));
            }
        }, 15.0);
    }

}
