package TableModels;

import Core.Supplies;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class SuppliesTableModel extends AbstractTableModel{
    private static final int PRODUCT_COL = 0;
    private static final int SUPPLIER_COL = 1;
    
    private String[] columnNames = {"ProductID","SupplierID"};
    private List<Supplies> relations;
    
    public SuppliesTableModel(List<Supplies> relations){
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
        Supplies temp = relations.get(rowIndex);
        
        switch(columnIndex){
            case PRODUCT_COL:
                return temp.getProductID();
            case SUPPLIER_COL:
                return temp.getSupplierID();
            default:
                return temp.getProductID();
        }
    }
    
    @Override
    public Class getColumnClass(int c)
    {
        return getValueAt(0,c).getClass();
    }
}
