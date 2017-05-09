package kartushynaA.dao;

import kartushynaA.entity.Vehicle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Анна on 08.05.2017.
 */
public class VehicleDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/mainAcad";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1444";
    private static final String NEW = "INSERT INTO Vehicle VALUES(id = null, password = ?, name = ?, login = ?)";
    private static final String ALL = "SELECT * FROM Vehicle";
    private static final String ID = "SELECT * FROM Vehicle WHERE id = ?";
    private static final String UPDATE = "UPDATE Vehicle SET password = ?, name = ?, login = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM Vehicle WHERE  id = ?";

    public List<Vehicle> getAllVehicle(){
        List <Vehicle> allVehicle = new ArrayList<Vehicle>();
        try {
            Connection connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement ps = connect.prepareStatement(ALL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                int id = rs.getInt("id");
                int bortNumber = rs.getInt("bortNumber");
                allVehicle.add(new Vehicle(id, bortNumber));
            }
            rs.close();
            ps.close();
            connect.close();

        } catch (SQLException e) {
            System.out.print("can't getAllNumOfOrder");
            e.printStackTrace();
            return new ArrayList<Vehicle>();
        }
        return allVehicle;
    }

    public Vehicle getVehicleById(int id){
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
            return new Vehicle(rs.getInt(1),rs.getInt(2));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void saveNewVehicle(Vehicle newVehicle){
        try {
            Connection connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement ps = null;
            ps = connect.prepareStatement(NEW);
            ps.setInt(1, newVehicle.getId());
            ps.setInt(1, newVehicle.getBortNumber());
            ps.executeUpdate();
            ps.close();
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAllVehicle(Vehicle allVehicle){
        try {
            Connection connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement ps = null;
            ps = connect.prepareStatement(UPDATE);
            ps.setInt(1, allVehicle.getId());
            ps.setInt(1, allVehicle.getBortNumber());
            ps.executeUpdate();
            ps.close();
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteOldVehicle (Vehicle oldVehicle){
        try {
            Connection connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement ps = null;
            ps = connect.prepareStatement(DELETE);
            ps.setInt(1, oldVehicle.getId());
            ps.executeUpdate();
            ps.close();
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

