package entidades;

import java.util.Vector;

public class Gaseosa {
    private String productor;
    private String marca;
    private int stock;

    public Gaseosa(String marca, String productor, int stock) {
        this.marca = marca;
        this.productor = productor;
        this.stock = stock;
    }

    public Gaseosa(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getProductor() {
        return this.productor;
    }

    public void setProductor(String productor) {
        this.productor = productor;
    }

    public int getStock() {
        return this.stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

}
