package Model;


import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class StudentsTableModel extends AbstractTableModel{

    public static final int STUDENT_FIO = 0;
    public static final int FATHER_FIO = 1;
    public static final int FATHER_SALARY = 2;
    public static final int MOTHER_FIO = 3;
    public static final int MOTHER_SALARY = 4;
    public static final int BROTHERS_AMOUNT = 5;
    public static final int SISTERS_AMOUNT = 6;
    private List<Student> tableDataList;

    public StudentsTableModel(List<Student> tableDataList){
        this.tableDataList = tableDataList.subList(0, 4);
    }

    public StudentsTableModel(){

    }

    @Override
    public int getRowCount() {
        return tableDataList.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public String getColumnName(int columnIndex) {

        switch (columnIndex){
            case STUDENT_FIO:
                return "Student FIO";
            case FATHER_FIO:
                return "Father FIO";
            case FATHER_SALARY:
                return "Father salary";
            case MOTHER_FIO:
                return "Mother FIO";
            case MOTHER_SALARY:
                return "Mother salary";
            case BROTHERS_AMOUNT:
                return "Brothers amount";
            case SISTERS_AMOUNT:
                return "Sisters amount";
        }

        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Student student = tableDataList.get(rowIndex);

        switch(columnIndex){
            case STUDENT_FIO:
                return student.getLastname() + " " + student.getName() + " " + student.getSurname();
            case FATHER_FIO:
                return student.getFather().getLastname() + " " + student.getFather().getName() + " " + student.getFather().getSurname();
            case FATHER_SALARY:
                return student.getFather().getSalary();
            case MOTHER_FIO:
                return student.getMother().getLastname() + " " + student.getMother().getName() + " " + student.getMother().getSurname();
            case MOTHER_SALARY:
                return student.getMother().getSalary();
            case BROTHERS_AMOUNT:
                return student.getBrothersAmount();
            case SISTERS_AMOUNT:
                return student.getSistersAmount();
        }

        return "";
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }

    public void fillTable(List<Student> currentPage){
        tableDataList = currentPage;
    }
}
