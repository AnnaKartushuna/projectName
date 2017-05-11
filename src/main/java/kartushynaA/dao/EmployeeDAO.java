package kartushynaA.dao;

import kartushynaA.entity.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Анна on 08.05.2017.
 */
public class EmployeeDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/mainAcad";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1444";
    private static final String NEW = "INSERT INTO Employee VALUES(id = null, name = ?, surName = ?, lastName = ?, personelNumber = ?)";
    private static final String ALL = "SELECT * FROM Employee";
    private static final String ID = "SELECT * FROM Employee WHERE id = ?";
    private static final String UPDATE = "UPDATE Employee SET name = ?, surName = ?, lastName = ?, personelNumber = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM Employee WHERE  id = ?";

    public List<Employee> getAllEmployee(){
        List <Employee> allEmployee = new ArrayList<Employee>();
        try {
            Connection connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement ps = connect.prepareStatement(ALL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surName = rs.getString("surName");
                String lastName = rs.getString("lastName");
                int personelNumber = rs.getInt("personelNumber");
                allEmployee.add(new Employee(id, name, surName, lastName, personelNumber));
            }
            rs.close();
            ps.close();
            connect.close();
        } catch (SQLException e) {
            System.out.print("can't getAllEmployee");
            e.printStackTrace();
            return new ArrayList<Employee>();
        }
        return allEmployee;
    }

    public Employee getEmployeeById(int id){
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
            return new Employee(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getString(4),rs.getInt(5));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void saveNewEmployee (Employee newEmployee){
        try {
            Connection connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement ps = null;
            ps = connect.prepareStatement(NEW);
            ps.setString(1, newEmployee.getName());
            ps.setString(2, newEmployee.getSurName());
            ps.setString(3, newEmployee.getLastName());
            ps.setInt(4, newEmployee.getPersonelNumber());
            ps.executeUpdate();
            ps.close();
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAllEmployee(Employee allEmployee){
        try {
            Connection connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement ps = null;
            ps = connect.prepareStatement(UPDATE);
            ps.setString(1, allEmployee.getSurName());
            ps.setString(2, allEmployee.getLastName());
            ps.setInt(3, allEmployee.getPersonelNumber());
            ps.setInt(4, allEmployee.getId());
            ps.setString(5, allEmployee.getName());
            ps.executeUpdate();
            ps.close();
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteOldEmployee (Employee oldEmployee){
        try {
            Connection connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement ps = null;
            ps = connect.prepareStatement(DELETE);
            ps.setInt(1, oldEmployee.getId());
            ps.executeUpdate();
            ps.close();
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
