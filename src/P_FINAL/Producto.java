package P_FINAL;
public class Producto {
    private String name;
    private double precio;
    private int stock;

    public Producto(String name, double precio, int stock) {
        this.name = name;
        this.precio = precio;
        this.stock = stock; 
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String toString() {
        return " Productos: " + name + " | Precio: $" + precio + " | Stock: " + stock;
    }
}
