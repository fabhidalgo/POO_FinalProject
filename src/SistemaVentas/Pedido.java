package SistemaVentas;
import java.util.ArrayList;
public class Pedido {
    private Cliente cliente;
    private ArrayList<Producto> productos = new ArrayList<>();

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
    }

    public void agregarProducto(Producto producto, int cantidad) {
        if (producto.getStock() >= cantidad) {
            producto.reducirStock(cantidad);
            for (int i = 0; i < cantidad; i++){
                productos.add(producto);
            }
            System.out.println("Producto agregado al pedido.");
        } else {
            System.out.println("Stock insuficiente.");
        }
    }

    public String toString() {
        String resultado = "Cliente: " + cliente;
        ArrayList<Producto> productosProcesados = new ArrayList<>();
      
        for (Producto producto : productos) {
            if (!productosProcesados.contains(producto)) {
                int cantidad = 0;
                for (Producto p : productos) {
                    if (p.equals(producto)) {
                        cantidad++;
                    }
                }
                double precioUnitario = producto.getPrecio();
                double precioTotal = precioUnitario * cantidad;
                
                 resultado = resultado + " | Producto: " + producto.getName() + " | Cantidad: " + cantidad + " | Precio Unitario: " + precioUnitario + " | Precio Total: " + precioTotal;
                 
                 productosProcesados.add(producto);
            }
        }
        return resultado;
    }
}
