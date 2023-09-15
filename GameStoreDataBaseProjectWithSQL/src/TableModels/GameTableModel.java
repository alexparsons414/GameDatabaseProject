package TableModels;

import Core.Game;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class GameTableModel extends AbstractTableModel{
    private static final int ID_COL = 0;
    private static final int CONSOLE_COL = 1;
    private static final int RATING_COL = 2;
    private static final int PUBLISHER_COL = 3;
    
    private String[] columnNames = {"ProductID","Console","Rating","Publisher"};
    private List<Game> games;
    
    public GameTableModel(List<Game> games){
        this.games = games;
    }
    
    @Override
    public int getRowCount() {
        return games.size();
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
        Game temp = games.get(rowIndex);
        
        switch(columnIndex){
            case ID_COL:
                return temp.getGame();
            case CONSOLE_COL:
                return temp.getConsole();
            case RATING_COL:
                return temp.getRating();
            case PUBLISHER_COL:
                return temp.getPublisher();
            default:
                return temp.getGame();
        }
    }
    
    @Override
    public Class getColumnClass(int c)
    {
        return getValueAt(0,c).getClass();
    }
}
