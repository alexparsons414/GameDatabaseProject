package DAO;

import Core.District;
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

public class DistrictDAO {
private Connection myConn;
    
    public DistrictDAO() throws Exception{
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
    
    private District convertRowToDistrict(ResultSet myRS) throws SQLException{
        int id = myRS.getInt("DistrictID"),
                corporateID = myRS.getInt("corpID");
        
        District temp = new District(id,corporateID);
        
        return temp;
    }
    
    public List<District> getAllDistricts() throws Exception{
        List<District> list = new ArrayList<>();
        
        Statement myStmt = null;
        ResultSet myRS = null;
        
        try{
            myStmt = myConn.createStatement();
            myRS = myStmt.executeQuery("select * from aparso9db.district");
            
            while(myRS.next()){
                District temp = convertRowToDistrict(myRS);
                list.add(temp);
            }
            
            return list;
        }
        finally{
            close(myStmt,myRS);
        }
    }
    
    public void addDistrict(District district) throws Exception {
	PreparedStatement myStmt = null;

	try {
		// prepare statement
		myStmt = myConn.prepareStatement("insert into aparso9db.district"
                        + "(DistrictID, corpID) values (?, ?)");
			
		// set params
		myStmt.setInt(1, district.getdID());
                myStmt.setInt(2, district.getcID());
		
                // execute SQL
		myStmt.executeUpdate();			
	}
	finally {
		myStmt.close();
	}
    }
        
        public void update(District district) throws Exception
        {
            PreparedStatement myStmt=null;
            try
            {
                if(district.getcID() > 0)
                {
                    myStmt=myConn.prepareStatement("update aparso9db.district set corpID = '"
                            +district.getcID()+"' where DistrictID="+district.getdID()+";");
                    myStmt.executeUpdate();
                }
            }
            finally
            {
                myStmt.close();
            }
        }
        
        public void delete(District district) throws Exception{
            PreparedStatement myStmt=null;
            
            try
            {
                myStmt=myConn.prepareStatement("delete from aparso9db.district "
                        + "where DistrictID="+district.getdID()+";");
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
