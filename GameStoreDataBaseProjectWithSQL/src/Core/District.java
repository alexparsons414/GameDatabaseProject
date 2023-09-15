package Core;

public class District {
    private int dID,
            cID;

    public District(int dID, int cID) {
        this.dID = dID;
        this.cID = cID;
    }

    public int getdID() {
        return dID;
    }

    public void setdID(int dID) {
        this.dID = dID;
    }

    public int getcID() {
        return cID;
    }

    public void setcID(int cID) {
        this.cID = cID;
    }
    
    @Override
    public String toString()
    {
        return String.format("District [DistrictID=%s, CorporateID=%s]",
                dID,cID);
    }
}
