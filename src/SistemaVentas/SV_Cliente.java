package SistemaVentas;
public class SV_Cliente {
    private String nombre;
    private String direccion;

    public SV_Cliente(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return nombre + " | Direccion=" + direccion;
    }
}
