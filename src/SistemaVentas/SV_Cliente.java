package SistemaVentas;
public class SV_Cliente {
    private String nombre;
    private String direccion;

    public SV_Cliente(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    @Override
    public String toString() {
        return nombre + " | Direccion: " + direccion;
    }
}
