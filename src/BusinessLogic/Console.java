package BusinessLogic;
import BusinessEntity.AdminBE;
import java.util.Scanner;

public class Console {
    
    private final Scanner scanner = new Scanner(System.in);
    private final AdminBE admin = new AdminBE();
    
    private final ClientBL clientBL = new ClientBL();
    private final ProductBL productBL = new ProductBL();
    private final SalesBL salesBL = new SalesBL();
    
    
    private int leerOpcion(int min, int max){
        while (true) {
            try {
                int opcion = Integer.parseInt(scanner.nextLine());
                if (opcion >= min && opcion <= max) {
                    return opcion;
                } else {
                    System.out.println("Opción fuera de rango. Intente nuevamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
            }
        }
    }
    

    public void IniciarPrograma(){
       
        System.out.println("----- Bienvenindo al Sistema -----");
        
        while(true){
            System.out.println("Ingrese el nombre de usuario");
            String user = scanner.nextLine();
        
            System.out.println("Ingrese la contraseña");
            String pass = scanner.nextLine();
        
            if (user.equals(admin.getUsername())&& pass.equals(admin.getPassword())){
                System.out.println("¡Acceso concedido!");
                MainMenu();
                break;
            } else {
                System.out.println("Credenciales incorrectas. Intente nuevamente");
            }
        }
    }
    
    
    public void MainMenu(){
        boolean salir = false;
        
        while (!salir) {
            System.out.println("----- Menu de opciones del Sistema -----");
            System.out.println("1. Clientes");
            System.out.println("2. Productos");
            System.out.println("3. Ventas");
            System.out.println("4. Inventario");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = leerOpcion(1,5);

            switch(opcion){
                case 1 -> ClientMenu();
                case 2 -> ProductMenu();
                case 3 -> SalesMenu();
                case 4 -> InventoryMenu();
                case 5 ->{
                    System.out.println("Saliendo del Sistema...");
                    salir = true;
                }
            }
        }  
    } 
    
    
    public void ClientMenu(){
        boolean salir = false;
        
        while (!salir) {
            System.out.println("----- Menu de clientes -----");
            System.out.println("1. Crear cliente nuevo");
            System.out.println("2. Ver el listado de clientes");
            System.out.println("3. Actualizar datos");
            System.out.println("4. Eliminar cliente");
            System.out.println("5. Regresar al menu principal");
            System.out.print("Seleccione una opción: ");
            
            int opcion = leerOpcion(1,5);

            switch(opcion){
                case 1 -> clientBL.CreateClient(scanner);
                case 2 -> clientBL.ViewAllClients();
                case 3 -> clientBL.UpdateClient(scanner);
                case 4 -> clientBL.DeleteClient(scanner);
                case 5 -> salir = true;
            }
        }
    }
    
    
    public void ProductMenu(){
        boolean salir = false;
        
        while (!salir) {
            System.out.println("----- Menu de productos -----");
            System.out.println("1. Agregar producto nuevo");
            System.out.println("2. Actualizar datos del producto");
            System.out.println("3. Eliminar producto");
            System.out.println("4. Regresar al menu principal");
            System.out.print("Seleccione una opción: ");
            
            int opcion = leerOpcion(1,4);

            switch(opcion){
                case 1 -> productBL.CreateProduct(scanner);
                case 2 -> productBL.UpdateProduct(scanner);
                case 3 -> productBL.DeleteProduct(scanner);
                case 4 -> salir = true;
            }
        }
    }
    
    
    public void SalesMenu(){
        boolean salir = false;
        
        while (!salir) {
            System.out.println("----- Menu de ventas -----");
            System.out.println("1. Crear nueva venta");
            System.out.println("2. Ver las ventas generadas");
            System.out.println("3. Reporte de utilidades");
            System.out.println("4. Regresar al menu principal");
            System.out.print("Seleccione una opción: ");
            
            int opcion = leerOpcion(1,4);

            switch(opcion){
                case 1 -> salesBL.CreateSale(scanner, clientBL, productBL);
                case 2 -> salesBL.ViewAllSales();
                case 3 -> salesBL.UtilitiesReport();
                case 4 ->{
                    System.out.println("Regresando al menu principal...");
                    salir = true;
                }
            }
        }
    }
    
    
    public void InventoryMenu(){
        boolean salir = false;
        
        while (!salir) {
            System.out.println("----- Menu del inventario -----");
            System.out.println("1. Ver inventario");
            System.out.println("2. Modificar Stock");
            System.out.println("3. Regresar al menu principal");
            System.out.print("Seleccione una opción: ");
            
            int opcion = leerOpcion(1,3);

            switch(opcion){
                case 1 -> productBL.ViewAllProducts();
                case 2 -> productBL.UpdateProduct(scanner);
                case 3 ->{
                    System.out.println("Regresando al menu principal...");
                    salir = true;
                }
            }
        }
    }
}

