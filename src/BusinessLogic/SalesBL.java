package BusinessLogic;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

import BusinessEntity.ClientBE;
import BusinessEntity.ProductBE;
import BusinessEntity.SalesBE;
import DataAccesObject.SalesDAO;

public class SalesBL {

    private final SalesDAO salesDAO;

    public SalesBL() {
        this.salesDAO = new SalesDAO();
    }

    private Optional<ProductBE> SearchProductByProductCode(String productCode, ProductBL productBL){
        return productBL.getProducts().stream()
                .filter(p -> p.getProductCode().equals(productCode))
                .findFirst();
    }
    
    private Optional<ClientBE> SearchClientByClientCode(String clientCode, ClientBL clientBL){
        return clientBL.getClients().stream()
                .filter(c -> c.getClientCode().equals(clientCode))
                .findFirst();
    }

    public void CreateSale(Scanner scanner, ClientBL clientBL, ProductBL productBL) {
        System.out.println("----- Crear nueva venta -----");

        System.out.print("Ingrese el codigo del cliente: ");
        String clientCode = scanner.nextLine();
        Optional<ClientBE> optionalClient = SearchClientByClientCode(clientCode, clientBL);

        if (optionalClient.isEmpty()) {
            System.out.println("No se encontro un cliente con ese codigo.");
            return;
        }
        ClientBE client = optionalClient.get();
        System.out.println("Cliente encontrado: " + client.getName() + " " + client.getLastname());
        
        List<SalesBE> currentSaleItems = new ArrayList<>();
        List<ProductBE> productsToUpdate = new ArrayList<>();
        
        System.out.println("Ingrese el numero de venta (NPV-XXXX): ");
        String saleNumber = scanner.nextLine();
        
        boolean agregar = true;
        
        while(agregar){
            System.out.print("Ingrese el codigo del producto a vender: ");
            String productCode = scanner.nextLine();
            Optional<ProductBE> optionalProduct = SearchProductByProductCode(productCode, productBL);

            if (optionalProduct.isEmpty()) {
                System.out.println("No se encontro un producto con ese codigo.");
                continue;
            }
            ProductBE product = optionalProduct.get();
            System.out.println("Producto encontrado: " + product.getBrand() + " " + product.getModel());

            try {
                System.out.print("Ingrese la cantidad a vender: ");
                int quantity = Integer.parseInt(scanner.nextLine());
            
                if (quantity <= 0|| quantity > product.getStock()) {
                    System.out.println("Cantidad inválida. Stock disponible: " + product.getStock());
                    continue;
                }

                System.out.print("Ingrese el precio de venta: ");
                double priceSale = Double.parseDouble(scanner.nextLine());
            
                if (priceSale <= 0) {
                    System.out.println("El precio de venta debe ser un mayor a cero.");
                    continue;
                }

                SalesBE saleItem = new SalesBE();
                saleItem.setSaleNumber(saleNumber);
                saleItem.setClientCode(client.getClientCode());
                saleItem.setClientName(client.getName() + " " + client.getLastname());
                saleItem.setProductCode(product.getProductCode());
                saleItem.setBrand(product.getBrand());
                saleItem.setModel(product.getModel());
                saleItem.setSerialNumber(product.getSerialNumber());
                saleItem.setPrice(product.getPrice());
                saleItem.setPriceSale(priceSale);
                saleItem.setQuantity(quantity);
                saleItem.setPriceTotal(quantity * priceSale);
                
                currentSaleItems.add(saleItem);
                product.setStock(product.getStock() - quantity);
                productsToUpdate.add(product);
                
                System.out.println("Producto agregado a la venta.");
                
                System.out.print("¿Desea agregar otro producto a esta venta? (S/N): ");
                String respuesta = scanner.nextLine();
                agregar = respuesta.equalsIgnoreCase("S");
                
            } catch (NumberFormatException e) {
                    System.out.println("Error: Debe ingresar valores numéricos válidos para cantidad y precio.");
            }
        }
        if (!currentSaleItems.isEmpty()){
            if (salesDAO.CreateSaleTransaction(currentSaleItems)){
                for (ProductBE product : productsToUpdate){
                    productBL.UpdateProductStock(product);
                }
                System.out.println("Venta registrada exitosamente");
            }else{
                System.out.println("Error al registrar la venta");
            }
        }else{
            System.out.println("Error al registrar la venta en  la base de datos.");
        }
    }      

    public void ViewAllSales() {
        System.out.println("----- Lista de ventas generadas -----");
        List<SalesBE> sales = salesDAO.ReadAll();
        if (sales.isEmpty()) {
            System.out.println("No hay ventas registradas.");
            return;
        }
        for (SalesBE sale : sales) {
            System.out.println("Numero de venta: " + sale.getSaleNumber());
            System.out.println("Cliente: [" + sale.getClientCode() + "] " + sale.getClientName());
            System.out.println("Codigo de producto: " + sale.getProductCode());
            System.out.println("Modelo: " + sale.getModel());
            System.out.println("Cantidad: " + sale.getQuantity());
            System.out.println("Precio venta: S/." + String.format("%.2f", sale.getPriceSale()));
            System.out.println("Precio total: S/." + String.format("%.2f", sale.getPriceTotal()));
            System.out.println("------------------------------------");
        }
    }

    public void UtilitiesReport() {
        System.out.println("----- Reporte de Utilidades -----");
        List<SalesBE> sales = salesDAO.ReadAll();
        if (sales.isEmpty()) {
            System.out.println("No hay ventas registradas para generar el reporte.");
            return;
        }
        for (SalesBE sale : sales) {
            double totalCost = sale.getQuantity() * sale.getPrice();
            double profit = sale.getPriceTotal() - totalCost;

            System.out.println("Numero de venta: " + sale.getSaleNumber());
            System.out.println("Cliente: [" + sale.getClientCode() + " ] " + sale.getClientName());
            System.out.println("Producto vendido: " + sale.getBrand() + " " + sale.getModel());
            System.out.println("Cantidad: " + sale.getQuantity());
            System.out.println("Costo total: S/." + String.format("%.2f", totalCost));
            System.out.println("Venta total: S/." + String.format("%.2f", sale.getPriceTotal()));
            System.out.println("Utilidad: S/." + String.format("%.2f", profit));
            System.out.println("------------------------------------");
        }
    }
}