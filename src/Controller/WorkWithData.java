package Controller;


import Model.Student;
import Model.WorkWithDocument;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class WorkWithData {

    private List<Student> searchDataList;
    private WorkWithDocument workWithDocument;

    public List<Student> getSearchDataList(){
        return searchDataList;
    }

    public WorkWithData(WorkWithDocument workWithDocument){
        this.workWithDocument = workWithDocument;
    }

    public List<Student> searchStudentByLastname(String Lastname, int whoseName){

        List<Student> findedByName = new ArrayList<>();
        final int STUDENT_LASTNAME = 0;
        final int FATHER_LASTNAME = 1;
        final int MOTHER_LASTNAME = 2;

        switch (whoseName){
            case STUDENT_LASTNAME:{

                for(int namesCounter = 0; namesCounter<workWithDocument.getDataList().size(); namesCounter++){

                    if(workWithDocument.getDataList().get(namesCounter).getLastname().equals(Lastname)){

                        findedByName.add(workWithDocument.getDataList().get(namesCounter));
                    }

                }
                break;
            }
            case FATHER_LASTNAME:{

                for(int namesCounter = 0; namesCounter<workWithDocument.getDataList().size(); namesCounter++){

                    if(workWithDocument.getDataList().get(namesCounter).getFather().getLastname().equals(Lastname)){

                        findedByName.add(workWithDocument.getDataList().get(namesCounter));
                    }

                }
                break;
            }
            case MOTHER_LASTNAME:{

                for(int namesCounter = 0; namesCounter<workWithDocument.getDataList().size(); namesCounter++){

                    if(workWithDocument.getDataList().get(namesCounter).getMother().getLastname().equals(Lastname)){

                        findedByName.add(workWithDocument.getDataList().get(namesCounter));
                    }

                }
                break;
            }
        }

        searchDataList = findedByName;
        return findedByName;
    }

    public List<Student> searchStudentBySalary(int minSalary, int maxSalary, int whoseSalary){

        List<Student> findedBySalary = new ArrayList<>();
        final int FATHER_SALARY = 0;
        final int MOTHER_SALARY = 1;

        switch (whoseSalary){
            case FATHER_SALARY:{

                for(int salaryCounter = 0; salaryCounter<workWithDocument.getDataList().size(); salaryCounter++){

                    if(workWithDocument.getDataList().get(salaryCounter).getFather().getSalary()>minSalary &&
                            workWithDocument.getDataList().get(salaryCounter).getFather().getSalary()<maxSalary){

                        findedBySalary.add(workWithDocument.getDataList().get(salaryCounter));
                    }

                }
                break;
            }
            case MOTHER_SALARY:{

                for(int salaryCounter = 0; salaryCounter<workWithDocument.getDataList().size(); salaryCounter++){

                    if(workWithDocument.getDataList().get(salaryCounter).getMother().getSalary()>minSalary &&
                            workWithDocument.getDataList().get(salaryCounter).getFather().getSalary()<maxSalary){

                        findedBySalary.add(workWithDocument.getDataList().get(salaryCounter));
                    }

                }
                break;
            }
        }

        searchDataList = findedBySalary;
        return findedBySalary;
    }

    public List<Student> searchStudentByAmount(int amount, int amountOfWhat){

        List<Student> findedByAmountOfFamilyMembers = new ArrayList<>();
        final int BROTHERS_AMOUNT = 0;
        final int SISTERS_AMOUNT = 1;

        switch(amountOfWhat){
            case BROTHERS_AMOUNT:{

                for(int familyMembersCounter = 0; familyMembersCounter<workWithDocument.getDataList().size(); familyMembersCounter++){

                    if(workWithDocument.getDataList().get(familyMembersCounter).getBrothersAmount() == amount){

                        findedByAmountOfFamilyMembers.add(workWithDocument.getDataList().get(familyMembersCounter));
                    }

                }
                break;
            }
            case SISTERS_AMOUNT:{

                for(int familyMembersCounter = 0; familyMembersCounter<workWithDocument.getDataList().size(); familyMembersCounter++){

                    if(workWithDocument.getDataList().get(familyMembersCounter).getSistersAmount() == amount){

                        findedByAmountOfFamilyMembers.add(workWithDocument.getDataList().get(familyMembersCounter));
                    }

                }
                break;
            }
        }

        searchDataList = findedByAmountOfFamilyMembers;
        return findedByAmountOfFamilyMembers;
    }

    public void deleteStudent(List<Student> findedBy, int deletionParameter, int deletionParameterField){

        int numberOfDeletedRecords = 0;

        final int LASTNAME = 0;
        final int SALARY = 1;
        final int AMOUNT = 2;

        final int STUDENT_LASTNAME = 0;
        final int FATHER_LASTNAME = 1;
        final int MOTHER_LASTNAME = 2;

        final int FATHER_SALARY = 0;
        final int MOTHER_SALARY = 1;

        final int BROTHERS_AMOUNT = 0;
        final int SISTERS_AMOUNT = 1;

        switch(deletionParameter) {

            case LASTNAME: {

                switch (deletionParameterField) {

                    case STUDENT_LASTNAME: {

                        for (int findedListCounter = 0; findedListCounter < findedBy.size(); findedListCounter++) {

                            for (int allStudentsListCounter = 0; allStudentsListCounter < workWithDocument.getDataList().size(); allStudentsListCounter++) {

                                if (findedBy.get(findedListCounter).getLastname().
                                        equals(workWithDocument.getDataList().get(allStudentsListCounter).getLastname())) {
                                    workWithDocument.getDataList().remove(allStudentsListCounter);
                                    numberOfDeletedRecords++;
                                }

                            }

                        }
                        break;
                    }

                    case FATHER_LASTNAME: {

                        for (int findedListCounter = 0; findedListCounter < findedBy.size(); findedListCounter++) {

                            for (int allStudentsListCounter = 0; allStudentsListCounter < workWithDocument.getDataList().size(); allStudentsListCounter++) {

                                if (findedBy.get(findedListCounter).getFather().getLastname().
                                        equals(workWithDocument.getDataList().get(allStudentsListCounter).getFather().getLastname())) {
                                    workWithDocument.getDataList().remove(allStudentsListCounter);
                                    numberOfDeletedRecords++;
                                }

                            }

                        }
                        break;
                    }
                    case MOTHER_LASTNAME: {
                        for (int findedListCounter = 0; findedListCounter < findedBy.size(); findedListCounter++) {

                            for (int allStudentsListCounter = 0; allStudentsListCounter < workWithDocument.getDataList().size(); allStudentsListCounter++) {

                                if (findedBy.get(findedListCounter).getMother().getLastname().
                                        equals(workWithDocument.getDataList().get(allStudentsListCounter).getMother().getLastname())) {
                                    workWithDocument.getDataList().remove(allStudentsListCounter);
                                    numberOfDeletedRecords++;
                                }

                            }

                        }
                        break;
                    }
                }

                break;
            }

            case SALARY: {

                switch (deletionParameterField) {

                    case FATHER_SALARY: {

                        for (int findedListCounter = 0; findedListCounter < findedBy.size(); findedListCounter++) {

                            for (int allStudentsListCounter = 0; allStudentsListCounter < workWithDocument.getDataList().size(); allStudentsListCounter++) {

                                if (findedBy.get(findedListCounter).getFather().getSalary() ==
                                        (workWithDocument.getDataList().get(allStudentsListCounter).getFather().getSalary())) {
                                    workWithDocument.getDataList().remove(allStudentsListCounter);
                                    numberOfDeletedRecords++;
                                }

                            }

                        }
                        break;
                    }
                    case MOTHER_SALARY: {

                        for (int findedListCounter = 0; findedListCounter < findedBy.size(); findedListCounter++) {

                            for (int allStudentsListCounter = 0; allStudentsListCounter < workWithDocument.getDataList().size(); allStudentsListCounter++) {

                                if (findedBy.get(findedListCounter).getMother().getSalary() ==
                                        (workWithDocument.getDataList().get(allStudentsListCounter).getMother().getSalary())) {
                                    workWithDocument.getDataList().remove(allStudentsListCounter);
                                    numberOfDeletedRecords++;
                                }

                            }

                        }
                        break;
                    }

                }

                break;
            }

            case AMOUNT: {

                switch (deletionParameterField) {

                    case BROTHERS_AMOUNT: {

                        for (int findedListCounter = 0; findedListCounter < findedBy.size(); findedListCounter++) {

                            for (int allStudentsListCounter = 0; allStudentsListCounter < workWithDocument.getDataList().size(); allStudentsListCounter++) {

                                if (findedBy.get(findedListCounter).getBrothersAmount() ==
                                        (workWithDocument.getDataList().get(allStudentsListCounter).getBrothersAmount())) {
                                    workWithDocument.getDataList().remove(allStudentsListCounter);
                                    numberOfDeletedRecords++;
                                }

                            }

                        }
                        break;
                    }
                    case SISTERS_AMOUNT: {

                        for (int findedListCounter = 0; findedListCounter < findedBy.size(); findedListCounter++) {

                            for (int allStudentsListCounter = 0; allStudentsListCounter < workWithDocument.getDataList().size(); allStudentsListCounter++) {

                                if (findedBy.get(findedListCounter).getSistersAmount() ==
                                        (workWithDocument.getDataList().get(allStudentsListCounter).getSistersAmount())) {
                                    workWithDocument.getDataList().remove(allStudentsListCounter);
                                    numberOfDeletedRecords++;
                                }

                            }

                        }
                        break;
                    }

                }

                break;
            }
        }

        JOptionPane.showMessageDialog(null, numberOfDeletedRecords + " item was deleted!");
    }

    public void addStudent(String studentName, String studentSurname, String studentLastname, String fatherName,
                           String fatherSurname, String fatherLastname, int fatherSalary,
                           String motherName, String motherSurname, String motherLastname, int motherSalary,
                           int brothersAmount, int sistersAmount){

        workWithDocument.getDataList().add(new Student(studentName, studentSurname, studentLastname, fatherName,
                fatherSurname, fatherLastname, fatherSalary, motherName, motherSurname, motherLastname, motherSalary,
                brothersAmount, sistersAmount));

        JOptionPane.showMessageDialog(null, "Студент " + studentName +
                " был добавлен. Теперь в вашем списке " + workWithDocument.getDataList().size() + " студент(ов).");
    }
}
