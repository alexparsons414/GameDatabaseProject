package Core;

public class Supplies {
    private int productID,
            supplierID;

    public Supplies(int productID, int supplierID) {
        this.productID = productID;
        this.supplierID = supplierID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }
    
    @Override
    public String toString()
    {
        return String.format("Product Supplier Relations [ProductID=%s, "
                + "SupplierID=%s]",productID,supplierID);
    }
}
