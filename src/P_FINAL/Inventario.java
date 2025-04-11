package P_FINAL;
import java.util.ArrayList;
import java.util.Scanner;
public class Inventario {
    private ArrayList<Producto> productos = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void agregarProducto() {
        boolean continuar = true;
        while (continuar) {
            System.out.print("Ingrese nombre del producto: ");
            String name = scanner.nextLine();
            System.out.print("Ingrese precio del producto: ");
            double precio = scanner.nextDouble();
            System.out.print("Ingrese stock del producto: ");
            int stock = scanner.nextInt();
            scanner.nextLine();
            
            Producto producto = new Producto(name, precio, stock);
            productos.add(producto);
            System.out.println("Producto agregado al inventario.");
            
            System.out.print("¿Desea agregar otro producto? (s/n): ");
            String respuesta = scanner.nextLine();
            if (!respuesta.equalsIgnoreCase("s")) {
                continuar = false;
            }
        }
    }

    public void verInventario() {
        if (productos.isEmpty()) {
            System.out.println("El inventario está vacío.");
        } else {
            System.out.println("--- Inventario de productos ---");
            for (Producto producto : productos) {
                System.out.println(producto.toString());
            }
        }
    }

    public Producto buscarProducto(String name) {
        for (Producto producto : productos) {
            if (producto.getName().equalsIgnoreCase(name)) {
                return producto;
            }
        }
        return null;
    } 
}
