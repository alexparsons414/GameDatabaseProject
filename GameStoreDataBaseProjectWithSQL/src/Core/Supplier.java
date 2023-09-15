package Core;

public class Supplier {
    private int id;
    private String name,
            address,
            city,
            state,
            zip,
            phoneNo;

    public Supplier(int id, String name, String address, String city, 
            String state, String zip, String phoneNo) {
        this.id = id;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return String.format("Supplier [ID=%s, Name=%s, Address=%s"
                + ", City=%s, State=%s, Zip=%s, PhoneNo=%s]",id,name,address,
                city,state,zip,phoneNo);
    }
}
