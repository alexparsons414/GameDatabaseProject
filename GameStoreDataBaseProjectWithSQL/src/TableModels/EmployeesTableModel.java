package TableModels;

import Core.Employees;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class EmployeesTableModel extends AbstractTableModel{
    private static final int SSN_COL = 0;
    private static final int ADDRESS_COL = 1;
    private static final int CITY_COL = 2;
    private static final int STATE_COL = 3;
    private static final int ZIP_COL = 4;
    private static final int FNAME_COL = 5;
    private static final int LNAME_COL = 6;
    private static final int BDATE_COL = 7;
    private static final int SALARY_COL = 8;
    private static final int SEX_COL = 9;
    private static final int POSITION_COL = 10;
    private static final int MANAGERSSN_COL = 11;
    private static final int STORE_COL = 12;
    private static final int DISTRICT_COL = 13;
    private static final int CORP_COL = 14;
    
    private String[] columnNames = {"EmplyeeSSN","Address","City","State",
        "Zip_Code","First_Name","Last_Name","Birth_Date","Salary","Sex",
        "Position","ManagerSSN","StoreID","DistrictID","CorporationID"};
    private List<Employees> employees;
    
    public EmployeesTableModel(List<Employees> employees){
        this.employees = employees;
    }
    
    @Override
    public int getRowCount() {
        return employees.size();
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
        Employees temp = employees.get(rowIndex);
        
        switch(columnIndex){
            case SSN_COL:
                return temp.getSsn();
            case ADDRESS_COL:
                return temp.getAddress();
            case CITY_COL:
                return temp.getCity();
            case STATE_COL:
                return temp.getState();
            case ZIP_COL:
                return temp.getZip();
            case FNAME_COL:
                return temp.getfName();
            case LNAME_COL:
                return temp.getlName();
            case BDATE_COL:
                return temp.getbDate();
            case SALARY_COL:
                return temp.getSalary();
            case SEX_COL:
                return temp.getSex();
            case POSITION_COL:
                return temp.getPosition();
            case MANAGERSSN_COL:
                return temp.getManagerSSN();
            case STORE_COL:
                return temp.getGameStoreID();
            case DISTRICT_COL:
                return temp.getDistrictID();
            case CORP_COL:
                return temp.getCorporateID();
            default:
                return temp.getSsn();
        }
    }
    
    @Override
    public Class getColumnClass(int c)
    {
        return getValueAt(0,c).getClass();
    }
}
