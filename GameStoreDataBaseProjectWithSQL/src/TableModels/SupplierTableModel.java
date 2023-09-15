package TableModels;

import Core.Supplier;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class SupplierTableModel extends AbstractTableModel{
    private static final int ID_COL = 0;
    private static final int NAME_COL = 1;
    private static final int ADDRESS_COL = 2;
    private static final int CITY_COL = 3;
    private static final int STATE_COL = 4;
    private static final int ZIP_COL = 5;
    private static final int PHONE_COL = 6;
    
    private String[] columnNames = {"SupplierID","Supplier_Name","Address","City","State","Zip_Code","Phone#"};
    private List<Supplier> suppliers;
    
    public SupplierTableModel(List<Supplier> suppliers){
        this.suppliers = suppliers;
    }
    
    @Override
    public int getRowCount() {
        return suppliers.size();
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
        Supplier temp = suppliers.get(rowIndex);
        
        switch(columnIndex){
            case ID_COL:
                return temp.getId();
            case NAME_COL:
                return temp.getName();
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
