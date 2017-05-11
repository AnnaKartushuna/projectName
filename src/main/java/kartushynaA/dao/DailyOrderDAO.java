package kartushynaA.dao;


import kartushynaA.entity.DailyOrder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Анна on 08.05.2017.
 */
public class DailyOrderDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/mainAcad";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1444";
    private static final String NEW = "INSERT INTO DailyOrder VALUES(id=null, idRoute = ?, idNumOoOrder = ?, idTurn = ?, startTime = ?)";
    private static final String ALL = "SELECT * FROM DailyOrder";
    private static final String ID = "SELECT * FROM DailyOrder WHERE id = ?";
    private static final String UPDATE = "UPDATE DailyOrder SET idRoute = ?, idNumOoOrder = ?, idTurn = ?, startTime = ? WHERE id=?";
    private static final String DELETE = "DELETE FROM DailyOrder WHERE  id=?";

    public List<DailyOrder> getAllDailyOrder(){
        List <DailyOrder> allDailyOrder = new ArrayList<DailyOrder>();
        try {
            Connection connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement ps = connect.prepareStatement(ALL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                int id = rs.getInt("id");
                int idRoute = rs.getInt("idRoute");
                int idNumOoOrder = rs.getInt("idNumOoOrder");;
                int idTurn = rs.getInt("idTurn");;
                int startTime = rs.getInt("startTime");;
                allDailyOrder.add(new DailyOrder(id, idRoute, idNumOoOrder, idTurn, startTime));
            }
            rs.close();
            ps.close();
            connect.close();
        } catch (SQLException e) {
            System.out.print("can't getAllDailyOrder");
            e.printStackTrace();
            return new ArrayList<DailyOrder>();
        }
        return allDailyOrder;
    }

    public DailyOrder getDailyOrderById(int id){
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
            return new DailyOrder(rs.getInt(1),rs.getInt(2),rs.getInt(3), rs.getInt(4),rs.getInt(5));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void saveNewDailyOrder (DailyOrder newDailyOrder){
        try {
            Connection connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement ps = null;
            ps = connect.prepareStatement(NEW);
            ps.setInt(1, newDailyOrder.getIdRoute());
            ps.setInt(2, newDailyOrder.getIdNumOoOrder());
            ps.setInt(3, newDailyOrder.getIdTurn());
            ps.setInt(4, newDailyOrder.getStartTime());
            ps.executeUpdate();
            ps.close();
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAllDailyOrder(DailyOrder allDailyOrder){
        try {
            Connection connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement ps = null;
            ps = connect.prepareStatement(UPDATE);
            ps.setInt(1, allDailyOrder.getIdRoute());
            ps.setInt(2, allDailyOrder.getIdNumOoOrder());
            ps.setInt(3, allDailyOrder.getIdTurn());
            ps.setInt(4, allDailyOrder.getStartTime());
            ps.setInt(5, allDailyOrder.getId());
            ps.executeUpdate();
            ps.close();
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteOldDailyOrder (DailyOrder oldDailyOrder){
        try {
            Connection connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement ps = null;
            ps = connect.prepareStatement(DELETE);
            ps.setInt(1, oldDailyOrder.getId());
            ps.executeUpdate();
            ps.close();
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
