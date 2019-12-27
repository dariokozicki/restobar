import model.Cena;
import model.Invitado;
import model.Juntada;
import model.dinner.Pedido;
import model.dinner.Platillo;
import model.personalities.Alegre;
import model.personalities.Amigable;
import model.personalities.Enojon;
import model.personalities.Tacaño;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TestModel extends TestBasicObjects {

    @Test
    void testPrecioHamburguesa(){
        Assertions.assertEquals(135.0,hamburguesa.precio());
    }

    @Test
    void testPrecioEnsalada(){
        Assertions.assertEquals(53.75,ensalada.precio());
    }

    @Test
    void testPrecioHamburguesaPicante(){
        Assertions.assertEquals(61.25,hamburguesaPicante.precio());
    }

    @Test
    void testLeGustaAlEnojon(){
        Platillo platillo = new Platillo(hamburguesaPicante,jugo);
        Pedido pedido = new Pedido(new ArrayList<Platillo>(){
            {add(platillo);}
        });
        Invitado calenton = new Invitado(new Enojon(),"Carlitos");
        Assertions.assertTrue(calenton.leGusta(pedido));
    }

    @Test
    void testNoLeGustaAlEnojon(){
        Platillo sinpicante = new Platillo(hamburguesa,jugo);
        Pedido pedidonormal = new Pedido(new ArrayList<Platillo>(){
            {add(sinpicante);}
        });
        Invitado calenton = new Invitado(new Enojon(),"Carlitos");
        Assertions.assertFalse(calenton.leGusta(pedidonormal));
    }

    @Test
    void testLeGustaAlAlegre(){
        Platillo platillo = new Platillo(ensalada,destornillador);
        Pedido pedido = new Pedido(new ArrayList<Platillo>(){{add(platillo);}});
        Invitado alegre = new Invitado(new Alegre(5.0),"Ali Baba");
        Assertions.assertTrue(alegre.leGusta(pedido));
    }

    @Test
    void testNoLeGustaAlTacaño(){
        Platillo platillo = new Platillo(ensalada,jugo);
        Pedido pedido = new Pedido(new ArrayList<Platillo>(){{add(platillo);}});
        Invitado tacaño = new Invitado(new Tacaño(100.0),"Don Cangrejo");
        Assertions.assertFalse(tacaño.leGusta(pedido));
    }

    @Test
    void testLeGustaAlAmigable(){
        Platillo platillo = new Platillo(hamburguesa,destornillador);
        Pedido pedido = new Pedido(new ArrayList<Platillo>(){{add(platillo);}});
        Invitado arenita = new Invitado(new Amigable(),"Arenita");
        Assertions.assertTrue(arenita.leGusta(pedido));
    }

    Juntada prepararJuntada(){
        Platillo platillo = new Platillo(hamburguesa,destornillador);
        Platillo platilloPicante = new Platillo(hamburguesaPicante,jugo);
        Pedido pedido = new Pedido(new ArrayList<Platillo>(){{add(platillo);}});
        Pedido pedidoPicante = new Pedido(new ArrayList<Platillo>(){{add(platilloPicante);}});
        Invitado arenita = new Invitado(new Amigable(),"Arenita");
        Invitado calenton = new Invitado(new Enojon(),"Carlitos");
        Cena cena1 = new Cena(pedido, arenita);
        Cena cena2 = new Cena(pedidoPicante, calenton);
        return new Juntada(new ArrayList<Cena>(){{add(cena1);add(cena2);}},"Joda Loca");
    }

    @Test
    void testDeLaCuentaDeJuntada(){
        Juntada juntada = prepararJuntada();
        //precio de la morfi: 548.75, + propina : 648.75
        Assertions.assertEquals(648.75,juntada.laCuenta());
    }

    @Test
    void testLaJuntadaEstaBuena(){
        Juntada juntada = prepararJuntada();
        Assertions.assertTrue(juntada.estaBuena());
    }

}
