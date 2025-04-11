package SistemaVentas;
public class Cliente {
    private String nombre;
    private String direccion;

    public Cliente(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public String toString() {
        return nombre + " | Dirección: " + direccion;
    }
}
