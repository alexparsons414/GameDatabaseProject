package Core;

public class Employees {
    private String ssn,
            address,
            city,
            state,
            zip,
            fName,
            lName,
            bDate,
            sex,
            position,
            managerSSN;
    private int salary,
            gameStoreID,
            districtID,
            corporateID;

    public Employees(String ssn, String address, String city, String state, 
            String zip, String fName, String lName, String bDate, String sex, 
            String position, String managerSSN, int gameStoreID, 
            int districtID, int corporateID, int salary) {
        this.ssn = ssn;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.fName = fName;
        this.lName = lName;
        this.bDate = bDate;
        this.sex = sex;
        this.position = position;
        this.managerSSN = managerSSN;
        this.gameStoreID = gameStoreID;
        this.districtID = districtID;
        this.corporateID = corporateID;
        this.salary = salary;
    }


    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
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

    public String getbDate() {
        return bDate;
    }

    public void setbDate(String bDate) {
        this.bDate = bDate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getManagerSSN() {
        return managerSSN;
    }

    public void setManagerSSN(String managerSSN) {
        this.managerSSN = managerSSN;
    }

    public int getGameStoreID() {
        return gameStoreID;
    }

    public void setGameStoreID(int gameStoreID) {
        this.gameStoreID = gameStoreID;
    }

    public int getDistrictID() {
        return districtID;
    }

    public void setDistrictID(int districtID) {
        this.districtID = districtID;
    }

    public int getCorporateID() {
        return corporateID;
    }

    public void setCorporateID(int corporateID) {
        this.corporateID = corporateID;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    
    @Override
    public String toString()
    {
        return String.format("Employee [SSN=%s, Address=%s, City=%s"
                + ", State=%s, Zip=%s, FName=%s, LName=%s, BDate=%s, Salary=%s, "
                + "Sex=%s, Position=%s, ManagerSSN=%s, GameStoreID=%s, "
                + "DistrictID=%s, CorporateID=%s]",ssn,address,city,state,zip
                ,fName,lName,bDate,salary,sex,position,managerSSN,gameStoreID,
                districtID,corporateID);
    }
}
