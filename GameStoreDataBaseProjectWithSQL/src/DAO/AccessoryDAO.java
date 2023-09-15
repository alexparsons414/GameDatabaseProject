package DAO;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import Core.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class AccessoryDAO {
    private Connection myConn;
    
    public AccessoryDAO() throws Exception{
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
    
    private Accessory convertRowToAccessory(ResultSet myRS) throws SQLException{
        int accessoryID = myRS.getInt("idACCESSORY");
        String type = myRS.getString("type"),
                console = myRS.getString("console");
        
        Accessory tempAccessory = new Accessory(accessoryID,type,console);
        
        return tempAccessory;
    }
    
    public List<Accessory> getAllAccessories() throws Exception{
        List<Accessory> list = new ArrayList<>();
        
        Statement myStmt = null;
        ResultSet myRS = null;
        
        try{
            myStmt = myConn.createStatement();
            myRS = myStmt.executeQuery("select * from aparso9db.accessory");
            
            while(myRS.next()){
                Accessory tempAccessory = convertRowToAccessory(myRS);
                list.add(tempAccessory);
            }
            
            return list;
        }
        finally{
            close(myStmt,myRS);
        }
    }
    
    public void addAccessory(Accessory accessory) throws Exception {
	PreparedStatement myStmt = null;

	try {
		// prepare statement
		myStmt = myConn.prepareStatement("insert into aparso9db.accessory"
                        + "(idACCESSORY, type, console) values (?, ?, ?)");
			
		// set params
		myStmt.setInt(1, accessory.getAccessoryID());
		myStmt.setString(2, accessory.getAccType());
		myStmt.setString(3, accessory.getAccConsole());
			
		// execute SQL
		myStmt.executeUpdate();			
	}
	finally {
		myStmt.close();
	}
    }
        
        public void update(Accessory accessory) throws Exception{
            PreparedStatement myStmt=null;
            try
            {
                if(accessory.getAccType() != null)
                {
                    myStmt=myConn.prepareStatement("update aparso9db.accessory set type = '"
                            +accessory.getAccType()+"' where idACCESSORY="+accessory.getAccessoryID()+";");
                    myStmt.executeUpdate();
                }
                if(accessory.getAccConsole()!=null)
                {
                    myStmt=myConn.prepareStatement("update aparso9db.accessory set  console= '"
                            +accessory.getAccConsole()+"' where idACCESSORY="+accessory.getAccessoryID()+";");
                    myStmt.executeUpdate();
                }
            }
            finally
            {
                myStmt.close();
            }
        }
        
        public void delete(Accessory accessory) throws Exception
        {
            PreparedStatement myStmt=null;
            
            try
            {
                myStmt=myConn.prepareStatement("delete from aparso9db.accessory "
                        + "where idACCESSORY="+accessory.getAccessoryID()+";");
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
