package DataAccesObject;
import BusinessEntity.ProductBE;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO extends SQLServerConexion
        implements IBaseDAO<ProductBE>{

    @Override
    public boolean Create(ProductBE input) {
        boolean result = false;
        String sql = "INSERT INTO Product (ProductCode, Brand, Model, SerialNumber, Description, Stock, Price) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = SQLServerConexion.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setString(1, input.getProductCode());
            pst.setString(2, input.getBrand());
            pst.setString(3, input.getModel());
            pst.setString(4, input.getSerialNumber());
            pst.setString(5, input.getDescription());
            pst.setInt(6, input.getStock());
            pst.setDouble(7, input.getPrice());
            
            pst.executeUpdate();
            result = true;
        } catch (SQLException e) {
            System.out.println("Error al crear producto: " + e.getMessage());
        }
        return result;
    }

    @Override
    public ProductBE Read(String id) {
        ProductBE product = null;
        String sql = "SELECT * FROM Product WHERE SerialNumber = ?";
        try (Connection conn = SQLServerConexion.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, id);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    product = new ProductBE();
                    product.setProductCode(rs.getString("ProductCode"));
                    product.setBrand(rs.getString("Brand"));
                    product.setModel(rs.getString("Model"));
                    product.setSerialNumber(rs.getString("SerialNumber"));
                    product.setDescription(rs.getString("Description"));
                    product.setStock(rs.getInt("Stock"));
                    product.setPrice(rs.getDouble("Price"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al leer producto: " + e.getMessage());
        }
        return product;
    }
    
    @Override
    public List<ProductBE> ReadAll() {
        List<ProductBE> productList = new ArrayList<>();
        String sql = "SELECT * FROM Product";
        try (Connection conn = SQLServerConexion.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            
            while (rs.next()) {
                ProductBE product = new ProductBE();
                product.setProductCode(rs.getString("ProductCode"));
                product.setBrand(rs.getString("Brand"));
                product.setModel(rs.getString("Model"));
                product.setSerialNumber(rs.getString("SerialNumber"));
                product.setDescription(rs.getString("Description"));
                product.setStock(rs.getInt("Stock"));
                product.setPrice(rs.getDouble("Price"));
                productList.add(product);
            }
        } catch (SQLException e) {
            System.out.println("Error al leer todos los productos: " + e.getMessage());
        }
        return productList;
    }

    @Override
    public boolean Update(ProductBE input) {
        boolean result = false;
        String sql = "UPDATE Product SET ProductCode = ?, Brand = ?, Model = ?, Description = ?, Stock = ?, Price = ? WHERE SerialNumber = ?";
        try (Connection conn = SQLServerConexion.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setString(1, input.getProductCode());
            pst.setString(2, input.getBrand());
            pst.setString(3, input.getModel());
            pst.setString(4, input.getDescription());
            pst.setInt(5, input.getStock());
            pst.setDouble(6, input.getPrice());
            pst.setString(7, input.getSerialNumber());
            
            result = pst.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar producto: " + e.getMessage());
        }
        return result;
    }

    @Override
    public boolean Delete(String id) {
        boolean result = false;
        String sql = "DELETE FROM Product WHERE SerialNumber = ?";
        try (Connection conn = SQLServerConexion.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setString(1, id);
            result = pst.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar producto: " + e.getMessage());
        }
        return result;
    }
}
