package TableModels;

import Core.Reserve;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ReserveTableModel extends AbstractTableModel{
    private static final int ID_COL = 0;
    private static final int CUSTOMER_COL = 1;
    private static final int PRODUCT_COL = 2;

    private String[] columnNames = {"ReservationID","CustomerID","ProductID"};
    private List<Reserve> reservations;
    
    public ReserveTableModel(List<Reserve> reservations){
        this.reservations = reservations;
    }
    
    @Override
    public int getRowCount() {
        return reservations.size();
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
        Reserve temp = reservations.get(rowIndex);
        
        switch(columnIndex){
            case ID_COL:
                return temp.getReservationID();
            case CUSTOMER_COL:
                return temp.getCustomerID();
            case PRODUCT_COL:
                return temp.getProductID();
            default:
                return temp.getReservationID();
        }
    }
    
    @Override
    public Class getColumnClass(int c)
    {
        return getValueAt(0,c).getClass();
    }
}
