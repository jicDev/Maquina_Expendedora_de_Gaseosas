package entidades;

public class Soda {
    private String brand;
    private String company;
    private int stock;

    public Soda() {
        this.brand = null;
        this.company = null;
        this.stock = 0;
    }

    public Soda(String brand, String company, int stock) {
        this.brand = brand;
        this.company = company;
        this.stock = stock;
    }

    public Soda(String brand) {
        this.brand = brand;
    }

    public String GetBrand() {
        return this.brand;
    }

    public void SetBrand(String brand) {
        this.brand = brand;
    }

    public String GetCompany() {
        return this.company;
    }

    public void SetCompany(String company) {
        this.company = company;
    }

    public int GetStock() {
        return this.stock;
    }

    public void SetStock(int stock) {
        this.stock = stock;
    }

}
