package View;
import Controller.WorkWithData;
import Model.WorkWithDocument;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchDialog {

    private JDialog searchDialog;
    private JButton searchDialogButton = new JButton("Search");
    private JTextField firstSearchTextField = new JTextField("First search parameter");
    private JTextField secondSearchTextField = new JTextField("Second search parameter");
    private JPanel searchDialogTextFieldPanel = new JPanel();
    private JComboBox searchParameter = new JComboBox();

    private WorkWithData workWithData;
    private StudentsTable studentsTable;

    public SearchDialog(JFrame mainFrame, WorkWithDocument workWithDocument){

        searchDialog = new JDialog(mainFrame);

        workWithData = new WorkWithData(workWithDocument);
        studentsTable = new StudentsTable(workWithDocument.getDataList());

        createDialog();
    }

    private void createDialog(){

        searchDialog.setDefaultCloseOperation(2);
        searchDialog.setTitle("Search");
        searchDialog.setSize(900, 300);
        searchDialog.setLayout(new FlowLayout());
        searchDialog.setLocationRelativeTo(null);
        searchDialog.setModal(true);
        searchDialog.setResizable(false);

        addSearchParameters();

        searchDialog.add(studentsTable.getViewPanel());

        searchDialog.add(createPanel());
        searchDialog.add(searchDialogButton);

        searchDialogButton.addActionListener(new searchDialogButtonActionListener());

        searchDialog.setVisible(true);
    }

    private void addSearchParameters(){
        searchParameter.addItem("Student lastname");
        searchParameter.addItem("Father lastname");
        searchParameter.addItem("Father salary");
        searchParameter.addItem("Mother lastname");
        searchParameter.addItem("Mother salary");
        searchParameter.addItem("Brothers amount");
        searchParameter.addItem("Sisters amount");
    }

    public class searchDialogButtonActionListener implements ActionListener{

        public static final int STUDENT_LASTNAME = 0;
        public static final int FATHER_LASTNAME = 1;
        public static final int FATHER_SALARY = 2;
        public static final int MOTHER_LASTNAME = 3;
        public static final int MOTHER_SALARY = 4;
        public static final int BROTHERS_AMOUNT = 5;
        public static final int SISTERS_AMOUNT = 6;

        @Override
        public void actionPerformed(ActionEvent e) {

            switch (searchParameter.getSelectedIndex())
            {
                case STUDENT_LASTNAME:{
                    workWithData.searchStudentByLastname(firstSearchTextField.getText(), 0);
                    break;
                }

                case FATHER_LASTNAME:{
                    workWithData.searchStudentByLastname(firstSearchTextField.getText(), 1);
                    break;
                }

                case FATHER_SALARY:{
                    workWithData.searchStudentBySalary(Integer.valueOf(firstSearchTextField.getText()),
                            Integer.valueOf(secondSearchTextField.getText()), 0);
                    break;
                }

                case MOTHER_LASTNAME:{

                    workWithData.searchStudentByLastname(firstSearchTextField.getText(), 2);
                    break;
                }

                case MOTHER_SALARY:{
                    workWithData.searchStudentBySalary(Integer.valueOf(firstSearchTextField.getText()),
                            Integer.valueOf(secondSearchTextField.getText()), 1);
                    break;
                }

                case BROTHERS_AMOUNT:{
                    workWithData.searchStudentByAmount(Integer.valueOf(firstSearchTextField.getText()), 0);
                    break;
                }

                case SISTERS_AMOUNT:{
                    workWithData.searchStudentByAmount(Integer.valueOf(firstSearchTextField.getText()), 1);
                    break;
                }
            }

            studentsTable.setCurrentDataList(workWithData.getSearchDataList());
            studentsTable.getFirstPageButton().doClick();
            studentsTable.setJLabel();
        }
    }

    private JPanel createPanel(){

        searchDialogTextFieldPanel.setPreferredSize(new Dimension(900, 40));
        searchDialogTextFieldPanel.add(firstSearchTextField);
        searchDialogTextFieldPanel.add(secondSearchTextField);
        searchDialogTextFieldPanel.add(searchParameter);

        return searchDialogTextFieldPanel;
    }
}
