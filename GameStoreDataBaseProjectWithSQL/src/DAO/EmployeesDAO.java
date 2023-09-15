package DAO;

import Core.Employees;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class EmployeesDAO {
    private Connection myConn;
    private DateFormat df = new SimpleDateFormat("YYYY-MM-DD");
    
    public EmployeesDAO() throws Exception{
        // get db properties
	Properties props = new Properties();
	props.load(new FileInputStream("sql/information.properties"));
		
	String user = props.getProperty("user");
	String password = props.getProperty("password");
	String dburl = props.getProperty("dburl");
		
	// connect to database
        Object newInstance;
        newInstance = Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        myConn = DriverManager.getConnection(dburl, user, password);
		
        System.out.println("DB connection successful to: " + dburl);
    }
    
    private Employees convertRowToEmployee(ResultSet myRS) throws SQLException{
        String SSN = myRS.getString("SSN"),
                address = myRS.getString("address"),
                city = myRS.getString("city"),
                state = myRS.getString("state"),
                zip = myRS.getString("zip"),
                fName = myRS.getString("fName"),
                lName = myRS.getString("lName"),
                sex = myRS.getString("sex"),
                position = myRS.getString("position"),
                managerSSN = myRS.getString("managerSSN");
        int salary = myRS.getInt("salary"),
                gameStoreID = myRS.getInt("gameStoreID"),
                districtID = myRS.getInt("districtID"),
                corporateID = myRS.getInt("corporateID");
        
        Date bD = myRS.getDate("bDate");
        
        String bDate = df.format(bD);
        
        Employees temp = new Employees(SSN,address,city,state,zip,fName,lName,
                bDate,sex,position,managerSSN,gameStoreID,districtID,
                corporateID,salary);
        
        return temp;
    }
    
    public List<Employees> getAllEmployees() throws Exception{
        List<Employees> list = new ArrayList<>();
        
        Statement myStmt = null;
        ResultSet myRS = null;
        
        try{
            myStmt = myConn.createStatement();
            myRS = myStmt.executeQuery("select * from aparso9db.employees");
            
            while(myRS.next()){
                Employees temp = convertRowToEmployee(myRS);
                list.add(temp);
            }
            
            return list;
        }
        finally{
            close(myStmt,myRS);
        }
    }
    
    public void addEmployee(Employees employee) throws Exception {
	PreparedStatement myStmt = null;

	try {
		// prepare statement
		myStmt = myConn.prepareStatement("insert into aparso9db.employees"
                        + "(SSN, address, city, state, zip, fName, lName, bDate,"
                        + " salary, sex, position, managerSSN, gameStoreID, "
                        + "districtID, corporateID) values "
                        + "(?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
                //convert to date
                if(employee.getbDate() != null){
                    Date bDate = df.parse(employee.getbDate());
                }
                
		// set params
		myStmt.setString(1, employee.getSsn());
                myStmt.setString(2, employee.getAddress());
                myStmt.setString(3, employee.getCity());
		myStmt.setString(4, employee.getState());
		myStmt.setString(5, employee.getZip());
                myStmt.setString(6, employee.getfName());
                myStmt.setString(7, employee.getlName());
                //convert to date
                if(employee.getbDate() != null){
                    Date bDate = df.parse(employee.getbDate());
                    myStmt.setDate(8, (java.sql.Date) bDate);
                }
                else{
                    myStmt.setDate(8,null);
                }
		myStmt.setInt(9, employee.getSalary());
                myStmt.setString(10, employee.getSex());
                myStmt.setString(11, employee.getPosition());
                myStmt.setString(12, employee.getManagerSSN());
                if(employee.getGameStoreID() > 0){
                    myStmt.setInt(13, employee.getGameStoreID());
                }
                else{
                    myStmt.setNull(13, java.sql.Types.INTEGER);
                }
                if(employee.getGameStoreID() > 0){
                    myStmt.setInt(14, employee.getDistrictID());
                }
                else{
                    myStmt.setNull(14, java.sql.Types.INTEGER);
                }
                if(employee.getGameStoreID() > 0){
                    myStmt.setInt(15, employee.getCorporateID());
                }
                else{
                    myStmt.setNull(15, java.sql.Types.INTEGER);
                }
		
                // execute SQL
		myStmt.executeUpdate();			
	}
	finally {
		myStmt.close();
	}
    }
        
        public void update(Employees employee) throws Exception
        {
            PreparedStatement myStmt=null;
            try
            {
                if(employee.getAddress() != null)
                {
                    myStmt=myConn.prepareStatement("update aparso9db.employees set address = '"
                            +employee.getAddress()+"' where SSN="+employee.getSsn()+";");
                    myStmt.executeUpdate();
                }
                if(employee.getCity() != null)
                {
                    myStmt=myConn.prepareStatement("update aparso9db.employees set city = '"
                            +employee.getCity()+"' where SSN="+employee.getSsn()+";");
                    myStmt.executeUpdate();
                }
                if(employee.getState() != null)
                {
                    myStmt=myConn.prepareStatement("update aparso9db.employees set state = '"
                            +employee.getState()+"' where SSN="+employee.getSsn()+";");
                    myStmt.executeUpdate();
                }
                if(employee.getZip() != null)
                {
                    myStmt=myConn.prepareStatement("update aparso9db.employees set zip= '"
                            +employee.getZip()+"' where SSN="+employee.getSsn()+";");
                    myStmt.executeUpdate();
                }
                if(employee.getfName() != null){
                    myStmt=myConn.prepareStatement("update aparso9db.employees set fName= '"
                            +employee.getfName()+"' where SSN="+employee.getSsn()+";");
                }
                if(employee.getlName() != null){
                    myStmt=myConn.prepareStatement("update aparso9db.employees set lName= '"
                            +employee.getlName()+"' where SSN="+employee.getSsn()+";");
                }
                if(employee.getbDate() != null){
                    Date bDate = df.parse(employee.getbDate());
                    myStmt=myConn.prepareStatement("update aparso9db.employees set bDate= '"
                            +bDate+"' where SSN="+employee.getSsn()+";");
                }
                if(employee.getSalary() >= 0){
                    myStmt=myConn.prepareStatement("update aparso9db.employees set salary= '"
                            +employee.getSalary()+"' where SSN="+employee.getSsn()+";");
                }
                if(employee.getSex() != null){
                    myStmt=myConn.prepareStatement("update aparso9db.employees set sex= '"
                            +employee.getSex()+"' where SSN="+employee.getSsn()+";");
                }
                if(employee.getPosition() != null){
                    myStmt=myConn.prepareStatement("update aparso9db.employees set position= '"
                            +employee.getPosition()+"' where SSN="+employee.getSsn()+";");
                }
                if(employee.getManagerSSN() != null){
                    myStmt=myConn.prepareStatement("update aparso9db.employees set managerSSN= '"
                            +employee.getManagerSSN()+"' where SSN="+employee.getSsn()+";");
                }
                if(employee.getGameStoreID() > 0){
                    myStmt=myConn.prepareStatement("update aparso9db.employees set gameStoreID= '"
                            +employee.getGameStoreID()+"' where SSN="+employee.getSsn()+";");
                }
                if(employee.getDistrictID() > 0){
                    myStmt=myConn.prepareStatement("update aparso9db.employees set districtID= '"
                            +employee.getDistrictID()+"' where SSN="+employee.getSsn()+";");
                }
                if(employee.getCorporateID() > 0){
                    myStmt=myConn.prepareStatement("update aparso9db.employees set corporateID= '"
                            +employee.getCorporateID()+"' where SSN="+employee.getSsn()+";");
                }
            }
            finally
            {
                myStmt.close();
            }
        }
        
        public void delete(Employees employee) throws Exception{
            PreparedStatement myStmt=null;
            
            try
            {
                myStmt=myConn.prepareStatement("delete from aparso9db.employees "
                        + "where SSN="+employee.getSsn()+";");
                myStmt.executeUpdate();
            }
            finally
            {
                myStmt.close();
            }
        }
    
    private static void close(Connection myConn, Statement myStmt, ResultSet myRs)
			throws SQLException {

		if (myRs != null) {
			myRs.close();
		}

		if (myStmt != null) {
			
		}
		
		if (myConn != null) {
			myConn.close();
		}
	}
    
    private void close(Statement myStmt, ResultSet myRs) throws SQLException {
		close(null, myStmt, myRs);		
	}
}
