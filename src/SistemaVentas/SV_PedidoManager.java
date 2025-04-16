package SistemaVentas;
import SistemaInventario.SI_Cliente;
import SistemaInventario.SI_Inventario;
import SistemaInventario.SI_Producto;
import java.util.ArrayList;
import java.util.Scanner;

public class SV_PedidoManager {
    private SI_Inventario inventario;
    private SI_Cliente siCliente;
    private ArrayList<SV_Pedido> pedidos = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public SV_PedidoManager(SI_Inventario inventario, SI_Cliente cliente) {
        this.inventario = inventario;
        this.siCliente = cliente;
    }

    public void hacerPedido() {
        System.out.print("Ingrese nombre del cliente: ");
        String nombreCliente = scanner.nextLine();
        SV_Cliente clienteEncontrado = siCliente.buscarCliente(nombreCliente);

        if (clienteEncontrado == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        SV_Pedido pedido = new SV_Pedido(clienteEncontrado);

        boolean agregarOtro = true;
        while (agregarOtro) {
            System.out.print("Ingrese el nombre del producto: ");
            String nombreProducto = scanner.nextLine();
            
            SI_Producto producto = inventario.buscarProducto(nombreProducto);

            if (producto != null) {
                System.out.print("Ingrese cantidad: ");
                int cantidad = scanner.nextInt();
                scanner.nextLine();
                pedido.agregarProducto(producto, cantidad);
            } else {
                System.out.println("Producto no encontrado.");
        }

        System.out.print("¿Desea agregar otro producto al pedido? (s/n): ");
        String respuesta = scanner.nextLine();
        agregarOtro = respuesta.equalsIgnoreCase("s");
    }
        pedidos.add(pedido);
        System.out.println("Pedido creado.");
    }

    public void verPedidos() {
        if (pedidos.isEmpty()) {
            System.out.println("No se ha creado ningún pedido.");
        } else {
            System.out.println("--- Pedido(s) creado(s) ---");
            for (SV_Pedido pedido : pedidos) {
                System.out.println(pedido);
                scanner.nextLine();
            }
        }
    }
}