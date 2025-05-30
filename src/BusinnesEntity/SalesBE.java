package BusinnesEntity;

public class SalesBE extends ProductBE{
    
    private double PriceCost;
    private double PriceSale;
    private double PriceTotal;
    private int Quantity;

    public SalesBE() {
    }

    public double getPriceCost() {
        return PriceCost;
    }

    public void setPriceCost(double PriceCost) {
        this.PriceCost = PriceCost;
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
    
    
}
