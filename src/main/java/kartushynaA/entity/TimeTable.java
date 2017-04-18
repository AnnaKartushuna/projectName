package kartushynaA.entity;

/**
 * Created by Анна on 18.04.2017.
 */
public class TimeTable {
    private int id;
    private String dayOfMonth;
    private int idEmployee;
    private int idVehicle;
    private int idDaileOrder;

    public TimeTable() {
    }

    public TimeTable(int id, String dayOfMonth, int idEmployee, int idVehicle, int idDaileOrder) {
        this.id = id;
        this.dayOfMonth = dayOfMonth;
        this.idEmployee = idEmployee;
        this.idVehicle = idVehicle;
        this.idDaileOrder = idDaileOrder;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(String dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public int getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(int idVehicle) {
        this.idVehicle = idVehicle;
    }

    public int getIdDaileOrder() {
        return idDaileOrder;
    }

    public void setIdDaileOrder(int idDaileOrder) {
        this.idDaileOrder = idDaileOrder;
    }
}
