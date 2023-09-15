package TableModels;

import Core.GameStore;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class GameStoreTableModel extends AbstractTableModel{
    private static final int ID_COL = 0;
    private static final int ADDRESS_COL = 1;
    private static final int CITY_COL = 2;
    private static final int STATE_COL = 3;
    private static final int ZIP_COL = 4;
    private static final int PHONE_COL = 5;
    private static final int DIST_COL = 6;
    
    private String[] columnNames = {"StoreID","Address","City","State","Zip_Code","Phone#","DistrictID"};
    private List<GameStore> stores;
    
    public GameStoreTableModel(List<GameStore> stores){
        this.stores = stores;
    }
    
    @Override
    public int getRowCount() {
        return stores.size();
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
        GameStore temp = stores.get(rowIndex);
        
        switch(columnIndex){
            case ID_COL:
                return temp.getId();
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
            case DIST_COL:
                return temp.getDistrictID();
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
