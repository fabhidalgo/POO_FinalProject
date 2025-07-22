package BusinessEntity;

public class SalesBE{

    private double Price;
    private double PriceSale;
    private double PriceTotal;
    private int Quantity;

    private String SaleNumber;
    private String ClientCode;
    private String ClientName;
    private String ProductCode;
    private String Brand;
    private String Model;
    private String SerialNumber;

    public SalesBE() {
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public double getPriceSale() {
        return PriceSale;
    }

    public void setPriceSale(double PriceSale) {
        this.PriceSale = PriceSale;
    }

    public double getPriceTotal() {
        return PriceTotal;
    }

    public void setPriceTotal(double PriceTotal) {
        this.PriceTotal = PriceTotal;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public String getSaleNumber() {
        return SaleNumber;
    }

    public void setSaleNumber(String SaleNumber) {
        this.SaleNumber = SaleNumber;
    }

    public String getClientCode() {
        return ClientCode;
    }

    public void setClientCode(String ClientCode) {
        this.ClientCode = ClientCode;
    }

    public String getClientName() {
        return ClientName;
    }

    public void setClientName(String ClientName) {
        this.ClientName = ClientName;
    }

    public String getProductCode() {
        return ProductCode;
    }

    public void setProductCode(String ProductCode) {
        this.ProductCode = ProductCode;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String Brand) {
        this.Brand = Brand;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String Model) {
        this.Model = Model;
    }

    public String getSerialNumber() {
        return SerialNumber;
    }

    public void setSerialNumber(String SerialNumber) {
        this.SerialNumber = SerialNumber;
    }
}
