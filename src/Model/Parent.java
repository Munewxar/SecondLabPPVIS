package Model;

public class Parent {

    private String name;
    private String surname;
    private String lastname;
    private int salary;

    public String getSurname() {
        return surname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }
}
