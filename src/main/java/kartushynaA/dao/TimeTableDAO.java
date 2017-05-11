package kartushynaA.dao;

import kartushynaA.entity.TimeTable;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Анна on 08.05.2017.
 */
public class TimeTableDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/mainAcad";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1444";
    private static final String NEW = "INSERT INTO TimeTable VALUES(id = null, dayOfMonth = ?, idEmployee = ?, idVehicle = ?, idDaileOrder = ?)";
    private static final String ALL = "SELECT * FROM TimeTable";
    private static final String ID = "SELECT * FROM TimeTable WHERE id = ?";
    private static final String UPDATE = "UPDATE TimeTable SET dayOfMonth = ?, idEmployee = ?, idVehicle = ?, idDaileOrder = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM TimeTable WHERE  id = ?";

    public List<TimeTable> getAllTimeTable(){
        List <TimeTable> allTimeTable = new ArrayList<TimeTable>();
        try {
            Connection connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement ps = connect.prepareStatement(ALL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                int id = rs.getInt("id");
                String dayOfMonth = rs.getString("dayOfMonth");
                int idEmployee = rs.getInt("idEmployee");
                int idVehicle = rs.getInt("idVehicle");
                int idDaileOrder = rs.getInt("idDaileOrder");
                allTimeTable.add(new TimeTable(id, dayOfMonth, idEmployee, idVehicle, idDaileOrder));
            }
            rs.close();
            ps.close();
            connect.close();
        } catch (SQLException e) {
            System.out.print("can't getAllEmployee");
            e.printStackTrace();
            return new ArrayList<TimeTable>();
        }
        return allTimeTable;
    }

    public TimeTable getTimeTableById(int id){
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
            return new TimeTable(rs.getInt(1),rs.getString(2),rs.getInt(3), rs.getInt(4),rs.getInt(5));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void saveNewTimeTable (TimeTable newTimeTable){
        try {
            Connection connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement ps = null;
            ps = connect.prepareStatement(NEW);
            ps.setString(1, newTimeTable.getDayOfMonth());
            ps.setInt(2, newTimeTable.getIdDaileOrder());
            ps.setInt(3, newTimeTable.getIdEmployee());
            ps.setInt(4, newTimeTable.getIdVehicle());
            ps.executeUpdate();
            ps.close();
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAllTimeTable(TimeTable allTimeTable){
        try {
            Connection connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement ps = null;
            ps = connect.prepareStatement(UPDATE);
            ps.setString(1, allTimeTable.getDayOfMonth());
            ps.setInt(2, allTimeTable.getIdDaileOrder());
            ps.setInt(3, allTimeTable.getIdEmployee());
            ps.setInt(4, allTimeTable.getIdVehicle());
            ps.setInt(5, allTimeTable.getId());
            ps.executeUpdate();
            ps.close();
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteOldTimeTable (TimeTable oldTimeTable){
        try {
            Connection connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement ps = null;
            ps = connect.prepareStatement(DELETE);
            ps.setInt(1, oldTimeTable.getId());
            ps.executeUpdate();
            ps.close();
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
