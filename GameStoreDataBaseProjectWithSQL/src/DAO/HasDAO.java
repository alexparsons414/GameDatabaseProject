package DAO;

import Core.Has;
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

public class HasDAO {
    private Connection myConn;
    
    public HasDAO() throws Exception{
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
    
    private Has convertRowToGameStoreCustomerRelation(ResultSet myRS) throws SQLException{
        int GameStoreID = myRS.getInt("GameStoreID"),
                CustomerID = myRS.getInt("CustomerID");
        
        Has temp = new Has(GameStoreID,CustomerID);
        
        return temp;
    }
    
    public List<Has> getAllGameStoreCustomerRelations() throws Exception{
        List<Has> list = new ArrayList<>();
        
        Statement myStmt = null;
        ResultSet myRS = null;
        
        try{
            myStmt = myConn.createStatement();
            myRS = myStmt.executeQuery("select * from aparso9db.has");
            
            while(myRS.next()){
                Has temp = convertRowToGameStoreCustomerRelation(myRS);
                list.add(temp);
            }
            
            return list;
        }
        finally{
            close(myStmt,myRS);
        }
    }
    
    public void addGameStoreCustomerRelation(Has relation) throws Exception {
	PreparedStatement myStmt = null;

	try {
		// prepare statement
		myStmt = myConn.prepareStatement("insert into aparso9db.has"
                        + "(GameStoreID,CustomerID) values (?, ?");
			
		// set params
		myStmt.setInt(1, relation.getGameStoreID());
                myStmt.setInt(2, relation.getCustomerID());
		
                // execute SQL
		myStmt.executeUpdate();			
	}
	finally {
		myStmt.close();
	}
    }    
    
    public void delete(Has relation) throws Exception{
            PreparedStatement myStmt=null;
            
            try
            {
                myStmt=myConn.prepareStatement("delete from aparso9db.has "
                        + "where CustomerID="+relation.getCustomerID()
                        + "and GameStoreID="+relation.getGameStoreID()+";");
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
