package Controller;

import Model.Student;
import Model.WorkWithDocument;

import java.util.ArrayList;

public class PageManagment {

    private WorkWithDocument workWithDocument;

    public PageManagment(WorkWithDocument workWithDocument){
        this.workWithDocument = workWithDocument;
    }

    public ArrayList<Student> generatePage(ArrayList<Student> dataArrayList, int pageNumber, int recordsAmount){

        ArrayList<Student> page = new ArrayList<>();

        int currentRecord = pageNumber * recordsAmount - 1;
        int lastRecord = pageNumber * recordsAmount + recordsAmount;

        for(currentRecord = 0; currentRecord<lastRecord; currentRecord++){

            if (currentRecord<dataArrayList.size()) {
                page.add(dataArrayList.get(currentRecord));
            }else{
                return page;
            }

        }

        return page;
    }
}
