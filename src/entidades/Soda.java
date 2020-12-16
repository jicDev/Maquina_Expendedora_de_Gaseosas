package entidades;

public class Soda {
    private String brand;
    private String company;
    private int stock;

    public Soda(String brand, String company, int stock) {
        this.brand = brand;
        this.company = company;
        this.stock = stock;
    }

    public Soda(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCompany() {
        return this.company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getStock() {
        return this.stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

}
