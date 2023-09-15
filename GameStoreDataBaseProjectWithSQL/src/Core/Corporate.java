package Core;

public class Corporate {
    private int cID;
    private String address,
            city,
            state,
            zip,
            phoneNo;

    public Corporate(int cID, String address, String city, String state, String zip, String phoneNo) {
        this.cID = cID;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNo = phoneNo;
    }

    public int getcID() {
        return cID;
    }

    public void setcID(int cID) {
        this.cID = cID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
    
    @Override
    public String toString()
    {
        return String.format("Corporate [ID=%s, Address=%s, City=%s"
                + ", State=%s, Zip=%s, PhoneNo=%s]",cID,address,city,state,zip
                ,phoneNo);
    }
    
}
