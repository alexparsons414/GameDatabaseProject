package Core;

public class Has {
    private int gameStoreID,
            customerID;

    public Has(int gameStoreID, int customerID) {
        this.gameStoreID = gameStoreID;
        this.customerID = customerID;
    }

    public int getGameStoreID() {
        return gameStoreID;
    }

    public void setGameStoreID(int gameStoreID) {
        this.gameStoreID = gameStoreID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }
    
    @Override
    public String toString()
    {
        return String.format("Customer Store Relations [GameStoreID=%s, CustomerID=%s]",
                gameStoreID,customerID);
    }
}
