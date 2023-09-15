package DAO;

import Core.GameStore;
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

public class GameStoreDAO {
    private Connection myConn;
    
    public GameStoreDAO() throws Exception{
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
    
    private GameStore convertRowToGameStore(ResultSet myRS) throws SQLException{
        int id = myRS.getInt("idGAME_STORE"),
                distID = myRS.getInt("distID");
        String address = myRS.getString("address"),
                city = myRS.getString("city"),
                state = myRS.getString("state"),
                zip = myRS.getString("zip"),
                phoneNo = myRS.getString("phoneNo");
        
        GameStore temp = new GameStore(id,distID,address,city,state,zip,phoneNo);
        
        return temp;
    }
    
    public List<GameStore> getAllGameStores() throws Exception{
        List<GameStore> list = new ArrayList<>();
        
        Statement myStmt = null;
        ResultSet myRS = null;
        
        try{
            myStmt = myConn.createStatement();
            myRS = myStmt.executeQuery("select * from aparso9db.game_store");
            
            while(myRS.next()){
                GameStore temp = convertRowToGameStore(myRS);
                list.add(temp);
            }
            
            return list;
        }
        finally{
            close(myStmt,myRS);
        }
    }
    
    public void addGameStore(GameStore store) throws Exception {
	PreparedStatement myStmt = null;

	try {
		// prepare statement
		myStmt = myConn.prepareStatement("insert into aparso9db.game_store"
                        + "(idGAME_STORE, address, city, state, zip,"
                        + " phoneNo, distID) values (?, ?, ?, ?, ?, ?, ?)");
			
		// set params
		myStmt.setInt(1, store.getId());
                myStmt.setString(2, store.getAddress());
                myStmt.setString(3, store.getCity());
		myStmt.setString(4, store.getState());
		myStmt.setString(5, store.getZip());
                myStmt.setString(6, store.getPhoneNo());
                myStmt.setInt(7, store.getDistrictID());
		
                // execute SQL
		myStmt.executeUpdate();			
	}
	finally {
		myStmt.close();
	}
    }
        
        public void update(GameStore store) throws Exception
        {
            PreparedStatement myStmt=null;
            try
            {
                if(store.getAddress() != null)
                {
                    myStmt=myConn.prepareStatement("update aparso9db.game_store set address = '"
                            +store.getAddress()+"' where idGAME_STORE="+store.getId()+";");
                    myStmt.executeUpdate();
                }
                if(store.getCity() != null)
                {
                    myStmt=myConn.prepareStatement("update aparso9db.game_store set city = '"
                            +store.getCity()+"' where idGAME_STORE="+store.getId()+";");
                    myStmt.executeUpdate();
                }
                if(store.getState() != null)
                {
                    myStmt=myConn.prepareStatement("update aparso9db.game_store set state = '"
                            +store.getState()+"' where idGAME_STORE="+store.getId()+";");
                    myStmt.executeUpdate();
                }
                if(store.getZip() != null)
                {
                    myStmt=myConn.prepareStatement("update aparso9db.game_store set zip = '"
                            +store.getZip()+"' where idGAME_STORE="+store.getId()+";");
                    myStmt.executeUpdate();
                }
                if(store.getPhoneNo() != null)
                {
                    myStmt=myConn.prepareStatement("update aparso9db.game_store set phoneNo = '"
                            +store.getPhoneNo()+"' where idGAME_STORE="+store.getId()+";");
                    myStmt.executeUpdate();
                }
                if(store.getDistrictID() > 0)
                {
                    myStmt=myConn.prepareStatement("update aparso9db.game_store set distID = '"
                            +store.getDistrictID()+"' where idGAME_STORE="+store.getId()+";");
                    myStmt.executeUpdate();
                }
            }
            finally
            {
                myStmt.close();
            }
        }
        
        public void delete(GameStore store) throws Exception{
            PreparedStatement myStmt=null;
            
            try
            {
                myStmt=myConn.prepareStatement("delete from aparso9db.game_store "
                        + "where idGAME_STORE="+store.getId()+";");
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
