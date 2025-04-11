package SistemaVentas;
import java.util.ArrayList;
import java.util.Scanner;
public class ClienteManager {
    private ArrayList<SV_Cliente> clientes = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void agregarCliente() {
        System.out.print("Ingrese nombre del cliente: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese dirección del cliente: ");
        String direccion = scanner.nextLine();

        SV_Cliente cliente = new SV_Cliente(nombre, direccion);
        clientes.add(cliente);
        System.out.println("Cliente agregado.");
    }

    public SV_Cliente buscarCliente(String nombre) {
        for (SV_Cliente cliente : clientes) {
            if (cliente.toString().contains(nombre)) {
                return cliente;
            }
        }
        return null;
    }
}
