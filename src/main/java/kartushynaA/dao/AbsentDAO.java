package kartushynaA.dao;

import kartushynaA.entity.Absent;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Анна on 08.05.2017.
 */
public class AbsentDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/mainAcad";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1444";
    private static final String NEW = "INSERT INTO Absent VALUES(id = null, dayOfWeek = ?, reason = ?, idEmployee = ?)";
    private static final String ALL = "SELECT * FROM Absent";
    private static final String ID = "SELECT * FROM Absent WHERE id = ?";
    private static final String UPDATE = "UPDATE Absent SET dayOfWeek = ?, reason = ?, idEmployee = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM Absent WHERE  id = ?";

    public List <Absent> getAllAbsents(){
        List <Absent> allAbsents = new ArrayList<Absent>();
        try {
            Connection connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement ps = connect.prepareStatement(ALL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                int id = rs.getInt("id");
                String dayOfWeek = rs.getString("dayOfWeek");
                String reason = rs.getString("reason");
                int idEmployee = rs.getInt("idEmployee");
                allAbsents.add(new Absent(id, dayOfWeek, reason, idEmployee));

            }
            rs.close();
            ps.close();
            connect.close();
        } catch (SQLException e) {
            System.out.print("can't getAllAbsents");
            e.printStackTrace();
            return new ArrayList<Absent>();

        }
        return allAbsents;
    }

    public Absent getAbsentById(int id){
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
            return new Absent(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getInt(4));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void saveNewAbsent(Absent newAbsent){
        try {
            Connection connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement ps = null;
            ps = connect.prepareStatement(NEW);
            ps.setString(1, newAbsent.getDayOfWeek());
            ps.setString(2, newAbsent.getReason());
            ps.setInt(3, newAbsent.getIdEmployee());
            ps.executeUpdate();
            ps.close();
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAllAbsents(Absent allAbsents){
        try {
            Connection connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement ps = null;
            ps = connect.prepareStatement(UPDATE);
            ps.setString(1, allAbsents.getDayOfWeek());
            ps.setString(2, allAbsents.getReason());
            ps.setInt(3, allAbsents.getIdEmployee());
            ps.setInt(4, allAbsents.getId());
            ps.executeUpdate();
            ps.close();
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteOldAbsents (Absent oldAbsents){
        try {
            Connection connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement ps = null;
            ps = connect.prepareStatement(DELETE);
            ps.setInt(1, oldAbsents.getId());
            ps.executeUpdate();
            ps.close();
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

