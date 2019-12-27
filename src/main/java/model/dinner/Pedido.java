package model.dinner;

import db.EntidadPersistente;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="PEDIDOS")
public class Pedido extends EntidadPersistente {
    @ManyToMany
    private List<Platillo> platillos;

    public Pedido(ArrayList<Platillo> platillos){
        this.platillos = platillos;
    }
    public Pedido(){}

    public double precio(){
        return platillos.stream().mapToDouble(p->p.precio()).sum();
    }

    public void setPlatillos(List<Platillo> platillos) {
        this.platillos = platillos;
    }
    public List<Platillo> getPlatillos(){
        return platillos;
    }
}
