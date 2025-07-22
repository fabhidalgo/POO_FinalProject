package DataAccesObject;
import BusinessEntity.SalesBE;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SalesDAO extends SQLServerConexion 
        implements IBaseDAO<SalesBE>{

    @Override
    public boolean Create(SalesBE input) {
        boolean result = false;
        String sql = "INSERT INTO Sales (SaleNumber, ClientCode, ClientName, ProductCode, Brand, Model, SerialNumber, Price, PriceSale, Quantity, PriceTotal) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = SQLServerConexion.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)){
            
            pst.setString(1, input.getSaleNumber());
            pst.setString(2, input.getClientCode());
            pst.setString(3, input.getClientName());
            pst.setString(4, input.getProductCode());
            pst.setString(5, input.getBrand());
            pst.setString(6, input.getModel());
            pst.setString(7, input.getSerialNumber());
            pst.setDouble(8, input.getPrice());
            pst.setDouble(9, input.getPriceSale());
            pst.setInt(10, input.getQuantity());
            pst.setDouble(11, input.getPriceTotal());
            
            pst.executeUpdate();
            result = true;
        } catch (SQLException e) {
            System.out.println("Error al crear la venta: " + e.getMessage());
        }
        return result;
    }
    
    public boolean CreateSaleTransaction(List<SalesBE> salesList) {
        if (salesList.isEmpty()) {
            return false;
        }
        boolean success = false;
        String sql = "INSERT INTO Sales (SaleNumber, ClientCode, ClientName, ProductCode, Brand, Model, SerialNumber, Price, PriceSale, Quantity, PriceTotal) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        try {
            conn = SQLServerConexion.getConnection();
            conn.setAutoCommit(false);
            
            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                for (SalesBE sale : salesList) {
                    pst.setString(1, sale.getSaleNumber());
                    pst.setString(2, sale.getClientCode());
                    pst.setString(3, sale.getClientName());
                    pst.setString(4, sale.getProductCode());
                    pst.setString(5, sale.getBrand());
                    pst.setString(6, sale.getModel());
                    pst.setString(7, sale.getSerialNumber());
                    pst.setDouble(8, sale.getPrice());
                    pst.setDouble(9, sale.getPriceSale());
                    pst.setInt(10, sale.getQuantity());
                    pst.setDouble(11, sale.getPriceTotal());
                    pst.addBatch();
                }
                pst.executeBatch();
            }
            conn.commit();
            success = true;
        } catch (SQLException e) {
            System.out.println("Error en la transaccion de venta: " + e.getMessage());
            if (conn != null) {
                try {
                    System.out.println("Rollback de la transaccion.");
                    conn.rollback();
                } catch (SQLException ex) {
                    System.out.println("Error al realizar rollback: " + ex.getMessage());
                }
            }
        } finally {
            if (conn != null) {
                try {
                    conn.setAutoCommit(true);
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Error al cerrar la conexion: " + e.getMessage());
                }
            }
        }
        return success;
    }

    @Override
    public List<SalesBE> ReadAll() {
        List<SalesBE> salesList = new ArrayList<>();
        String sql = "SELECT * FROM Sales";
        try (Connection conn = SQLServerConexion.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            
            while (rs.next()) {
                SalesBE sale = new SalesBE();
                sale.setSaleNumber(rs.getString("SaleNumber"));
                sale.setClientCode(rs.getString("ClientCode"));
                sale.setClientName(rs.getString("ClientName"));
                sale.setProductCode(rs.getString("ProductCode"));
                sale.setBrand(rs.getString("Brand"));
                sale.setModel(rs.getString("Model"));
                sale.setSerialNumber(rs.getString("SerialNumber"));
                sale.setPrice(rs.getDouble("Price"));
                sale.setPriceSale(rs.getDouble("PriceSale"));
                sale.setQuantity(rs.getInt("Quantity"));
                sale.setPriceTotal(rs.getDouble("PriceTotal"));
                salesList.add(sale);
            }
        } catch (SQLException e) {
            System.out.println("Error al leer todas las ventas: " + e.getMessage());
        }
        return salesList;
    }

    @Override
    public SalesBE Read(String id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean Update(SalesBE input) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean Delete(String id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
