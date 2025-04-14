package SistemaVentas;
import SistemaInventario.SI_Cliente;
import SistemaInventario.SI_Inventario;
import java.util.Scanner;

public class Console {
    private SI_Inventario inventario = new SI_Inventario();
    private SI_Cliente cliente = new SI_Cliente();
    private SV_PedidoManager pedidoManager = new SV_PedidoManager(inventario, cliente);
    private Scanner scanner = new Scanner(System.in);

    public void ejecutar() {
        boolean salir = false;
        while (!salir) {
            System.out.println("----- Bienvenido al Sistema -----");
            System.out.println("1. Agregar Productos");
            System.out.println("2. Ver Inventario");
            System.out.println("3. Agregar Clientes");
            System.out.println("4. Hacer Pedido");
            System.out.println("5. Ver Pedidos");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> inventario.agregarProducto();
                case 2 -> inventario.verInventario();
                case 3 -> cliente.agregarCliente();
                case 4 -> pedidoManager.hacerPedido();
                case 5 -> pedidoManager.verPedidos();
                case 6 -> {
                    salir = true;
                    System.out.println("¡Gracias por usar el sistema! Hasta pronto. ");
                }
                default -> System.out.println("Opción inválida.");
            }
        }
    }
}
