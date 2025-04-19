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
            System.out.println("----- Bienvenido al Sistema de Inventario -----");
            System.out.println("1. Agregar Productos");
            System.out.println("2. Ver Inventario");
            System.out.println("3. Agregar Clientes");
            System.out.println("4. Seguir al Sistema de Ventas");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> inventario.agregarProducto();
                case 2 -> inventario.verInventario();
                case 3 -> cliente.agregarCliente();
                case 4 -> ejecutarSV();
                case 5 -> {
                    salir = true;
                    System.out.println("¡Gracias por usar el sistema! Hasta pronto.");
                }
                default -> System.out.println("Opción inválida.");
            }
        }
    }

    private void ejecutarSV() {
        boolean salirSV = false;
        while (!salirSV) {
            System.out.println("----- Bienvenido al Sistema de Ventas -----");
            System.out.println("1. Realizar Pedido");
            System.out.println("2. Ver Pedidos");
            System.out.println("3. Ver Stock");
            System.out.println("4. Regresar al Sistema de Inventario");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int opcionSV = scanner.nextInt();
            scanner.nextLine();

            switch (opcionSV) {
                case 1 -> pedidoManager.hacerPedido();
                case 2 -> pedidoManager.verPedidos();
                case 3 -> inventario.verInventario();
                case 4 -> salirSV = true;
                case 5 -> {
                    System.out.println("¡Gracias por usar el sistema! Hasta pronto.");
                    System.exit(0);
                }
                default -> System.out.println("Opción inválida.");
            }
        }
    }
}