package View;


import Controller.WorkWithData;
import Model.WorkWithDocument;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteDialog {

    private JDialog deleteDialog;
    private JTextField firstDeleteTextField = new JTextField("Min salary");
    private JTextField secondDeleteTextField = new JTextField("Max salary");
    private JComboBox deleteCombobox = new JComboBox();
    private JButton deleteDialogButton = new JButton("Delete");
    private WorkWithData workWithData;

    public static final int STUDENT_FIO = 0;
    public static final int FATHER_FIO = 1;
    public static final int FATHER_SALARY = 2;
    public static final int MOTHER_FIO = 3;
    public static final int MOTHER_SALARY = 4;
    public static final int BROTHERS_AMOUNT = 5;
    public static final int SISTERS_AMOUNT = 6;

    StudentsTable studentsTable;

    public DeleteDialog(JFrame mainFrame, WorkWithDocument workWithDocument, StudentsTable studentsTable){
        this.studentsTable = studentsTable;
        workWithData = new WorkWithData(workWithDocument);
        deleteDialog = new JDialog(mainFrame);
        createDeleteDialog();
    }

    private void createDeleteDialog(){

        deleteDialog.setDefaultCloseOperation(2);
        deleteDialog.setTitle("Delete");
        deleteDialog.setSize(200, 120);
        deleteDialog.setLayout(new FlowLayout());
        deleteDialog.setLocationRelativeTo(null);
        deleteDialog.setModal(true);
        deleteDialog.setResizable(false);

        deleteCombobox.addItem("Student lastname");
        deleteCombobox.addItem("Father lastname");
        deleteCombobox.addItem("Father salary");
        deleteCombobox.addItem("Mother lastname");
        deleteCombobox.addItem("Mother salary");
        deleteCombobox.addItem("Brothers amount");
        deleteCombobox.addItem("Sisters amount");

        deleteDialog.add(firstDeleteTextField);
        deleteDialog.add(secondDeleteTextField);
        deleteDialog.add(deleteCombobox);
        deleteDialog.add(deleteDialogButton);

        deleteDialogButton.addActionListener(new deleteDialogButtonActionListener());

        deleteDialog.setVisible(true);
    }

    public class deleteDialogButtonActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            switch (deleteCombobox.getSelectedIndex()) {
                case STUDENT_FIO: {
                    workWithData.deleteStudent(workWithData.searchStudentByLastname(firstDeleteTextField.getText(), 0), 0, 0);
                    break;
                }

                case FATHER_FIO: {
                    workWithData.deleteStudent(workWithData.searchStudentByLastname(firstDeleteTextField.getText(), 1), 0, 1);
                    break;
                }

                case FATHER_SALARY: {
                    workWithData.deleteStudent(workWithData.searchStudentBySalary(Integer.valueOf(firstDeleteTextField.getText()),
                            Integer.valueOf(secondDeleteTextField.getText()), 0), 1, 0);
                    break;
                }

                case MOTHER_FIO: {
                    workWithData.deleteStudent(workWithData.searchStudentByLastname(firstDeleteTextField.getText(), 2), 0, 2);
                    break;
                }

                case MOTHER_SALARY: {
                    workWithData.deleteStudent(workWithData.searchStudentBySalary(Integer.valueOf(firstDeleteTextField.getText()),
                            Integer.valueOf(secondDeleteTextField.getText()), 1), 1, 1);
                    break;
                }

                case BROTHERS_AMOUNT: {
                    workWithData.deleteStudent(workWithData.searchStudentByAmount(Integer.valueOf(firstDeleteTextField.getText()), 0), 2, 0);
                    break;
                }

                case SISTERS_AMOUNT: {
                    workWithData.deleteStudent(workWithData.searchStudentByAmount(Integer.valueOf(firstDeleteTextField.getText()), 1), 2, 1);
                    break;
                }
            }

            studentsTable.getFirstPageButton().doClick();
        }
    }
}
