package DAO;

import Core.*;
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

public class CorporateDAO {
    private Connection myConn;
    
    public CorporateDAO() throws Exception{
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
    
    private Corporate convertRowToCorporate(ResultSet myRS) throws SQLException{
        int cID = myRS.getInt("CID");
        String address = myRS.getString("address"),
                city = myRS.getString("city"),
                state = myRS.getString("state"),
                zip = myRS.getString("zip"),
                phoneNo = myRS.getString("phoneNo");
        
        Corporate temp = new Corporate(cID,address,city,state,zip,phoneNo);
        
        return temp;
    }
    
    public List<Corporate> getAllCorporateOffices() throws Exception{
        List<Corporate> list = new ArrayList<>();
        
        Statement myStmt = null;
        ResultSet myRS = null;
        
        try{
            myStmt = myConn.createStatement();
            myRS = myStmt.executeQuery("select * from aparso9db.corporate");
            
            while(myRS.next()){
                Corporate tempCorporate = convertRowToCorporate(myRS);
                list.add(tempCorporate);
            }
            
            return list;
        }
        finally{
            close(myStmt,myRS);
        }
    }
    
    public void addCorporate(Corporate corporate) throws Exception {
	PreparedStatement myStmt = null;

	try {
		// prepare statement
		myStmt = myConn.prepareStatement("insert into aparso9db.corporate"
                        + "(CID, address, city, state, zip, phoneNo) values "
                        + "(?, ?, ?, ?, ?, ?)");
			
		// set params
		myStmt.setInt(1, corporate.getcID());
		myStmt.setString(2, corporate.getAddress());
		myStmt.setString(3, corporate.getCity());
                myStmt.setString(4, corporate.getState());
                myStmt.setString(5, corporate.getZip());
		myStmt.setString(6, corporate.getPhoneNo());
		
                // execute SQL
		myStmt.executeUpdate();			
	}
	finally {
		myStmt.close();
	}
    }
        
        public void update(Corporate corporate) throws Exception
        {
            PreparedStatement myStmt=null;
            try
            {
                if(corporate.getAddress() != null)
                {
                    myStmt=myConn.prepareStatement("update aparso9db.corporate set address = '"
                            +corporate.getAddress()+"' where cID="+corporate.getcID()+";");
                    myStmt.executeUpdate();
                }
                if(corporate.getCity() != null)
                {
                    myStmt=myConn.prepareStatement("update aparso9db.corporate set city= '"
                            +corporate.getCity()+"' where CID="+corporate.getcID()+";");
                    myStmt.executeUpdate();
                }
                if(corporate.getState() != null){
                    myStmt=myConn.prepareStatement("update aparso9db.corporate set state= '"
                            +corporate.getState()+"' where cID="+corporate.getcID()+";");
                }
                if(corporate.getZip() != null){
                    myStmt=myConn.prepareStatement("update aparso9db.corporate set zip= '"
                            +corporate.getZip()+"' where cID="+corporate.getcID()+";");
                }
                if(corporate.getPhoneNo() != null){
                    myStmt=myConn.prepareStatement("update aparso9db.corporate set phoneNo= '"
                            +corporate.getPhoneNo()+"' where cID="+corporate.getcID()+";");
                }
            }
            finally
            {
                myStmt.close();
            }
        }
        
        public void delete(Corporate corporate) throws Exception{
            PreparedStatement myStmt=null;
            
            try
            {
                myStmt=myConn.prepareStatement("delete from aparso9db.corporate "
                        + "where cID="+corporate.getcID()+";");
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
