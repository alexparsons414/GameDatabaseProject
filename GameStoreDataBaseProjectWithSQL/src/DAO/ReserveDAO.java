package DAO;

import Core.Reserve;
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

public class ReserveDAO {
    private Connection myConn;
    
    public ReserveDAO() throws Exception{
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
    
    private Reserve convertRowToReservation(ResultSet myRS) throws SQLException{
        int id = myRS.getInt("idRESERVATION"),
                CustoID = myRS.getInt("CustoID"),
                ProdID = myRS.getInt("ProdID");
        
        Reserve temp = new Reserve(id,CustoID,ProdID);
        
        return temp;
    }
    
    public List<Reserve> getAllReservations() throws Exception{
        List<Reserve> list = new ArrayList<>();
        
        Statement myStmt = null;
        ResultSet myRS = null;
        
        try{
            myStmt = myConn.createStatement();
            myRS = myStmt.executeQuery("select * from aparso9db.reserve");
            
            while(myRS.next()){
                Reserve temp = convertRowToReservation(myRS);
                list.add(temp);
            }
            
            return list;
        }
        finally{
            close(myStmt,myRS);
        }
    }
    
    public void addResrvation(Reserve reserve) throws Exception {
	PreparedStatement myStmt = null;

	try {
		// prepare statement
		myStmt = myConn.prepareStatement("insert into aparso9db.reserve"
                        + "(idRESERVATION, CustoID, ProdID) values (?, ?, ?)");
			
		// set params
		myStmt.setInt(1, reserve.getReservationID());
                myStmt.setInt(2, reserve.getCustomerID());
                myStmt.setInt(3, reserve.getProductID());
		
                // execute SQL
		myStmt.executeUpdate();		
                
                myStmt = myConn.prepareStatement("update aparso9db.product set "
                        + "isReserved = 1 where idPRODUCT = " + reserve.getProductID());
                myStmt.executeUpdate();
	}
	finally {
		myStmt.close();
	}
    }
        
        public void update(Reserve reserve) throws Exception
        {
            PreparedStatement myStmt = null;
            Statement mS = null;
            
            try
            {
                if(reserve.getCustomerID() > 0)
                {
                    myStmt=myConn.prepareStatement("update aparso9db.reserve set CustoID = '"
                            +reserve.getCustomerID()+"' where idRESERVATION="+reserve.getReservationID()+";");
                    myStmt.executeUpdate();
                }
                if(reserve.getProductID() > 0)
                {
                    int product = 0;
                    ResultSet rs = myConn.createStatement().executeQuery("select ProdID from aparso9db.reserve where idRESERVATION = " + reserve.getReservationID() + ";");
                    while(rs.next()){
                        product = rs.getInt("ProdID");
                    }
                    myStmt = myConn.prepareStatement("update aparso9db.product set "
                        + "isReserved = 0 where idPRODUCT = " + product);
                    myStmt.executeUpdate();
                    
                    myStmt=myConn.prepareStatement("update aparso9db.reserve set ProdID = '"
                            +reserve.getProductID()+"' where idRESERVATION="+reserve.getReservationID()+";");
                    myStmt.executeUpdate();
                    
                    myStmt=myConn.prepareStatement("update aparso9db.product set "
                            + "isReserved = 1 where idPRODUCT = " + reserve.getProductID() + ";");
                    myStmt.executeUpdate();
                }                
            }
            finally
            {
                myStmt.close();
            }
        }
        
        public void delete(Reserve reserve) throws Exception{
            PreparedStatement myStmt=null;
            
            try
            {
                int product = 0;
                ResultSet rs = myConn.createStatement().executeQuery("select ProdID from aparso9db.reserve where idRESERVATION = " + reserve.getReservationID() + ";");
                while(rs.next()){
                    product = rs.getInt("ProdID");
                }
                myStmt = myConn.prepareStatement("update aparso9db.product set "
                        + "isReserved = 0 where idPRODUCT = " + product);
                myStmt.executeUpdate();
                
                myStmt=myConn.prepareStatement("delete from aparso9db.reserve "
                        + "where idRESERVATION="+reserve.getReservationID()+";");
                
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
