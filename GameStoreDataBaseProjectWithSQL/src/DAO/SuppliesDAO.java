package DAO;

import Core.Supplies;
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

public class SuppliesDAO {
    private Connection myConn;
    
    public SuppliesDAO() throws Exception{
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
    
    private Supplies convertRowToSupplierProductRelation(ResultSet myRS) throws SQLException{
        int productID = myRS.getInt("productID"),
                supplierID = myRS.getInt("supplierID");
        
        Supplies temp = new Supplies(productID,supplierID);
        
        return temp;
    }
    
    public List<Supplies> getAllSupplierProductRelations() throws Exception{
        List<Supplies> list = new ArrayList<>();
        
        Statement myStmt = null;
        ResultSet myRS = null;
        
        try{
            myStmt = myConn.createStatement();
            myRS = myStmt.executeQuery("select * from aparso9db.supplies");
            
            while(myRS.next()){
                Supplies temp = convertRowToSupplierProductRelation(myRS);
                list.add(temp);
            }
            
            return list;
        }
        finally{
            close(myStmt,myRS);
        }
    }
    
    public void addSupplierProductRelation(Supplies relation) throws Exception {
	PreparedStatement myStmt = null;

	try {
		// prepare statement
		myStmt = myConn.prepareStatement("insert into aparso9db.supplies"
                        + "(productID, supplierID) values (?, ?)");
			
		// set params
		myStmt.setInt(1, relation.getProductID());
                myStmt.setInt(2, relation.getSupplierID());
		
                // execute SQL
		myStmt.executeUpdate();			
	}
	finally {
		myStmt.close();
	}
    }
 
        public void delete(Supplies relation) throws Exception{
            PreparedStatement myStmt=null;
            
            try
            {
                myStmt=myConn.prepareStatement("delete from aparso9db.supplies "
                        + "where supplierID="+relation.getSupplierID()
                        + " and productID="+relation.getProductID()+";");
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
