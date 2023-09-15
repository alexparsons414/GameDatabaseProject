package DAO;

import Core.Customers;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class CustomersDAO {
    private Connection myConn;
    
    public CustomersDAO() throws Exception{
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
    
    private Customers convertRowToCustomer(ResultSet myRS) throws SQLException{
        int id = myRS.getInt("idCUSTOMER");
        String fName = myRS.getString("fName"),
                lName = myRS.getString("lName"),
                address = myRS.getString("address"),
                city = myRS.getString("city"),
                state = myRS.getString("state"),
                zip = myRS.getString("zip"),
                phoneNo = myRS.getString("phoneNo");
        
        Customers temp = new Customers(id,fName,lName,address,city,state,zip,phoneNo);
        
        return temp;
    }
    
    public List<Customers> getAllCustomers() throws Exception{
        List<Customers> list = new ArrayList<>();
        
        Statement myStmt = null;
        ResultSet myRS = null;
        
        try{
            myStmt = myConn.createStatement();
            myRS = myStmt.executeQuery("select * from aparso9db.customers");
            
            while(myRS.next()){
                Customers temp = convertRowToCustomer(myRS);
                list.add(temp);
            }
            
            return list;
        }
        finally{
            close(myStmt,myRS);
        }
    }
    
    public void addCustomer(Customers customer) throws Exception {
	PreparedStatement myStmt = null;

	try {
		// prepare statement
		myStmt = myConn.prepareStatement("insert into aparso9db.customers"
                        + "(idCUSTOMER, fName, lName, address, city, state, zip,"
                        + " phoneNo) values (?, ?, ?, ?, ?, ?, ?, ?)");
			
		// set params
		myStmt.setInt(1, customer.getId());
                myStmt.setString(2, customer.getfName());
                myStmt.setString(3, customer.getlName());
		myStmt.setString(4, customer.getAddress());
		myStmt.setString(5, customer.getCity());
                myStmt.setString(6, customer.getState());
                myStmt.setString(7, customer.getZip());
		myStmt.setString(8, customer.getPhoneNo());
		
                // execute SQL
		myStmt.executeUpdate();			
	}
	finally {
		myStmt.close();
	}
    }
        
        public void update(Customers customer) throws Exception
        {
            PreparedStatement myStmt=null;
            try
            {
                if(customer.getfName() != null)
                {
                    myStmt=myConn.prepareStatement("update aparso9db.customers set fName = '"
                            +customer.getfName()+"' where idCUSTOMER="+customer.getId()+";");
                    myStmt.executeUpdate();
                }
                if(customer.getlName() != null)
                {
                    myStmt=myConn.prepareStatement("update aparso9db.customers set lName = '"
                            +customer.getlName()+"' where idCUSTOMER="+customer.getId()+";");
                    myStmt.executeUpdate();
                }
                if(customer.getAddress() != null)
                {
                    myStmt=myConn.prepareStatement("update aparso9db.customers set address = '"
                            +customer.getAddress()+"' where idCUSTOMER="+customer.getId()+";");
                    myStmt.executeUpdate();
                }
                if(customer.getCity() != null)
                {
                    myStmt=myConn.prepareStatement("update aparso9db.customers set city= '"
                            +customer.getCity()+"' where idCUSTOMER="+customer.getId()+";");
                    myStmt.executeUpdate();
                }
                if(customer.getState() != null){
                    myStmt=myConn.prepareStatement("update aparso9db.customers set state= '"
                            +customer.getState()+"' where idCUSTOMER="+customer.getId()+";");
                }
                if(customer.getZip() != null){
                    myStmt=myConn.prepareStatement("update aparso9db.customers set zip= '"
                            +customer.getZip()+"' where idCUSTOMER="+customer.getId()+";");
                }
                if(customer.getPhoneNo() != null){
                    myStmt=myConn.prepareStatement("update aparso9db.customers set phoneNo= '"
                            +customer.getPhoneNo()+"' where idCUSTOMER="+customer.getId()+";");
                }
            }
            finally
            {
                myStmt.close();
            }
        }
        
        public void delete(Customers customer) throws Exception{
            PreparedStatement myStmt=null;
            
            try
            {
                myStmt=myConn.prepareStatement("delete from aparso9db.customers "
                        + "where cID="+customer.getId()+";");
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
