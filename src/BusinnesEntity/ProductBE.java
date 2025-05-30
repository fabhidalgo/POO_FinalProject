package BusinnesEntity;
public class ProductBE extends ProductCategoryBE {
    
    private String Description;
    private int Stock;
    private int ProductState;

    public ProductBE() {
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

    public int getProductState() {
        return ProductState;
    }

    public void setProductState(int ProductState) {
        this.ProductState = ProductState;
    }

    
}

