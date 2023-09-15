package DAO;

import Core.Supplier;
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

public class SupplierDAO {
    private Connection myConn;
    
    public SupplierDAO() throws Exception{
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
    
    private Supplier convertRowToSupplier(ResultSet myRS) throws SQLException{
        int id = myRS.getInt("idSUPPLIER");
        String supplierName = myRS.getString("supplierName"),
                address = myRS.getString("address"),
                city = myRS.getString("city"),
                state = myRS.getString("state"),
                zip = myRS.getString("zip"),
                phoneNo = myRS.getString("phoneNo");
        
        Supplier temp = new Supplier(id,supplierName,address,city,state,zip,phoneNo);
        
        return temp;
    }
    
    public List<Supplier> getAllSuppliers() throws Exception{
        List<Supplier> list = new ArrayList<>();
        
        Statement myStmt = null;
        ResultSet myRS = null;
        
        try{
            myStmt = myConn.createStatement();
            myRS = myStmt.executeQuery("select * from aparso9db.supplier");
            
            while(myRS.next()){
                Supplier temp = convertRowToSupplier(myRS);
                list.add(temp);
            }
            
            return list;
        }
        finally{
            close(myStmt,myRS);
        }
    }
    
    public void addSupplier(Supplier supplier) throws Exception {
	PreparedStatement myStmt = null;

	try {
		// prepare statement
		myStmt = myConn.prepareStatement("insert into aparso9db.supplier"
                        + "(idSUPPLIER, supplierName, address, city, state, zip,"
                        + " phoneNo) values (?, ?, ?, ?, ?, ?, ?)");
			
		// set params
		myStmt.setInt(1, supplier.getId());
                myStmt.setString(2, supplier.getName());
		myStmt.setString(3, supplier.getAddress());
		myStmt.setString(4, supplier.getCity());
                myStmt.setString(5, supplier.getState());
                myStmt.setString(6, supplier.getZip());
		myStmt.setString(7, supplier.getPhoneNo());
		
                // execute SQL
		myStmt.executeUpdate();			
	}
	finally {
		myStmt.close();
	}
    }
        
        public void update(Supplier supplier) throws Exception
        {
            PreparedStatement myStmt=null;
            try
            {
                if(supplier.getName() != null)
                {
                    myStmt=myConn.prepareStatement("update aparso9db.supplier set supplierName = '"
                            +supplier.getName()+"' where idSUPPLIER="+supplier.getId()+";");
                    myStmt.executeUpdate();
                }
                if(supplier.getAddress() != null)
                {
                    myStmt=myConn.prepareStatement("update aparso9db.supplier set address = '"
                            +supplier.getAddress()+"' where idSUPPLIER="+supplier.getId()+";");
                    myStmt.executeUpdate();
                }
                if(supplier.getCity() != null)
                {
                    myStmt=myConn.prepareStatement("update aparso9db.supplier set city = '"
                            +supplier.getCity()+"' where idSUPPLIER="+supplier.getId()+";");
                    myStmt.executeUpdate();
                }
                if(supplier.getState() != null)
                {
                    myStmt=myConn.prepareStatement("update aparso9db.supplier set state = '"
                            +supplier.getState()+"' where idSUPPLIER="+supplier.getId()+";");
                    myStmt.executeUpdate();
                }
                if(supplier.getZip() != null)
                {
                    myStmt=myConn.prepareStatement("update aparso9db.supplier set zip = '"
                            +supplier.getZip()+"' where idSUPPLIER="+supplier.getId()+";");
                    myStmt.executeUpdate();
                }
                if(supplier.getPhoneNo() != null)
                {
                    myStmt=myConn.prepareStatement("update aparso9db.supplier set phoneNo = '"
                            +supplier.getPhoneNo()+"' where idSUPPLIER="+supplier.getId()+";");
                    myStmt.executeUpdate();
                }
            }
            finally
            {
                myStmt.close();
            }
        }
        
        public void delete(Supplier supplier) throws Exception{
            PreparedStatement myStmt=null;
            
            try
            {
                myStmt=myConn.prepareStatement("delete from aparso9db.supplier "
                        + "where idSUPPLIER="+supplier.getId()+";");
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
