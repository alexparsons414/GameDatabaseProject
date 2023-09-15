package Core;

public class Accessory {
    private int accessoryID;
    private String accType;
    private String accConsole;
    
    public Accessory(int accessoryID, String accType, String accConsole){
        this.accessoryID = accessoryID;
        this.accType = accType;
        this.accConsole = accConsole;
    }

    public int getAccessoryID() {
        return accessoryID;
    }

    public void setAccessoryID(int accessoryID) {
        this.accessoryID = accessoryID;
    }

    public String getAccType() {
        return accType;
    }

    public void setAccType(String accType) {
        this.accType = accType;
    }

    public String getAccConsole() {
        return accConsole;
    }

    public void setAccConsole(String accConsole) {
        this.accConsole = accConsole;
    }
    
    @Override
    public String toString()
    {
        return String.format("Accessory [ProductID=%s,Type=%s,Compatable "
                + "Console(s)=%s]", accessoryID, accType, accConsole);
    }
}
