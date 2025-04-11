package SistemaVentas;
import SistemaInventario.SI_Cliente;
import SistemaInventario.SI_Inventario;
import SistemaInventario.SI_Producto;
import java.util.ArrayList;
import java.util.Scanner;
public class PedidoManager {
    private SI_Inventario inventario;
    private SI_Cliente cliente;
    private ArrayList<Pedido> pedidos = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public PedidoManager(SI_Inventario inventario, ClienteManager clienteManager) {
        this.inventario = inventario;
        this.cliente = clientesv;
    }

    PedidoManager(SI_Inventario inventario, SI_Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void hacerPedido() {
        System.out.print("Ingrese nombre del cliente: ");
        String nombreSV_Cliente = scanner.nextLine();
        SV_Cliente clientesv = SI_Cliente.buscarCliente(nombreSV_Cliente);

        if (clientesv == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        Pedido pedido = new Pedido(clientesv);

        while (true) {
            System.out.print("Ingrese nombre del producto (o 'fin' para terminar): ");
            String nombreProducto = scanner.nextLine();
            if (nombreProducto.equalsIgnoreCase("fin")) break;

            SI_Producto producto = inventario.buscarProducto(nombreProducto);

            if (producto != null) {
                System.out.print("Ingrese cantidad: ");
                int cantidad = scanner.nextInt();
                scanner.nextLine();
                pedido.agregarProducto(producto, cantidad);
            } else {
                System.out.println("Pedido no encontrado.");
            }
        }
        pedidos.add(pedido);
        System.out.println("Pedido creado.");
    }

    public void verPedidos() {
        if (pedidos.isEmpty()) {
            System.out.println("Pedido no creado.");
        } else {
            for (Pedido pedido : pedidos) {
                System.out.println(pedido);
            }
        }
    }
}
