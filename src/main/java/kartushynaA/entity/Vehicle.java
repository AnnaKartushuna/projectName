package kartushynaA.entity;

/**
 * Created by Анна on 18.04.2017.
 */
public class Vehicle {
    private int id;
    private int bortNumber;

    public Vehicle() {
    }

    public Vehicle(int id, int bortNumber) {
        this.id = id;
        this.bortNumber = bortNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBortNumber() {
        return bortNumber;
    }

    public void setBortNumber(int bortNumber) {
        this.bortNumber = bortNumber;
    }

}
