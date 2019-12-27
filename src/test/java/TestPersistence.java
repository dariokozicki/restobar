import db.EntityManagerHelper;
import model.Cena;
import model.Invitado;
import model.Juntada;
import model.dinner.Pedido;
import model.dinner.Platillo;
import model.personalities.Amigable;
import model.personalities.Enojon;
import model.personalities.Personalidad;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TestPersistence extends TestBasicObjects {

    @Test
    public void persistenciaInicial(){
        Platillo platillo = new Platillo(hamburguesa,destornillador);
        Platillo platilloPicante = new Platillo(hamburguesaPicante,jugo);
        Pedido pedido = new Pedido(new ArrayList<Platillo>(){{add(platillo);}});
        Pedido pedidoPicante = new Pedido(new ArrayList<Platillo>(){{add(platilloPicante);}});
        Personalidad amigable = new Amigable();
        Personalidad enojon = new Enojon();
        Invitado arenita = new Invitado(amigable,"Arenita");
        Invitado calenton = new Invitado(enojon,"Carlitos");
        Cena cena1 = new Cena(pedido, arenita);
        Cena cena2 = new Cena(pedidoPicante, calenton);
        Juntada juntada = new Juntada(new ArrayList<Cena>(){{add(cena1);add(cena2);}},"Joda Loca");

        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().persist(picante);
        EntityManagerHelper.getEntityManager().persist(grasoso);
        EntityManagerHelper.getEntityManager().persist(salado);
        EntityManagerHelper.getEntityManager().persist(dulce);
        EntityManagerHelper.getEntityManager().persist(saludable);
        EntityManagerHelper.getEntityManager().persist(amargo);
        EntityManagerHelper.getEntityManager().persist(alcoholico);

        EntityManagerHelper.getEntityManager().persist(lechuga);
        EntityManagerHelper.getEntityManager().persist(tomate);
        EntityManagerHelper.getEntityManager().persist(cebolla);
        EntityManagerHelper.getEntityManager().persist(pan);
        EntityManagerHelper.getEntityManager().persist(queso);
        EntityManagerHelper.getEntityManager().persist(aji);
        EntityManagerHelper.getEntityManager().persist(jugoDeNaranja);
        EntityManagerHelper.getEntityManager().persist(vodka);
        EntityManagerHelper.getEntityManager().persist(paty);

        hamburguesa.getComponentes().forEach(c->EntityManagerHelper.getEntityManager().persist(c));
        hamburguesaPicante.getComponentes().forEach(c->EntityManagerHelper.getEntityManager().persist(c));
        ensalada.getComponentes().forEach(c->EntityManagerHelper.getEntityManager().persist(c));
        jugo.getComponentes().forEach(c->EntityManagerHelper.getEntityManager().persist(c));
        destornillador.getComponentes().forEach(c->EntityManagerHelper.getEntityManager().persist(c));

        EntityManagerHelper.getEntityManager().persist(hamburguesa);
        EntityManagerHelper.getEntityManager().persist(hamburguesaPicante);
        EntityManagerHelper.getEntityManager().persist(ensalada);

        EntityManagerHelper.getEntityManager().persist(jugo);
        EntityManagerHelper.getEntityManager().persist(destornillador);

        EntityManagerHelper.getEntityManager().persist(enojon);
        EntityManagerHelper.getEntityManager().persist(amigable);

        EntityManagerHelper.getEntityManager().persist(platillo);
        EntityManagerHelper.getEntityManager().persist(platilloPicante);
        EntityManagerHelper.getEntityManager().persist(pedido);
        EntityManagerHelper.getEntityManager().persist(pedidoPicante);
        EntityManagerHelper.getEntityManager().persist(arenita);
        EntityManagerHelper.getEntityManager().persist(calenton);
        EntityManagerHelper.getEntityManager().persist(cena1);
        EntityManagerHelper.getEntityManager().persist(cena2);
        EntityManagerHelper.getEntityManager().persist(juntada);

        EntityManagerHelper.commit();
    }

    @Test
    public void recuperandoACarlitos(){
        Invitado calenton = (Invitado) EntityManagerHelper.createQuery("from Invitado where nombre='Carlitos'").getResultList().get(0);
        Assertions.assertEquals("Carlitos",calenton.getNombre());
    }

    @Test
    public void recuperandoLaJuntada(){
        Juntada juntada = (Juntada) EntityManagerHelper.createQuery("from Juntada where nombre='Joda Loca'").getResultList().get(0);
        Assertions.assertEquals("Joda Loca", juntada.getNombre());
    }
}
