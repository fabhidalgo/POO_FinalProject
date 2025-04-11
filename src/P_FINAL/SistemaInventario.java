package P_FINAL;
import java.util.Scanner;
public class SistemaInventario {
    private Inventario inventario = new Inventario();
    private ClienteManager clienteManager = new ClienteManager();
    private PedidoManager pedidoManager = new PedidoManager(inventario, clienteManager);
    private Scanner scanner = new Scanner(System.in);

    public void ejecutar() {
        boolean salir = false;
        while (!salir) {
            System.out.println("--- Admin Tienda Virtual Coca-Cola CO. ---");
            System.out.println("1. Agregar Producto");
            System.out.println("2. Ver Inventario");
            System.out.println("3. Agregar Cliente");
            System.out.println("4. Hacer Pedido");
            System.out.println("5. Ver Pedidos");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> inventario.agregarProducto();
                case 2 -> inventario.verInventario();
                case 3 -> clienteManager.agregarCliente();
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
   
    public static void main(String[] args) {
        SistemaInventario sistema = new SistemaInventario();
        sistema.ejecutar();
    }
}
