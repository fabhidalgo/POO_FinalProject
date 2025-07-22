package DataAccesObject;
import BusinessEntity.ClientBE;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO extends SQLServerConexion 
        implements IBaseDAO<ClientBE> {

    @Override
    public boolean Create(ClientBE input) {
        boolean result = false;
        String sql = "INSERT INTO Client (ClientCode, Name, Lastname, IDType, IDNumber, RazonSocial, Telefono, Email, Direccion) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = SQLServerConexion.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)){
            
            pst.setString(1, input.getClientCode());
            pst.setString(2, input.getName());
            pst.setString(3, input.getLastname());
            pst.setString(4, input.getIDType());
            pst.setString(5, input.getIDNumber());
            pst.setString(6, input.getRazonSocial());
            pst.setString(7, input.getTelefono());
            pst.setString(8, input.getEmail());
            pst.setString(9, input.getDireccion());
            
            pst.executeUpdate();
            result = true;
        } catch (SQLException e) {
            System.out.println("Error al crear cliente: " + e.getMessage());
        }
        return result;
    }

    @Override
    public ClientBE Read(String id) {
        ClientBE client = null;
        String sql = "SELECT * FROM Client WHERE ClientCode = ?";
        try (Connection conn = SQLServerConexion.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)){
            pst.setString(1, id);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    client = new ClientBE();
                    client.setClientCode(rs.getString("ClientCode"));
                    client.setName(rs.getString("Name"));
                    client.setLastname(rs.getString("Lastname"));
                    client.setIDType(rs.getString("IDType"));
                    client.setIDNumber(rs.getString("IDNumber"));
                    client.setRazonSocial(rs.getString("RazonSocial"));
                    client.setTelefono(rs.getString("Telefono"));
                    client.setEmail(rs.getString("Email"));
                    client.setDireccion(rs.getString("Direccion"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al leer cliente: " + e.getMessage());
        }
        return client;
    }

    @Override
    public List<ClientBE> ReadAll() {
        List<ClientBE> clientList = new ArrayList<>();
        String sql = "SELECT * FROM Client";
        try (Connection conn = SQLServerConexion.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            
            while (rs.next()) {
                ClientBE client = new ClientBE();
                client.setClientCode(rs.getString("ClientCode"));
                client.setName(rs.getString("Name"));
                client.setLastname(rs.getString("Lastname"));
                client.setIDType(rs.getString("IDType"));
                client.setIDNumber(rs.getString("IDNumber"));
                client.setRazonSocial(rs.getString("RazonSocial"));
                client.setTelefono(rs.getString("Telefono"));
                client.setEmail(rs.getString("Email"));
                client.setDireccion(rs.getString("Direccion"));
                clientList.add(client);
            }
        } catch (SQLException e) {
            System.out.println("Error al leer todos los clientes: " + e.getMessage());
        }
        return clientList;
    }

    @Override
    public boolean Update(ClientBE input) {
        boolean result = false;
        String sql = "UPDATE Client SET Name = ?, Lastname = ?, IDType = ?, IDNumber = ?, RazonSocial = ?, Telefono = ?, Email = ?, Direccion = ? WHERE ClientCode = ?";
        try (Connection conn = SQLServerConexion.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setString(1, input.getName());
            pst.setString(2, input.getLastname());
            pst.setString(3, input.getIDType());
            pst.setString(4, input.getIDNumber());
            pst.setString(5, input.getRazonSocial());
            pst.setString(6, input.getTelefono());
            pst.setString(7, input.getEmail());
            pst.setString(8, input.getDireccion());
            pst.setString(9, input.getClientCode());
            
            result = pst.executeUpdate() > 0; 

        } catch (SQLException e) {
            System.out.println("Error al actualizar cliente: " + e.getMessage());
        }
        return result;
    }

    @Override
    public boolean Delete(String id) {
        boolean result = false;
        String sql = "DELETE FROM Client WHERE ClientCode = ?";
        try (Connection conn = SQLServerConexion.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setString(1, id);
            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                result = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar cliente: " + e.getMessage());
        }
        return result;
    }
}
