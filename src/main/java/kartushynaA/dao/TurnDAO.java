package kartushynaA.dao;

import kartushynaA.entity.Turn;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Анна on 08.05.2017.
 */
public class TurnDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/mainAcad";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1444";
    private static final String NEW = "INSERT INTO Turn VALUES(id = null, numOfTurn = ?)";
    private static final String ALL = "SELECT * FROM Turn";
    private static final String ID = "SELECT * FROM Turn WHERE id = ?";
    private static final String UPDATE = "UPDATE Turn SET numOfTurn = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM Turn WHERE  id = ?";

    public List<Turn> getAllTurn(){
        List <Turn> allTurn = new ArrayList<Turn>();
        try {
            Connection connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement ps = connect.prepareStatement(ALL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                int id = rs.getInt("id");
                int numOfTurn = rs.getInt("numOfTurn");
                allTurn.add(new Turn(id, numOfTurn));
            }
            rs.close();
            ps.close();
            connect.close();

        } catch (SQLException e) {
            System.out.print("can't getAllNumOfOrder");
            e.printStackTrace();
            return new ArrayList<Turn>();
        }
        return allTurn;
    }

    public Turn getTurnById(int id){
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
            return new Turn(rs.getInt(1),rs.getInt(2));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void saveNewTurn(Turn newTurn){
        try {
            Connection connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement ps = null;
            ps = connect.prepareStatement(NEW);
            ps.setInt(1, newTurn.getNumOfTurn());
            ps.executeUpdate();
            ps.close();
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAllTurn(Turn allTurn){
        try {
            Connection connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement ps = null;
            ps = connect.prepareStatement(UPDATE);
            ps.setInt(1, allTurn.getNumOfTurn());
            ps.setInt(2, allTurn.getId());
            ps.executeUpdate();
            ps.close();
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteOldTurn (Turn oldTurn){
        try {
            Connection connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement ps = null;
            ps = connect.prepareStatement(DELETE);
            ps.setInt(1, oldTurn.getId());
            ps.executeUpdate();
            ps.close();
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
