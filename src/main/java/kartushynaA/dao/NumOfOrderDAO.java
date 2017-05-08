package kartushynaA.dao;

import kartushynaA.entity.NumOfOrder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Анна on 08.05.2017.
 */
public class NumOfOrderDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/mainAcad";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1444";
    private static final String NEW = "INSERT INTO NumOfOrder VALUES(id = null, password = ?, name = ?, login = ?)";
    private static final String ALL = "SELECT * FROM NumOfOrder";
    private static final String ID = "SELECT * FROM NumOfOrder WHERE id = ?";
    private static final String UPDATE = "UPDATE NumOfOrder SET password = ?, name = ?, login = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM NumOfOrder WHERE  id = ?";

    public List<NumOfOrder> getAllNumOfOrder(){
        List <NumOfOrder> allNumOfOrder = new ArrayList<NumOfOrder>();
        try {
            Connection connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement ps = connect.prepareStatement(ALL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                int id = rs.getInt("id");
                int num = rs.getInt("num");
                allNumOfOrder.add(new NumOfOrder(id, num));
            }

        } catch (SQLException e) {
            System.out.print("can't getAllNumOfOrder");
            e.printStackTrace();
            return new ArrayList<NumOfOrder>();
        }
        return allNumOfOrder;
    }

    public NumOfOrder getNumOfOrderById(int id){
        ResultSet rs = null;
        try {
            Connection connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement ps = null;
            ps = connect.prepareStatement(ID);
            ps.setInt(1,id);
            rs.next();
            return new NumOfOrder(rs.getInt(1),rs.getInt(2));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void saveNewNumOfOrder (NumOfOrder newNumOfOrder){
        try {
            Connection connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement ps = null;
            ps = connect.prepareStatement(NEW);
            ps.setInt(1, newNumOfOrder.getId());
            ps.setInt(1, newNumOfOrder.getNum());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAllNumOfOrder(NumOfOrder allNumOfOrder){
        try {
            Connection connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement ps = null;
            ps = connect.prepareStatement(UPDATE);
            ps.setInt(1, allNumOfOrder.getId());
            ps.setInt(1, allNumOfOrder.getNum());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteOldNumOfOrder (NumOfOrder oldNumOfOrder){
        try {
            Connection connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement ps = null;
            ps = connect.prepareStatement(DELETE);
            ps.setInt(1, oldNumOfOrder.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

