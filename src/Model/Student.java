package Model;


public class Student {

    private Parent father = new Parent();
    private Parent mother = new Parent();

    private String name;
    private String surname;
    private String lastname;
    private int brothersAmount;
    private int sistersAmount;


    public Student(String studentName, String studentSurname, String studentLastname, String fatherName,
                   String fatherSurname, String fatherLastname, int fatherSalary,
                   String motherName, String motherSurname, String motherLastname, int motherSalary,
                   int brothersAmount, int sistersAmount){

        this.name = studentName;
        this.surname = studentSurname;
        this.lastname = studentLastname;
        father.setName(fatherName);
        father.setSurname(fatherSurname);
        father.setLastname(fatherLastname);
        father.setSalary(fatherSalary);
        mother.setName(motherName);
        mother.setSurname(motherSurname);
        mother.setLastname(motherLastname);
        mother.setSalary(motherSalary);
        this.brothersAmount = brothersAmount;
        this.sistersAmount = sistersAmount;
    }


    public Parent getFather() {
        return father;
    }

    public Parent getMother() {
        return mother;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getBrothersAmount() {
        return brothersAmount;
    }

    public int getSistersAmount() {
        return sistersAmount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setBrothersAmount(int brothersAmount) {
        this.brothersAmount = brothersAmount;
    }

    public void setSistersAmount(int sistersAmount) {
        this.sistersAmount = sistersAmount;
    }
}
