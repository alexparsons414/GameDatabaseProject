package Core;

public class Customers {
    private int id;
    private String fName,
            lName,
            address,
            city,
            state,
            zip,
            phoneNo;

    public Customers(int id, String fName, String lName, String address, String city, String state, String zip, String phoneNo) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNo = phoneNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
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
        return String.format("Customer [ID=%s, fName=%s, lName=%s Address=%s, "
                + "City=%s, State=%s, Zip=%s, PhoneNo=%s]",id,fName,lName,
                address,city,state,zip,phoneNo);
    }
}
