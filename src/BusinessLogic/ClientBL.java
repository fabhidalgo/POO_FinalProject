package BusinessLogic;
import java.util.List;
import java.util.Scanner;
import BusinessEntity.ClientBE;
import DataAccesObject.ClientDAO;

public class ClientBL {
    private final ClientDAO clientDAO;

    public ClientBL() {
        this.clientDAO = new ClientDAO();
    }
    
    public List<ClientBE> getClients(){
        return clientDAO.ReadAll();
    }

    public void CreateClient(Scanner scanner){
        boolean continuar = true;
        
        while (continuar) {
            System.out.println("----- Creacion de nuevo cliente -----");
        
            ClientBE client = new ClientBE();
        
            System.out.println("Cree un codigo para el cliente: ");
            client.setClientCode(scanner.nextLine());
        
            System.out.println("Ingrese el nombre del cliente: ");
            client.setName(scanner.nextLine());
        
            System.out.println("Ingrese los apellidos del cliente: ");
            client.setLastname(scanner.nextLine());
        
            System.out.println("Ingrese el tipo de documento del cliente (DNI, RUC, CE, etc.): ");
            String idType = scanner.nextLine();
            client.setIDType(idType);
            
            if (idType.equalsIgnoreCase("RUC")){
                System.out.println("Ingrese la razon social del cliente: ");
                client.setRazonSocial(scanner.nextLine());
            }else{
                client.setRazonSocial(client.getName() + " " + client.getLastname());
            }

            System.out.println("Ingrese el numero de documento del cliente: ");
            String idNumber = scanner.nextLine();
            
            ClientBE existingClient = clientDAO.Read(idNumber);
            
            if (existingClient != null){
                System.out.println("Ya existe un cliente registrado con ese numero de documento, por favor ingrese otro.");
                continue;
            }
            client.setIDNumber(idNumber);
            
            System.out.println("Ingrese el telefono del cliente: ");
            client.setTelefono(scanner.nextLine());
        
            System.out.println("Ingrese el email del cliente: ");
            client.setEmail(scanner.nextLine());
        
            System.out.println("Ingrese la direccion del cliente: ");
            client.setDireccion(scanner.nextLine());
        
            if (clientDAO.Create(client)){
                System.out.println("Cliente creado exitosamente");
            } else {
                System.out.println("Error al crear el cliente.");
            }
        
            System.out.println("¿Desea registrar otro cliente? (S/N): ");
            String respuesta = scanner.nextLine();
            if (!respuesta.equalsIgnoreCase("S")){
                continuar = false;
            }
        }
    }


    public void ViewAllClients() {
        List<ClientBE> clients = clientDAO.ReadAll();
        System.out.println("----- Lista de clientes -----");
        if (clients.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }
        for (ClientBE client : clients) {
            System.out.println("Código: " + client.getClientCode());
            System.out.println("Nombre: " + client.getName() + " " + client.getLastname());
            System.out.println("Tipo Documento: " + client.getIDType());
            System.out.println("Número Documento: " + client.getIDNumber());
            System.out.println("Razón Social: " + client.getRazonSocial());
            System.out.println("Teléfono: " + client.getTelefono());
            System.out.println("Email: " + client.getEmail());
            System.out.println("Dirección: " + client.getDireccion());
            System.out.println("-----------------------------");
        }
    }
    
    public void UpdateClient(Scanner scanner) {
        System.out.println("---- Actualización de Cliente ----");
        System.out.println("Ingrese el codigo del cliente a actualizar: ");
        String clientCode = scanner.nextLine();
        
        ClientBE client = clientDAO.Read(clientCode);

        if (client == null) {
            System.out.println("No se encontro un cliente con ese codigo");
            return;
        }
        
        System.out.println("Cliente encontrado. Ingrese los datos actualizados.");
            
        System.out.print("Nuevo nombre: ");
        client.setName(scanner.nextLine());

        System.out.print("Nuevos apellidos: ");
        client.setLastname(scanner.nextLine());
        
        System.out.println("Nuevo tipo de documento");
        client.setIDType(scanner.nextLine());
        
        System.out.println("Nuevo numero de documento");
        client.setIDNumber(scanner.nextLine());
        
        if (client.getIDType().equalsIgnoreCase("RUC")) {
            System.out.print("Nueva razon social: ");
            client.setRazonSocial(scanner.nextLine());
        }

        System.out.print("Nuevo teléfono: ");
        client.setTelefono(scanner.nextLine());

        System.out.print("Nuevo email: ");
        client.setEmail(scanner.nextLine());
            
        System.out.print("Nueva direccion: ");
        client.setDireccion(scanner.nextLine());
        
        if (clientDAO.Update(client)){
            System.out.println("Cliente actualizado correctamente");
        }else{
            System.out.println("Error al actualizar el cliente");
        }
    }
    
    public void DeleteClient(Scanner scanner) {
        System.out.println("----- Eliminar cliente ----- ");
        System.out.println("Ingrese el número de cliente a eliminar: ");
        String clientCode = scanner.nextLine();
        
        if (clientDAO.Delete(clientCode)) {
            System.out.println("Cliente eliminado existosamente.");
        } else {
            System.out.println("No se encontro un cliente con ese codigo"); 
        }
    }  
}
