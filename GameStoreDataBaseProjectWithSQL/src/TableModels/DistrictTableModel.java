package TableModels;

import Core.District;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class DistrictTableModel extends AbstractTableModel{
    private static final int ID_COL = 0;
    private static final int CORP_COL = 1;
    
    private String[] columnNames = {"DistrictID","CorporateID"};
    private List<District> districts;
    
    public DistrictTableModel(List<District> districts){
        this.districts = districts;
    }
    
    @Override
    public int getRowCount() {
        return districts.size();
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
        District temp = districts.get(rowIndex);
        
        switch(columnIndex){
            case ID_COL:
                return temp.getdID();
            case CORP_COL:
                return temp.getcID();
            default:
                return temp.getdID();
        }
    }
    
    @Override
    public Class getColumnClass(int c)
    {
        return getValueAt(0,c).getClass();
    }
}
