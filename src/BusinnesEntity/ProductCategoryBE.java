package BusinnesEntity;
public class ProductCategoryBE {
    
    private String Code;
    private String Brand;
    private String Model;
    private String PartNumber;
    private String SerialNumber;
    private int PCState;

    public ProductCategoryBE() {
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
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

    public String getPartNumber() {
        return PartNumber;
    }

    public void setPartNumber(String PartNumber) {
        this.PartNumber = PartNumber;
    }

    public String getSerialNumber() {
        return SerialNumber;
    }

    public void setSerialNumber(String SerialNumber) {
        this.SerialNumber = SerialNumber;
    }

    public int getPCState() {
        return PCState;
    }

    public void setPCState(int PCState) {
        this.PCState = PCState;
    }
}
