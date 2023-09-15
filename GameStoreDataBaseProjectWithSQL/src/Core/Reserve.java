package Core;

public class Reserve {
    private int reservationID,
            customerID,
            productID;

    public Reserve(int reservationID, int customerID, int productID) {
        this.reservationID = reservationID;
        this.customerID = customerID;
        this.productID = productID;
    }

    public int getReservationID() {
        return reservationID;
    }

    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }
    
    @Override
    public String toString()
    {
        return String.format("Reservations [ReservationID=%s, CustomerID=%s, "
                + "ProductID=%s]",reservationID,customerID,productID);
    }
}
