package TableModels;

import Core.Has;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class HasTableModel extends AbstractTableModel{
    private static final int STORE_COL = 0;
    private static final int CUSTOMER_COL = 1;
    
    private String[] columnNames = {"StoreID","CustomerID"};
    private List<Has> relations;
    
    public HasTableModel(List<Has> relations){
        this.relations = relations;
    }
    
    @Override
    public int getRowCount() {
        return relations.size();
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
        Has temp = relations.get(rowIndex);
        
        switch(columnIndex){
            case STORE_COL:
                return temp.getGameStoreID();
            case CUSTOMER_COL:
                return temp.getCustomerID();
            default:
                return temp.getGameStoreID();
        }
    }
    
    @Override
    public Class getColumnClass(int c)
    {
        return getValueAt(0,c).getClass();
    }
}
