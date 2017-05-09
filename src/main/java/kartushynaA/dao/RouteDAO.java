package kartushynaA.dao;

import kartushynaA.entity.Route;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Анна on 08.05.2017.
 */
public class RouteDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/mainAcad";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1444";
    private static final String NEW = "INSERT INTO Route VALUES(id = null, password = ?, name = ?, login = ?)";
    private static final String ALL = "SELECT * FROM Route";
    private static final String ID = "SELECT * FROM Route WHERE id = ?";
    private static final String UPDATE = "UPDATE Route SET password = ?, name = ?, login = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM Route WHERE  id = ?";

    public List<Route> getAllRoute(){
        List <Route> allRoute = new ArrayList<Route>();
        try {
            Connection connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement ps = connect.prepareStatement(ALL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                int id = rs.getInt("id");
                int numberOfRoute = rs.getInt("numberOfRoute");
                allRoute.add(new Route(id, numberOfRoute));
            }
            rs.close();
            ps.close();
            connect.close();

        } catch (SQLException e) {
            System.out.print("can't getAllNumOfOrder");
            e.printStackTrace();
            return new ArrayList<Route>();
        }
        return allRoute;
    }

    public Route getRouteById(int id){
        ResultSet rs = null;
        try {
            Connection connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement ps = null;
            ps = connect.prepareStatement(ID);
            ps.setInt(1,id);
            rs.next();
            rs.close();
            ps.close();
            connect.close();
            return new Route(rs.getInt(1),rs.getInt(2));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void saveNewRoute (Route newRoute){
        try {
            Connection connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement ps = null;
            ps = connect.prepareStatement(NEW);
            ps.setInt(1, newRoute.getId());
            ps.setInt(1, newRoute.getNumberOfRoute());
            ps.executeUpdate();
            ps.close();
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAllRoute(Route allRoute){
        try {
            Connection connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement ps = null;
            ps = connect.prepareStatement(UPDATE);
            ps.setInt(1, allRoute.getId());
            ps.setInt(1, allRoute.getNumberOfRoute());
            ps.executeUpdate();
            ps.close();
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteOldRoute (Route oldRoute){
        try {
            Connection connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement ps = null;
            ps = connect.prepareStatement(DELETE);
            ps.setInt(1, oldRoute.getId());
            ps.executeUpdate();
            ps.close();
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
