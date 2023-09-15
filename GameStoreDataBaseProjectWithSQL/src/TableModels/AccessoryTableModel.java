package TableModels;

import Core.Accessory;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class AccessoryTableModel extends AbstractTableModel{

    private static final int ID_COL = 0;
    private static final int TYPE_COL = 1;
    private static final int CONSOLE_COL = 2;
    
    private String[] columnNames = {"ProductID","AccessoryType","Compatible_Console(s)"};
    private List<Accessory> accessories;
    
    public AccessoryTableModel(List<Accessory> accessories){
        this.accessories = accessories;
    }
    
    @Override
    public int getRowCount() {
        return accessories.size();
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
        Accessory temp = accessories.get(rowIndex);
        
        switch(columnIndex){
            case ID_COL:
                return temp.getAccessoryID();
            case TYPE_COL:
                return temp.getAccType();
            case CONSOLE_COL:
                return temp.getAccConsole();
            default:
                return temp.getAccessoryID();
        }
    }
    
    @Override
    public Class getColumnClass(int c)
    {
        return getValueAt(0,c).getClass();
    }
}
