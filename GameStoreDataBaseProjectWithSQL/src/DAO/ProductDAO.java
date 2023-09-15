package DAO;

import Core.Product;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ProductDAO {
    private Connection myConn;
    
    public ProductDAO() throws Exception{
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
    
    private Product convertRowToProduct(ResultSet myRS) throws SQLException{
        int id = myRS.getInt("idPRODUCT"),
                gameStoreID = myRS.getInt("gameStoreID");
        String name = myRS.getString("name");
        char isReserved = myRS.getString("isReserved").charAt(0);
        BigDecimal p = myRS.getBigDecimal("price");
        double price = p.doubleValue();
        
        Product temp = new Product(id,price,gameStoreID,name,isReserved);
        
        return temp;
    }
    
    public List<Product> getAllProducts() throws Exception{
        List<Product> list = new ArrayList<>();
        
        Statement myStmt = null;
        ResultSet myRS = null;
        
        try{
            myStmt = myConn.createStatement();
            myRS = myStmt.executeQuery("select * from aparso9db.product");
            
            while(myRS.next()){
                Product temp = convertRowToProduct(myRS);
                list.add(temp);
            }
            
            return list;
        }
        finally{
            close(myStmt,myRS);
        }
    }
    
    public void addProduct(Product product) throws Exception {
	PreparedStatement myStmt = null;

	try {
		// prepare statement
		myStmt = myConn.prepareStatement("insert into aparso9db.product"
                        + "(idPRODUCT, name, price, isReserved, gameStoreID) "
                        + "values (?, ?, ?, ?, ?)");
			
		// set params
		myStmt.setInt(1, product.getId());
                myStmt.setString(2, product.getName());
                
                if(product.getPrice() >= 0){
                    BigDecimal p = BigDecimal.valueOf(product.getPrice());
                    myStmt.setBigDecimal(3, p);
                }
                else{
                    myStmt.setNull(3, java.sql.Types.INTEGER);
                }
                
                if(product.getIsReserved() == 'Y'){
                    myStmt.setInt(4, 1);
                }
                else{
                    myStmt.setInt(4, 0);
                }
		if(product.getGameStoreID() > 0){
                    myStmt.setInt(5, product.getGameStoreID());
                }
                else{
                    myStmt.setNull(5, java.sql.Types.INTEGER);
                }
		
                // execute SQL
		myStmt.executeUpdate();			
	}
	finally {
		myStmt.close();
	}
    }
        
        public void update(Product product) throws Exception
        {
            PreparedStatement myStmt=null;
            try
            {
                if(product.getName() != null)
                {
                    myStmt=myConn.prepareStatement("update aparso9db.product set name = '"
                            +product.getName()+"' where idPRODUCT="+product.getId()+";");
                    myStmt.executeUpdate();
                }
                if(product.getPrice() >= 0)
                {
                    BigDecimal p = BigDecimal.valueOf(product.getPrice());
                    
                    myStmt=myConn.prepareStatement("update aparso9db.product set price = '"
                            +p+"' where idPRODUCT="+product.getId()+";");
                    myStmt.executeUpdate();
                }
                if(product.getIsReserved() == 'Y' || product.getIsReserved() == 'y' 
                        || product.getIsReserved() == 'N' || product.getIsReserved() == 'n')
                {
                    int yesOrNo;
                    if(product.getIsReserved() == 'Y'|| product.getIsReserved() == 'y'){
                        yesOrNo = 1;
                    }
                    else{
                        yesOrNo = 0;
                    }
                    System.out.println(yesOrNo);
                    myStmt=myConn.prepareStatement("update aparso9db.product set isReserved = '"
                            +yesOrNo+"' where idPRODUCT="+product.getId()+";");
                    myStmt.executeUpdate();
                }
                if(product.getGameStoreID() > 0)
                {
                    myStmt=myConn.prepareStatement("update aparso9db.product set gameStoreID = '"
                            +product.getGameStoreID()+"' where idPRODUCT="+product.getId()+";");
                    myStmt.executeUpdate();
                }
            }
            finally
            {
                myStmt.close();
            }
        }
        
        public void delete(Product product) throws Exception{
            PreparedStatement myStmt=null;
            
            try
            {
                myStmt=myConn.prepareStatement("delete from aparso9db.product "
                        + "where idPRODUCT="+product.getId()+";");
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
