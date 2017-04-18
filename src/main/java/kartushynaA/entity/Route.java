package kartushynaA.entity;

/**
 * Created by Анна on 18.04.2017.
 */
public class Route {
    private int id;
    private int numberOfRoute;

    public Route() {
    }

    public Route(int id, int numberOfRoute) {
        this.id = id;
        this.numberOfRoute = numberOfRoute;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberOfRoute() {
        return numberOfRoute;
    }

    public void setNumberOfRoute(int numberOfRoute) {
        this.numberOfRoute = numberOfRoute;
    }
}
