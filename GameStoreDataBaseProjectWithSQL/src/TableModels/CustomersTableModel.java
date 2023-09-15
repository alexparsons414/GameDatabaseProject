package TableModels;

import Core.Customers;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class CustomersTableModel extends AbstractTableModel{
    private static final int ID_COL = 0;
    private static final int FNAME_COL = 1;
    private static final int LNAME_COL = 2;
    private static final int ADDRESS_COL = 3;
    private static final int CITY_COL = 4;
    private static final int STATE_COL = 5;
    private static final int ZIP_COL = 6;
    private static final int PHONE_COL = 7;
    
    private String[] columnNames = {"CustomerID","First_Name","Last_Name","Address","City","State","Zip_Code","Phone#"};
    private List<Customers> customers;
    
    public CustomersTableModel(List<Customers> customers){
        this.customers = customers;
    }
    
    @Override
    public int getRowCount() {
        return customers.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
    
    @Override
    public String getColumnName(int index){
        return columnNames[index];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Customers temp = customers.get(rowIndex);
        
        switch(columnIndex){
            case ID_COL:
                return temp.getId();
            case FNAME_COL:
                return temp.getfName();
            case LNAME_COL:
                return temp.getlName();
            case ADDRESS_COL:
                return temp.getAddress();
            case CITY_COL:
                return temp.getCity();
            case STATE_COL:
                return temp.getState();
            case ZIP_COL:
                return temp.getZip();
            case PHONE_COL:
                return temp.getPhoneNo();
            default:
                return temp.getId();
        }
    }
    
    @Override
    public Class getColumnClass(int c)
    {
        return getValueAt(0,c).getClass();
    }
}
