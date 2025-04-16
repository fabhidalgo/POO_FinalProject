package SistemaVentas;
import SistemaInventario.SI_Producto;
import java.util.ArrayList;
public class SV_Pedido {
    private SV_Cliente cliente;
    private ArrayList<SI_Producto> productos = new ArrayList<>();

    public SV_Pedido(SV_Cliente cliente) {
        this.cliente = cliente;
    }

    public void agregarProducto(SI_Producto producto, int cantidad) {
        if (producto.getStock() >= cantidad) {
            producto.reducirStock(cantidad);
            for (int i = 0; i < cantidad; i++){
                productos.add(producto);
            }
            System.out.println("Producto(s) agregado(s) al pedido.");
        } else {
            System.out.println("Stock insuficiente.");
        }
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        String resultado = "Cliente: " + cliente;
        ArrayList<SI_Producto> productosProcesados = new ArrayList<>();
      
        for (SI_Producto producto : productos) {
            if (!productosProcesados.contains(producto)) {
                int cantidad = 0;
                for (SI_Producto p : productos) {
                    if (p.equals(producto)) {
                        cantidad++;
                    }
                }
                double precioUnitario = producto.getPrecio();
                double precioTotal = precioUnitario * cantidad;
                String product = producto.getItem();
                int stock = producto.getStock();
                
                 resultado = resultado + " | Producto: " + product + " | Cantidad: " + cantidad + " | Precio Unitario: " + precioUnitario + " | Precio Total: " + precioTotal+ " | Stock: " + stock;
                 
                 productosProcesados.add(producto);
            }
        }
        return resultado;
    }
}
