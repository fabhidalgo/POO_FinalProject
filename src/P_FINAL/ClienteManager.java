package P_FINAL;
import java.util.ArrayList;
import java.util.Scanner;
public class ClienteManager {
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void agregarCliente() {
        System.out.print("Ingrese nombre del cliente: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese dirección del cliente: ");
        String direccion = scanner.nextLine();

        Cliente cliente = new Cliente(nombre, direccion);
        clientes.add(cliente);
        System.out.println("Cliente agregado.");
    }

    public Cliente buscarCliente(String nombre) {
        for (Cliente cliente : clientes) {
            if (cliente.toString().contains(nombre)) {
                return cliente;
            }
        }
        return null;
    }
}
