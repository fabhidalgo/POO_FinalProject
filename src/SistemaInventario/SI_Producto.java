package SistemaInventario;
public class SI_Producto {
    private String item;
    private double precio;
    private int stock;

    public SI_Producto(String item, double precio, int stock) {
        this.item = item;
        this.precio = precio;
        this.stock = stock;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
        
    public void reducirStock(int cantidad) {
        this.stock -= cantidad;
    }
    
    @Override
    public String toString() {
        return " Producto: " + item + " | Precio: S/" + precio + " | Stock: " + stock;
    }
}
