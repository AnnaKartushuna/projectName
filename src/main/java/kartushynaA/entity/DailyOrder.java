package kartushynaA.entity;

/**
 * Created by Анна on 18.04.2017.
 */
public class DailyOrder {
    private int id;
    private int idRoute;
    private int idNumOoOrder;
    private int idTurn;
    private int startTime;

    public DailyOrder() {
    }

    public DailyOrder(int id, int idRoute, int idNumOoOrder, int idTurn, int startTime) {
        this.id = id;
        this.idRoute = idRoute;
        this.idNumOoOrder = idNumOoOrder;
        this.idTurn = idTurn;
        this.startTime = startTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdRoute() {
        return idRoute;
    }

    public void setIdRoute(int idRoute) {
        this.idRoute = idRoute;
    }

    public int getIdNumOoOrder() {
        return idNumOoOrder;
    }

    public void setIdNumOoOrder(int idNumOoOrder) {
        this.idNumOoOrder = idNumOoOrder;
    }

    public int getIdTurn() {
        return idTurn;
    }

    public void setIdTurn(int idTurn) {
        this.idTurn = idTurn;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }
}
