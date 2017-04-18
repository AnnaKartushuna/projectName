package kartushynaA.entity;

/**
 * Created by Анна on 18.04.2017.
 */
public class Employee {
    private int id;
    private String name;
    private String surName;
    private String lastName;
    private int personelNumber;

    public Employee() {
    }

    public Employee(int id, String name, String surName, String lastName, int personelNumber) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.lastName = lastName;
        this.personelNumber = personelNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPersonelNumber() {
        return personelNumber;
    }

    public void setPersonelNumber(int personelNumber) {
        this.personelNumber = personelNumber;
    }
}
