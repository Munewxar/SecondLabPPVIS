package View;

import Model.WorkWithDocument;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame {

    private JFrame mainFrame = new JFrame("Second Lab PPVIS");
    private JButton buttonForSearchDialog = new JButton("Search");
    private JButton buttonForAddDialog = new JButton("Add");
    private JButton buttonForDeleteDialog = new JButton("Delete");

    private WorkWithDocument workWithDocument = new WorkWithDocument();
    private StudentsTable studentsTable = new StudentsTable(workWithDocument.getDataList());

    private Frame buildMainFrame(){

        mainFrame.setSize(900, 300);
        mainFrame.setLayout(new FlowLayout());
        mainFrame.setDefaultCloseOperation(3);
        mainFrame.setLocationRelativeTo(null);

        mainFrame.add(createMenuBar());

        mainFrame.add(studentsTable.getViewPanel());

        buttonForSearchDialog.addActionListener(new buttonForSearchDialogActionListener());
        mainFrame.add(buttonForSearchDialog);

        buttonForAddDialog.addActionListener(new buttonForAddDialogActionListener());
        mainFrame.add(buttonForAddDialog);

        buttonForDeleteDialog.addActionListener(new buttonForDeleteDialogActionListener());
        mainFrame.add(buttonForDeleteDialog);

        return mainFrame;
    }

    private class buttonForSearchDialogActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            SearchDialog searchDialog = new SearchDialog(mainFrame, workWithDocument);
        }
    }

    private class buttonForAddDialogActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            AddDialog addDialog = new AddDialog(mainFrame, workWithDocument, studentsTable);
        }
    }

    private class buttonForDeleteDialogActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            DeleteDialog deleteDialog = new DeleteDialog(mainFrame, workWithDocument, studentsTable);
        }
    }

    private JMenuBar createMenuBar(){

        JMenuBar menuBar = new JMenuBar();

        JMenu file = new JMenu("Файл");
        JMenuItem open = new JMenuItem("Открыть");
        JMenuItem save = new JMenuItem("Сохранить");

        JMenu data = new JMenu("Данные");
        JMenuItem add = new JMenuItem("Добавить");
        JMenuItem search = new JMenuItem("Поиск");
        JMenuItem delete = new JMenuItem("Удалить");

        file.add(open);
        file.add(save);

        data.add(search);
        data.add(add);
        data.add(delete);

        menuBar.add(file);
        menuBar.add(data);

        open.addActionListener(new openMenuItemActionListener());
        save.addActionListener(new saveMenuItemActionListener());

        add.addActionListener(new buttonForAddDialogActionListener());
        search.addActionListener(new buttonForSearchDialogActionListener());
        delete.addActionListener(new buttonForDeleteDialogActionListener());

        menuBar.add(Box.createHorizontalGlue());

        return menuBar;
    }

    public class openMenuItemActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Выбор файла");

            if(fileChooser.showOpenDialog(mainFrame) == JFileChooser.APPROVE_OPTION){

                workWithDocument.openDocument(fileChooser.getSelectedFile());

            }else{
                JOptionPane.showMessageDialog(null, "Выберите файл!");
            }
        }
    }

    public class saveMenuItemActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Выбор файла");

            if(fileChooser.showOpenDialog(mainFrame) == JFileChooser.APPROVE_OPTION){

                workWithDocument.saveToDocument(fileChooser.getSelectedFile());

            }else{
                JOptionPane.showMessageDialog(null, "Выберите файл!");
            }
        }
    }

    public static void main(String[] args) {
        Frame mainFrameObject = new MainFrame().buildMainFrame();
        mainFrameObject.setVisible(true);
        mainFrameObject.setResizable(false);
    }
}
