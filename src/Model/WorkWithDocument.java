package Model;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.util.Random;

public class WorkWithDocument {

    private List<Student> dataList = new ArrayList<>();

    public List<Student> getDataList(){
        return dataList;
    }

    public WorkWithDocument(){
        File file = new File("Students Table.xml");
        openDocument(file);
        randomDocumentFilling();
    }

    public void openDocument(File file){
        try {

            dataList.clear();

            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(file);

            Node allStudentsAmount = document.getDocumentElement();
            NodeList differentStudents = allStudentsAmount.getChildNodes();

            for(int differentStudentsAmount = 0; differentStudentsAmount<differentStudents.getLength(); differentStudentsAmount++){

                Node singleStudent = differentStudents.item(differentStudentsAmount);

                if(singleStudent.getNodeType() != Node.TEXT_NODE){

                    NodeList singleStudentInfo = singleStudent.getChildNodes();
                    Node fatherInfo = singleStudentInfo.item(7);

                    singleStudentInfo.item(6).getTextContent();
                    singleStudentInfo.item(6).getNodeType();

                    Student student = new Student(singleStudentInfo.item(1).getTextContent(),
                            singleStudentInfo.item(3).getTextContent(),
                            singleStudentInfo.item(5).getTextContent(),
                            singleStudentInfo.item(7).getChildNodes().item(1).getTextContent(),
                            singleStudentInfo.item(7).getChildNodes().item(3).getTextContent(),
                            singleStudentInfo.item(7).getChildNodes().item(5).getTextContent(),
                            Integer.valueOf(singleStudentInfo.item(7).getChildNodes().item(7).getTextContent()),
                            singleStudentInfo.item(9).getChildNodes().item(1).getTextContent(),
                            singleStudentInfo.item(9).getChildNodes().item(3).getTextContent(),
                            singleStudentInfo.item(9).getChildNodes().item(5).getTextContent(),
                            Integer.valueOf(singleStudentInfo.item(9).getChildNodes().item(7).getTextContent()),
                            Integer.valueOf(singleStudentInfo.item(11).getTextContent()),
                            Integer.valueOf(singleStudentInfo.item(13).getTextContent()));

                    dataList.add(student);
                }
            }

        } catch (ParserConfigurationException ex) {
            ex.printStackTrace(System.out);
        } catch (SAXException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public void saveToDocument(File file){

        try(FileWriter fileWriter = new FileWriter(file, false)){

            String beginningCode = "<?xml version = \"1.0\" encoding = \"UTF-8\"?>\n";
            fileWriter.write(beginningCode);
            String openTableTag = "<StudentsTable>\n";
            fileWriter.append(openTableTag);

            for(int studentsCounter = 0; studentsCounter< dataList.size(); studentsCounter++){

                fileWriter.append("\t<Student>\n");

                fileWriter.append(new StringBuffer("\t\t<name>")
                        .append(dataList.get(studentsCounter).getName())
                        .append("</name>\n")
                        .append("\t\t<surname>")
                        .append(dataList.get(studentsCounter).getSurname())
                        .append("</surname>\n")
                        .append("\t\t<lastname>")
                        .append(dataList.get(studentsCounter).getLastname())
                        .append("</lastname>\n")
                        .append("\n\t\t<father>\n")
                        .append("\t\t\t<name>")
                        .append(dataList.get(studentsCounter).getFather().getName())
                        .append("</name>\n")
                        .append("\t\t\t<surname>")
                        .append(dataList.get(studentsCounter).getFather().getSurname())
                        .append("</surname>\n")
                        .append("\t\t\t<lastname>")
                        .append(dataList.get(studentsCounter).getFather().getLastname())
                        .append("</lastname>\n")
                        .append("\t\t\t<salary>")
                        .append(dataList.get(studentsCounter).getFather().getSalary())
                        .append("</salary>\n")
                        .append("\t\t</father>\n")
                        .append("\n\t\t<mother>\n")
                        .append("\t\t\t<name>")
                        .append(dataList.get(studentsCounter).getMother().getName())
                        .append("</name>\n")
                        .append("\t\t\t<surname>")
                        .append(dataList.get(studentsCounter).getMother().getSurname())
                        .append("</surname>\n")
                        .append("\t\t\t<lastname>")
                        .append(dataList.get(studentsCounter).getMother().getLastname())
                        .append("</lastname>\n")
                        .append("\t\t\t<salary>")
                        .append(dataList.get(studentsCounter).getMother().getSalary())
                        .append("</salary>\n")
                        .append("\t\t</mother>\n")
                        .append("\n\t\t<brothersAmount>")
                        .append(dataList.get(studentsCounter).getBrothersAmount())
                        .append("</brothersAmount>\n")
                        .append("\t\t<sistersAmount>")
                        .append(dataList.get(studentsCounter).getSistersAmount())
                        .append("</sistersAmount>\n").toString());

                fileWriter.append("\t</Student>\n");
            }

            fileWriter.append("</StudentsTable>");

        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void randomDocumentFilling(){

        Random random = new Random();

        for(int dataListRecordsCounter = 0; dataListRecordsCounter<dataList.size(); dataListRecordsCounter++) {

            int randomLastName = random.nextInt(12);

            switch (randomLastName){
                case 0:{
                    dataList.get(dataListRecordsCounter).setLastname("Красько");
                    dataList.get(dataListRecordsCounter).getFather().setLastname("Красько");
                    dataList.get(dataListRecordsCounter).getFather().setSalary(random.nextInt(800000));
                    dataList.get(dataListRecordsCounter).getMother().setLastname("Красько");
                    dataList.get(dataListRecordsCounter).getMother().setSalary(random.nextInt(800000));
                    dataList.get(dataListRecordsCounter).setBrothersAmount(random.nextInt(5));
                    dataList.get(dataListRecordsCounter).setSistersAmount(random.nextInt(5));
                    break;
                }
                case 1:{
                    dataList.get(dataListRecordsCounter).setLastname("Мисько");
                    dataList.get(dataListRecordsCounter).getFather().setLastname("Мисько");
                    dataList.get(dataListRecordsCounter).getFather().setSalary(random.nextInt(800000));
                    dataList.get(dataListRecordsCounter).getMother().setLastname("Мисько");
                    dataList.get(dataListRecordsCounter).getMother().setSalary(random.nextInt(800000));
                    dataList.get(dataListRecordsCounter).setBrothersAmount(random.nextInt(5));
                    dataList.get(dataListRecordsCounter).setSistersAmount(random.nextInt(5));
                    break;
                }
                case 2:{
                    dataList.get(dataListRecordsCounter).setLastname("Луцка");
                    dataList.get(dataListRecordsCounter).getFather().setLastname("Луцка");
                    dataList.get(dataListRecordsCounter).getFather().setSalary(random.nextInt(800000));
                    dataList.get(dataListRecordsCounter).getMother().setLastname("Луцка");
                    dataList.get(dataListRecordsCounter).getMother().setSalary(random.nextInt(800000));
                    dataList.get(dataListRecordsCounter).setBrothersAmount(random.nextInt(5));
                    dataList.get(dataListRecordsCounter).setSistersAmount(random.nextInt(5));
                    break;
                }
                case 3:{
                    dataList.get(dataListRecordsCounter).setLastname("Иванько");
                    dataList.get(dataListRecordsCounter).getFather().setLastname("Иванько");
                    dataList.get(dataListRecordsCounter).getFather().setSalary(random.nextInt(800000));
                    dataList.get(dataListRecordsCounter).getMother().setLastname("Иванько");
                    dataList.get(dataListRecordsCounter).getMother().setSalary(random.nextInt(800000));
                    dataList.get(dataListRecordsCounter).setBrothersAmount(random.nextInt(5));
                    dataList.get(dataListRecordsCounter).setSistersAmount(random.nextInt(5));
                    break;
                }
                case 4:{
                    dataList.get(dataListRecordsCounter).setLastname("Замко");
                    dataList.get(dataListRecordsCounter).getFather().setLastname("Замко");
                    dataList.get(dataListRecordsCounter).getFather().setSalary(random.nextInt(800000));
                    dataList.get(dataListRecordsCounter).getMother().setLastname("Замко");
                    dataList.get(dataListRecordsCounter).getMother().setSalary(random.nextInt(800000));
                    dataList.get(dataListRecordsCounter).setBrothersAmount(random.nextInt(5));
                    dataList.get(dataListRecordsCounter).setSistersAmount(random.nextInt(5));
                    break;
                }
                case 5:{
                    dataList.get(dataListRecordsCounter).setLastname("Крапко");
                    dataList.get(dataListRecordsCounter).getFather().setLastname("Крапко");
                    dataList.get(dataListRecordsCounter).getFather().setSalary(random.nextInt(800000));
                    dataList.get(dataListRecordsCounter).getMother().setLastname("Крапко");
                    dataList.get(dataListRecordsCounter).getMother().setSalary(random.nextInt(800000));
                    dataList.get(dataListRecordsCounter).setBrothersAmount(random.nextInt(5));
                    dataList.get(dataListRecordsCounter).setSistersAmount(random.nextInt(5));
                    break;
                }
                case 6:{
                    dataList.get(dataListRecordsCounter).setLastname("Лапко");
                    dataList.get(dataListRecordsCounter).getFather().setLastname("Лапко");
                    dataList.get(dataListRecordsCounter).getFather().setSalary(random.nextInt(800000));
                    dataList.get(dataListRecordsCounter).getMother().setLastname("Лапко");
                    dataList.get(dataListRecordsCounter).getMother().setSalary(random.nextInt(800000));
                    dataList.get(dataListRecordsCounter).setBrothersAmount(random.nextInt(5));
                    dataList.get(dataListRecordsCounter).setSistersAmount(random.nextInt(5));
                    break;
                }
                case 7:{
                    dataList.get(dataListRecordsCounter).setLastname("Дерябко");
                    dataList.get(dataListRecordsCounter).getFather().setLastname("Дерябко");
                    dataList.get(dataListRecordsCounter).getFather().setSalary(random.nextInt(800000));
                    dataList.get(dataListRecordsCounter).getMother().setLastname("Дерябко");
                    dataList.get(dataListRecordsCounter).getMother().setSalary(random.nextInt(800000));
                    dataList.get(dataListRecordsCounter).setBrothersAmount(random.nextInt(5));
                    dataList.get(dataListRecordsCounter).setSistersAmount(random.nextInt(5));
                    break;
                }
                case 8:{
                    dataList.get(dataListRecordsCounter).setLastname("Маканько");
                    dataList.get(dataListRecordsCounter).getFather().setLastname("Маканько");
                    dataList.get(dataListRecordsCounter).getFather().setSalary(random.nextInt(800000));
                    dataList.get(dataListRecordsCounter).getMother().setLastname("Маканько");
                    dataList.get(dataListRecordsCounter).getMother().setSalary(random.nextInt(800000));
                    dataList.get(dataListRecordsCounter).setBrothersAmount(random.nextInt(5));
                    dataList.get(dataListRecordsCounter).setSistersAmount(random.nextInt(5));
                    break;
                }
                case 9:{
                    dataList.get(dataListRecordsCounter).setLastname("Лапатько");
                    dataList.get(dataListRecordsCounter).getFather().setLastname("Лапатько");
                    dataList.get(dataListRecordsCounter).getFather().setSalary(random.nextInt(800000));
                    dataList.get(dataListRecordsCounter).getMother().setLastname("Лапатько");
                    dataList.get(dataListRecordsCounter).getMother().setSalary(random.nextInt(800000));
                    dataList.get(dataListRecordsCounter).setBrothersAmount(random.nextInt(5));
                    dataList.get(dataListRecordsCounter).setSistersAmount(random.nextInt(5));
                    break;
                }
                case 10:{
                    dataList.get(dataListRecordsCounter).setLastname("Перятько");
                    dataList.get(dataListRecordsCounter).getFather().setLastname("Перятько");
                    dataList.get(dataListRecordsCounter).getFather().setSalary(random.nextInt(800000));
                    dataList.get(dataListRecordsCounter).getMother().setLastname("Перятько");
                    dataList.get(dataListRecordsCounter).getMother().setSalary(random.nextInt(800000));
                    dataList.get(dataListRecordsCounter).setBrothersAmount(random.nextInt(5));
                    dataList.get(dataListRecordsCounter).setSistersAmount(random.nextInt(5));
                    break;
                }
                case 11:{
                    dataList.get(dataListRecordsCounter).setLastname("Малафиенко");
                    dataList.get(dataListRecordsCounter).getFather().setLastname("Малафиенко");
                    dataList.get(dataListRecordsCounter).getFather().setSalary(random.nextInt(800000));
                    dataList.get(dataListRecordsCounter).getMother().setLastname("Малафиенко");
                    dataList.get(dataListRecordsCounter).getMother().setSalary(random.nextInt(800000));
                    dataList.get(dataListRecordsCounter).setBrothersAmount(random.nextInt(5));
                    dataList.get(dataListRecordsCounter).setSistersAmount(random.nextInt(5));
                    break;
                }
            }
        }

    }
}
