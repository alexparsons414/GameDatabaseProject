package Core;

public class GameStore {
    private int id,
            districtID;
    private String address,
            city,
            state,
            zip,
            phoneNo;

    public GameStore(int id, int districtID, String address, String city, String state, String zip, String phoneNo) {
        this.id = id;
        this.districtID = districtID;
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

    public int getDistrictID() {
        return districtID;
    }

    public void setDistrictID(int districtID) {
        this.districtID = districtID;
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
        return String.format("Game Store [ID=%s, Address=%s, City=%s"
                + ", State=%s, Zip=%s, PhoneNo=%s, DistrictID=%s]",id,address,city,state,zip
                ,phoneNo,districtID);
    }
}
