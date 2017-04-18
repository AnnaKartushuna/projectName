package kartushynaA.entity;

/**
 * Created by Анна on 18.04.2017.
 */
public class Absent {
    private int id;
    private String dayOfWeek;
    private String reason;
    private int idEmployee;

    public Absent() {
    }

    public Absent(int id, String dayOfWeek, String reason, int idEmployee) {
        this.id = id;
        this.dayOfWeek = dayOfWeek;
        this.reason = reason;
        this.idEmployee = idEmployee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }
}
