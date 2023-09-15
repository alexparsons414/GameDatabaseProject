package TableModels;

import Core.Product;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ProductTableModel extends AbstractTableModel{
    private static final int ID_COL = 0;
    private static final int NAME_COL = 1;
    private static final int PRICE_COL = 2;
    private static final int RESERVED_COL = 3;
    private static final int STORE_COL = 4;
    
    private String[] columnNames = {"ProductID","Name","Price","Reserved?(0/1)","StoreID"};
    private List<Product> products;
    
    public ProductTableModel(List<Product> products){
        this.products = products;
    }
    
    @Override
    public int getRowCount() {
        return products.size();
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
        Product temp = products.get(rowIndex);
        
        switch(columnIndex){
            case ID_COL:
                return temp.getId();
            case NAME_COL:
                return temp.getName();
            case PRICE_COL:
                return temp.getPrice();
            case RESERVED_COL:
                return temp.getIsReserved();
            case STORE_COL:
                return temp.getGameStoreID();
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
