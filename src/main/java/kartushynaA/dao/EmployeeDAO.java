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
    private static final String NEW = "INSERT INTO Employee VALUES(id = null, password = ?, name = ?, login = ?)";
    private static final String ALL = "SELECT * FROM Employee";
    private static final String ID = "SELECT * FROM Employee WHERE id = ?";
    private static final String UPDATE = "UPDATE Employee SET password = ?, name = ?, login = ? WHERE id = ?";
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
            ps.setInt(1, newEmployee.getId());
            ps.setString(1, newEmployee.getName());
            ps.setString(1, newEmployee.getSurName());
            ps.setString(1, newEmployee.getLastName());
            ps.setInt(1, newEmployee.getPersonelNumber());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAllEmployee(Employee allEmployee){
        try {
            Connection connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement ps = null;
            ps = connect.prepareStatement(UPDATE);
            ps.setInt(1, allEmployee.getId());
            ps.setString(1, allEmployee.getName());
            ps.setString(1, allEmployee.getSurName());
            ps.setString(1, allEmployee.getLastName());
            ps.setInt(1, allEmployee.getPersonelNumber());

            ps.executeUpdate();
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
