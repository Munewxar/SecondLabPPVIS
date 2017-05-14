package View;

import Model.Student;
import Model.StudentsTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class StudentsTable {

    private JTable studentsTable;
    private JPanel viewPanel = new JPanel();
    private JPanel viewButtonsPanel = new JPanel();
    private JButton firstPageButton = new JButton("F");
    private JButton previousPageButton = new JButton("<<");
    private JButton nextPageButton = new JButton(">>");
    private JButton lastPageButton = new JButton("L");
    private JComboBox changeRecordsAmountCombobox = new JComboBox();
    private JLabel allRecordsLabel = new JLabel();

    private List<Student> currentDataList;
    private StudentsTableModel studentsTableModel;

    public StudentsTable(List<Student> currentDataList){
        studentsTableModel =  new StudentsTableModel(currentDataList);
        this.currentDataList = currentDataList;
        this.studentsTable = new JTable(this.studentsTableModel);
        addActionListeners();
        setCombobox();
        setJLabel();
        setViewPanel();
    }

    public void setCurrentDataList(List<Student> currentDataList){
        this.currentDataList = currentDataList;
    }

    int currentPage = 0;

    private int getLastPageNumberInt(){

        int lastPageInt;
        double lastPageDouble;

        lastPageInt = currentDataList.size()/Integer.valueOf(changeRecordsAmountCombobox.getSelectedItem().toString());
        lastPageDouble = currentDataList.size()/Double.valueOf(changeRecordsAmountCombobox.getSelectedItem().toString());

        if (lastPageInt<lastPageDouble)
        {
            lastPageInt++;
        }

        return (lastPageInt - 1);
    }

    private void addActionListeners(){
        firstPageButton.addActionListener(new firstPageButtonActionListener());
        previousPageButton.addActionListener(new previousPageButtonActionLIstener());
        nextPageButton.addActionListener(new nextPageButtonActionListener());
        lastPageButton.addActionListener(new lastPageButtonActionListener());
    }

    private void setCombobox(){
        changeRecordsAmountCombobox.addItem("4");
        changeRecordsAmountCombobox.addItem("5");
        changeRecordsAmountCombobox.addActionListener(new changeRecordsAmountComboboxActionListener());
    }

    public void setJLabel(){
        if(currentDataList != null){
            allRecordsLabel.setText("Records: " + currentDataList.size() + " current page: " + (currentPage + 1));
        }else{
            allRecordsLabel.setText("Records: 0" );
        }
    }

    private void setViewPanel(){

        GridBagConstraints gbc = new GridBagConstraints();

        viewPanel.setLayout(new GridBagLayout());
        viewPanel.setPreferredSize(new Dimension(900, 170));

        gbc.weightx = 1.0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridheight =2;

        viewButtonsPanel.setPreferredSize(new Dimension(900, 50));

        viewButtonsPanel.add(firstPageButton);
        viewButtonsPanel.add(previousPageButton);
        viewButtonsPanel.add(nextPageButton);
        viewButtonsPanel.add(lastPageButton);
        viewButtonsPanel.add(changeRecordsAmountCombobox);
        viewButtonsPanel.add(allRecordsLabel);

        studentsTable.getTableHeader().setPreferredSize(new Dimension(880, 20));
        studentsTable.setPreferredSize(new Dimension(880, 100));

        viewPanel.add(studentsTable.getTableHeader(), gbc);
        viewPanel.add(studentsTable, gbc);
        viewPanel.add(viewButtonsPanel, gbc);
    }

    public JPanel getViewPanel(){
        return viewPanel;
    }

    public class firstPageButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            int recordsAmount = Integer.valueOf(changeRecordsAmountCombobox.getSelectedItem().toString());

            if(currentDataList.size()>=recordsAmount) {
                studentsTableModel.fillTable(currentDataList.subList(0, recordsAmount));
            }else{
                studentsTableModel.fillTable(currentDataList);
            }

            currentPage = 0;
            setJLabel();
            studentsTable.updateUI();
        }
    }

    public class previousPageButtonActionLIstener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

            int recordsAmount = Integer.valueOf(changeRecordsAmountCombobox.getSelectedItem().toString());

            if(currentPage>0) {

                if(currentDataList.size()>=((currentPage - 1)*recordsAmount + recordsAmount)) {
                    studentsTableModel.fillTable(currentDataList.subList(((currentPage - 1)*recordsAmount),
                            ((currentPage - 1)*recordsAmount + recordsAmount)));
                }else{
                    studentsTableModel.fillTable(currentDataList.subList(((currentPage - 1)*recordsAmount),
                            currentDataList.size()));
                }

                currentPage--;
                setJLabel();
                studentsTable.updateUI();
            }else{
                JOptionPane.showMessageDialog(null, "First page");
            }
        }
    }

    public class nextPageButtonActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

            int recordsAmount = Integer.valueOf(changeRecordsAmountCombobox.getSelectedItem().toString());

            if(currentPage<getLastPageNumberInt()) {

                if(currentDataList.size()>=((currentPage + 1)*recordsAmount + recordsAmount)) {
                    studentsTableModel.fillTable(currentDataList.subList(((currentPage + 1)*recordsAmount),
                            ((currentPage + 1)*recordsAmount + recordsAmount)));
                }else{
                    studentsTableModel.fillTable(currentDataList.subList(((currentPage + 1)*recordsAmount),
                            currentDataList.size()));
                }

                currentPage++;
                setJLabel();
                studentsTable.updateUI();
            }else{
                JOptionPane.showMessageDialog(null, "Last page");
            }
        }
    }

    public class lastPageButtonActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

            int recordsAmount = Integer.valueOf(changeRecordsAmountCombobox.getSelectedItem().toString());

            studentsTableModel.fillTable(currentDataList.subList((getLastPageNumberInt() * recordsAmount),
                    currentDataList.size()));
            currentPage = getLastPageNumberInt();
            setJLabel();
            studentsTable.updateUI();
        }
    }

    public class changeRecordsAmountComboboxActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

            int recordsAmount = Integer.valueOf(changeRecordsAmountCombobox.getSelectedItem().toString());

            studentsTableModel.fillTable(currentDataList.subList(0, recordsAmount));

            currentPage = 0;

            setJLabel();
            studentsTable.updateUI();
        }
    }

    public JButton getFirstPageButton(){
        return firstPageButton;
    }
}
