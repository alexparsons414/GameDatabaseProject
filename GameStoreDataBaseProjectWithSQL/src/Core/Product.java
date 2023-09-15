package Core;

public class Product {
    private int id,
            gameStoreID;
    private String name;
    private double price;
    private char isReserved;

    public Product(int id, double price, int gameStoreID, String name, char isReserved) {
        this.id = id;
        this.price = price;
        this.gameStoreID = gameStoreID;
        this.name = name;
        this.isReserved = isReserved;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getGameStoreID() {
        return gameStoreID;
    }

    public void setGameStoreID(int gameStoreID) {
        this.gameStoreID = gameStoreID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getIsReserved() {
        return isReserved;
    }

    public void setIsReserved(char isReserved) {
        this.isReserved = isReserved;
    }
    
    @Override
    public String toString()
    {
        return String.format("Product [ID=%s, Name=%s, Price=%s"
                + ", isReserved=%s, GameStoreID=%s]",id,name,price,isReserved,
                gameStoreID);
    }
}
