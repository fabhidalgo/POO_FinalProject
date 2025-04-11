package SistemaVentas;
import java.util.ArrayList;
import java.util.Scanner;
public class PedidoManager {
    private Inventario inventario;
    private ClienteManager clienteManager;
    private ArrayList<Pedido> pedidos = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public PedidoManager(Inventario inventario, ClienteManager clienteManager) {
        this.inventario = inventario;
        this.clienteManager = clienteManager;
    }

    public void hacerPedido() {
        System.out.print("Ingrese nombre del cliente: ");
        String nombreCliente = scanner.nextLine();
        Cliente cliente = clienteManager.buscarCliente(nombreCliente);

        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        Pedido pedido = new Pedido(cliente);

        while (true) {
            System.out.print("Ingrese nombre del producto (o 'fin' para terminar): ");
            String nombreProducto = scanner.nextLine();
            if (nombreProducto.equalsIgnoreCase("fin")) break;

            Producto producto = inventario.buscarProducto(nombreProducto);

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
