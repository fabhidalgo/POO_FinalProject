package SistemaInventario;
import java.util.ArrayList;
import java.util.Scanner;
public class SI_Inventario {
    private ArrayList<SI_Producto> productos = new ArrayList<>();
    private Scanner scanner = new Scanner (System.in);
    
    public void agregarProducto() {
        boolean continuar = true;
        while (continuar) {
            System.out.print("Ingrese el nombre del producto: ");
            String item = scanner.nextLine();
            System.out.print("Ingrese el precio del producto");
            double precio = scanner.nextDouble();
            System.out.print("Ingrese el stcok del producto: ");
            int stock = scanner.nextInt();
            scanner.nextLine();
            
            SI_Producto producto = new SI_Producto(item, precio, stock);
            productos.add(producto);
            System.out.println("Producto agregado al inventario.");
            
            System.out.print("¿Desea agregar otro producto? (s/n): ");
            String respuesta = scanner.nextLine();
            if (!respuesta.equalsIgnoreCase("s")){
                continuar = false;
            } 
        }
    }
    
    public void verInventario(){
        if (productos.isEmpty()){
            System.out.println("El inventario está vacio.");
        } else {
            System.out.println("--- Inventario de productos ---");
            for (SI_Producto producto : productos){
                System.out.println(producto.toString());              
            }
        }
    }
    
    public SI_Producto buscarProducto(String name){
        for (SI_Producto producto : productos){
            if (producto.getItem().equalsIgnoreCase(name)){
                return producto;
            }
        }
        return null;
    }

}
