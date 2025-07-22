package BusinessLogic;
import java.util.List;
import java.util.Scanner;
import BusinessEntity.ProductBE;
import DataAccesObject.ProductDAO;

public class ProductBL {
    private final ProductDAO productDAO;

    public ProductBL() {
        this.productDAO = new ProductDAO();
    }
    
    public List<ProductBE> getProducts(){
        return productDAO.ReadAll();
    }
    
    public void CreateProduct(Scanner scanner){
        boolean continuar = true;
        
        while (continuar) {
            System.out.println("----- Ingreso de productos -----");
        
            ProductBE product = new ProductBE();
        
            System.out.println("Cree un codigo para el producto: ");
            product.setProductCode(scanner.nextLine());
        
            System.out.println("Ingrese la marca del producto: ");
            product.setBrand(scanner.nextLine());
        
            System.out.println("Ingrese el modelo del producto: ");
            product.setModel(scanner.nextLine());
        
            System.out.println("Ingrese el numero de serie del producto: ");
            String serialNumber = scanner.nextLine();
            
            ProductBE existingProduct = productDAO.Read(serialNumber);
        
            if (existingProduct != null){
                System.out.println("Ya existe un producto registrado con ese numero de serie, por favor ingrese otro.");
                continue;
            }
            product.setSerialNumber(serialNumber);

            System.out.println("Ingrese una descripcion para el producto: ");
            product.setDescription(scanner.nextLine());
            try{
                System.out.println("Ingrese la cantidad de productos: ");
                product.setStock(Integer.parseInt(scanner.nextLine()));
        
                System.out.println("Ingrese el precio del producto: ");
                product.setPrice(Double.parseDouble(scanner.nextLine()));
                
            }catch (NumberFormatException e){
                System.out.println("Error: debe ingresar valores numericos validos para cantidad y precio");
                continue;
            }
                
            if (productDAO.Create(product)){
                System.out.println("Producto creado exitosamente");
            }else{
                System.out.println("Error al crear el producto");
            }
            
            System.out.println("¿Desea registrar otro producto? (S/N): ");
            String respuesta = scanner.nextLine();
            if (!respuesta.equalsIgnoreCase("S")){
                continuar = false;
            }
        }
    }

    public void ViewAllProducts() {
        List<ProductBE> products = productDAO.ReadAll();
        System.out.println("----- Lista de productos -----");
        if (products.isEmpty()) {
            System.out.println("No hay productos registrados.");
            return;
        }
        for (ProductBE product : products) {
            System.out.println("Código: " + product.getProductCode());
            System.out.println("Marca: " + product.getBrand());
            System.out.println("Modelo: " + product.getModel());
            System.out.println("Número de Serie: " + product.getSerialNumber());
            System.out.println("Descripción: " + product.getDescription());
            System.out.println("Stock: " + product.getStock());
            System.out.println("Precio: " + product.getPrice());
            System.out.println("-----------------------------");
        }
    }
    
    public void UpdateProduct(Scanner scanner) {
        System.out.println("----- Actualizar producto -----");
        System.out.print("Ingrese el numero de serie del producto a actualizar: ");
        
        String serial = scanner.nextLine();
        ProductBE product = productDAO.Read(serial);

        if (product == null) {
            System.out.println("No se encontro un producto con ese numero de serie");
            return;
        }

        System.out.println("Producto encontrado. Ingrese los datos actualizados.");
        
        System.out.println("Nuevo codigo de producto: ");
        product.setProductCode(scanner.nextLine());

        System.out.print("Nueva marca: ");
        product.setBrand(scanner.nextLine());

        System.out.print("Nuevo modelo: ");
        product.setModel(scanner.nextLine());

        System.out.print("Nueva descripción: ");
        product.setDescription(scanner.nextLine());
        
        try{
            System.out.print("Nueva cantidad: ");
            product.setStock(Integer.parseInt(scanner.nextLine()));

            System.out.print("Nuevo precio: ");
            product.setPrice(Double.parseDouble(scanner.nextLine()));
            
            if (productDAO.Update(product)) {
                System.out.println("Producto actualizado correctamente.");
            } else {
                System.out.println("Error al actualizar el producto.");
            }            
        }catch (NumberFormatException e){
            System.out.println("Error: debe ingresar valores numericos validos para cantidad y precio");
        }
    }
    
    public void UpdateProductStock(ProductBE product) {
        if (productDAO.Update(product)) {
        } else {
            System.out.println("Error al actualizar el stock del producto '" + product.getBrand() + " " + product.getModel() + "'.");
        }
    }

    public void DeleteProduct(Scanner scanner) {
        System.out.println("----- Eliminar producto -----");
        System.out.print("Ingrese el número de serie del producto a eliminar: ");
        String serial = scanner.nextLine();

        if (productDAO.Delete(serial)) {
            System.out.println("Producto eliminado exitosamente.");
        } else {
            System.out.println("No se encontró un producto con ese número de serie.");
        }
    }
}
