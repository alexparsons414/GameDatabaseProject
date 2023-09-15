package TableModels;

import Core.Corporate;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class CorporateTableModel extends AbstractTableModel{
    private static final int ID_COL = 0;
    private static final int ADDRESS_COL = 1;
    private static final int CITY_COL = 2;
    private static final int STATE_COL = 3;
    private static final int ZIP_COL = 4;
    private static final int PHONE_COL = 5;
    
    private String[] columnNames = {"CorporateID","Address","City","State","Zip_Code","Phone#"};
    private List<Corporate> corporateOffices;
    
    public CorporateTableModel(List<Corporate> offices){
        this.corporateOffices = offices;
    }
    
    @Override
    public int getRowCount() {
        return corporateOffices.size();
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
        Corporate temp = corporateOffices.get(rowIndex);
        
        switch(columnIndex){
            case ID_COL:
                return temp.getcID();
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
                return temp.getcID();
        }
    }
    
    @Override
    public Class getColumnClass(int c)
    {
        return getValueAt(0,c).getClass();
    }
}
