package View;

import Controller.WorkWithData;
import Model.WorkWithDocument;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDialog {

    private JDialog addDialog;
    private WorkWithData workWithData;

    private JLabel studentNameLabel = new JLabel("Имя студента");
    private JTextField studentNameTextField = new JTextField("Иван");
    private JLabel studentLastnameLabel = new JLabel("Фамилия студента");
    private JTextField studentLastnameTextField = new JTextField("Кобель");
    private JLabel studentSurnameLabel = new JLabel("Отчество студента");
    private JTextField studentSurnameTextField = new JTextField("Александрович");
    private JLabel fatherNameLabel = new JLabel("Имя отца");
    private JTextField fatherNameTextField = new JTextField("Александр");
    private JLabel fatherLastnameLabel = new JLabel("Фамилия отца");
    private JTextField fatherLastnameTextField = new JTextField("Кобель");
    private JLabel fatherSurnameLabel = new JLabel("Отчество отца");
    private JTextField fatherSurnameTextField = new JTextField("Иванович");
    private JLabel fatherSalaryLabel = new JLabel("З/п отца");
    private JTextField fatherSalaryTextField = new JTextField("15000000");
    private JLabel motherNameLabel = new JLabel("Имя матери");
    private JTextField motherNameTextField = new JTextField("Карина");
    private JLabel motherLastnameLabel = new JLabel("Фамилия матери");
    private JTextField motherLastnameTextField = new JTextField("Кобель");
    private JLabel motherSurnameLabel = new JLabel("Отчество матери");
    private JTextField motherSurnameTextField = new JTextField("Борисовна");
    private JLabel motherSalaryLabel = new JLabel("З/п матери");
    private JTextField motherSalaryTextField = new JTextField("100000");
    private JLabel brothersAmountLabel = new JLabel("Кол-во братьев");
    private JTextField brothersAmountTextField = new JTextField("400000");
    private JLabel sistersAmountLabel = new JLabel("Кол-во сестер");
    private JTextField sistersAmountTextField = new JTextField("300000");
    private JButton addDialogButton = new JButton("Добавить");

    private JPanel studentName = new JPanel();
    private JPanel studentLastname = new JPanel();
    private JPanel studentSurname = new JPanel();
    private JPanel fatherName = new JPanel();
    private JPanel fatherLastname = new JPanel();
    private JPanel fatherSurname = new JPanel();
    private JPanel fatherSalary = new JPanel();
    private JPanel motherName = new JPanel();
    private JPanel motherLastname = new JPanel();
    private JPanel motherSurname = new JPanel();
    private JPanel motherSalary = new JPanel();
    private JPanel brothersAmount = new JPanel();
    private JPanel sistersAmount = new JPanel();

    StudentsTable studentsTable;


    public AddDialog(JFrame mainFrame, WorkWithDocument workWithDocument, StudentsTable studentsTable){

        this.workWithData = new WorkWithData(workWithDocument);
        this.studentsTable = studentsTable;
        addDialog = new JDialog(mainFrame);
        setPanels();
        createAddDialog();
    }

    private void setPanels(){

        studentName.setPreferredSize(new Dimension(250, 30));
        studentName.add(studentNameLabel);
        studentName.add(studentNameTextField);

        studentLastname.setPreferredSize(new Dimension(250, 30));
        studentLastname.add(studentLastnameLabel);
        studentLastname.add(studentLastnameTextField);

        studentSurname.setPreferredSize(new Dimension(250, 30));
        studentSurname.add(studentSurnameLabel);
        studentSurname.add(studentSurnameTextField);

        fatherName.setPreferredSize(new Dimension(250, 30));
        fatherName.add(fatherNameLabel);
        fatherName.add(fatherNameTextField);

        fatherLastname.setPreferredSize(new Dimension(250, 30));
        fatherLastname.add(fatherLastnameLabel);
        fatherLastname.add(fatherLastnameTextField);

        fatherSurname.setPreferredSize(new Dimension(250, 30));
        fatherSurname.add(fatherSurnameLabel);
        fatherSurname.add(fatherSurnameTextField);

        fatherSalary.setPreferredSize(new Dimension(250, 30));
        fatherSalary.add(fatherSalaryLabel);
        fatherSalary.add(fatherSalaryTextField);

        motherName.setPreferredSize(new Dimension(250, 30));
        motherName.add(motherNameLabel);
        motherName.add(motherNameTextField);

        motherLastname.setPreferredSize(new Dimension(250, 30));
        motherLastname.add(motherLastnameLabel);
        motherLastname.add(motherLastnameTextField);

        motherSurname.setPreferredSize(new Dimension(250, 30));
        motherSurname.add(motherSurnameLabel);
        motherSurname.add(motherSurnameTextField);

        motherSalary.setPreferredSize(new Dimension(250, 30));
        motherSalary.add(motherSalaryLabel);
        motherSalary.add(motherSalaryTextField);

        brothersAmount.setPreferredSize(new Dimension(250, 30));
        brothersAmount.add(brothersAmountLabel);
        brothersAmount.add(brothersAmountTextField);

        sistersAmount.setPreferredSize(new Dimension(250, 30));
        sistersAmount.add(sistersAmountLabel);
        sistersAmount.add(sistersAmountTextField);
    }

    private void createAddDialog(){

        addDialog.setDefaultCloseOperation(2);
        addDialog.setTitle("Add");
        addDialog.setSize(250, 550);
        addDialog.setLayout(new FlowLayout());
        addDialog.setLocationRelativeTo(null);
        addDialog.setModal(true);
        addDialog.setResizable(false);

        addDialog.add(studentName);
        addDialog.add(studentLastname);
        addDialog.add(studentSurname);
        addDialog.add(fatherName);
        addDialog.add(fatherLastname);
        addDialog.add(fatherSurname);
        addDialog.add(fatherSalary);
        addDialog.add(motherName);
        addDialog.add(motherLastname);
        addDialog.add(motherSurname);
        addDialog.add(motherSalary);
        addDialog.add(brothersAmount);
        addDialog.add(sistersAmount);

        addDialog.add(addDialogButton);

        addDialogButton.addActionListener(new addDialogButtonActionListener());

        addDialog.setVisible(true);
    }

    public class addDialogButtonActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            workWithData.addStudent(studentNameTextField.getText(),
                    studentSurnameTextField.getText(),
                    studentLastnameTextField.getText(),
                    fatherNameTextField.getText(),
                    fatherSurnameTextField.getText(),
                    fatherLastnameTextField.getText(),
                    Integer.valueOf(fatherSalaryTextField.getText()),
                    motherNameTextField.getText(),
                    motherSurnameTextField.getText(),
                    motherLastnameTextField.getText(),
                    Integer.valueOf(motherSalaryTextField.getText()),
                    Integer.valueOf(brothersAmountTextField.getText()),
                    Integer.valueOf(sistersAmountTextField.getText()));

            studentsTable.getFirstPageButton().doClick();
        }
    }
}
