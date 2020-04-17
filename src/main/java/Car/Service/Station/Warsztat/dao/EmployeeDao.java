package Car.Service.Station.Warsztat.dao;

import Car.Service.Station.Warsztat.model.Customer;
import Car.Service.Station.Warsztat.model.Employee;
import Car.Service.Station.Warsztat.util.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
    private static final String READ_EMPLOYEES_QUERY = "SELECT * FROM employees WHERE id = ?;";
    private static final String READ_ALL_EMPLOYEES_QUERY = "SELECT * FROM employees;";
    private static final String CREATE_EMPLOYEES_QUERY = "INSERT INTO employees(first_name, last_name, email, password, super_admin, telephone_number, " +
            "notes, hourly_rate, quantity_hours) VALUES (?,?,?,?,?,?,?,?,?);";
    private static final String UPDATE_EMPLOYEES_QUERY = "UPDATE employees SET employees first_name = ?, last_name = ?, email = ?, password = ?, " +
            "super_admin = ?, telephone_number = ?, notes = ?, hourly_rate = ?, quantity_hours = ? WHERE id = ?;";
    private static final String DELETE_EMPLOYEES_QUERY = "DELETE FROM employees WHERE id = ?;";

    public Employee read(int id) {
        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(READ_EMPLOYEES_QUERY);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getInt("id"));
                employee.setFirstName(resultSet.getString("first_name"));
                employee.setLastName(resultSet.getString("last_name"));
                employee.setEmail(resultSet.getString("email"));
                employee.setPassword(resultSet.getString("password"));
                employee.setSuperAdmin(resultSet.getInt("super_admin"));
                employee.setTelephoneNumber(resultSet.getInt("telephone_number"));
                employee.setEmail(resultSet.getString("notes"));
                employee.setHourlyRate(resultSet.getDouble("hourly_rate"));
                employee.setHourlyRate(resultSet.getDouble("quantity_hours"));
                return employee;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Employee> readAll() {
        List<Employee> employeeArrayList = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(READ_ALL_EMPLOYEES_QUERY);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getInt("id"));
                employee.setFirstName(resultSet.getString("first_name"));
                employee.setLastName(resultSet.getString("last_name"));
                employee.setEmail(resultSet.getString("email"));
                employee.setPassword(resultSet.getString("password"));
                employee.setSuperAdmin(resultSet.getInt("super_admin"));
                employee.setTelephoneNumber(resultSet.getInt("telephone_number"));
                employee.setEmail(resultSet.getString("notes"));
                employee.setHourlyRate(resultSet.getDouble("hourly_rate"));
                employee.setHourlyRate(resultSet.getDouble("quantity_hours"));
                employeeArrayList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeArrayList;
    }

    public Employee create(Employee employee) {
        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement =
                    connection.prepareStatement(CREATE_EMPLOYEES_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getLastName());
            statement.setString(3, employee.getEmail());
            statement.setString(4, employee.getPassword());
            statement.setInt(5, employee.getSuperAdmin());
            statement.setInt(6, employee.getTelephoneNumber());
            statement.setString(7, employee.getNotes());
            statement.setDouble(8, employee.getHourlyRate());
            statement.setDouble(9, employee.getQuantityHours());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                employee.setId(resultSet.getInt(1));
            }
            return employee;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void update(Employee employee) {
        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(UPDATE_EMPLOYEES_QUERY);
            statement.setInt(10, employee.getId());
            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getLastName());
            statement.setString(3, employee.getEmail());
            statement.setString(4, employee.getPassword());
            statement.setInt(5, employee.getSuperAdmin());
            statement.setInt(6, employee.getTelephoneNumber());
            statement.setString(7, employee.getNotes());
            statement.setDouble(8, employee.getHourlyRate());
            statement.setDouble(9, employee.getQuantityHours());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_EMPLOYEES_QUERY)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
