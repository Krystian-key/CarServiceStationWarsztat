package Car.Service.Station.Warsztat.dao;

import Car.Service.Station.Warsztat.model.Customer;
import Car.Service.Station.Warsztat.util.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {
    private static final String READ_CUSTOMER_QUERY = "SELECT * FROM customer WHERE id = ?;";
    private static final String READ_ALL_CUSTOMER_QUERY = "SELECT * FROM customer;";
    private static final String CREATE_CUSTOMER_QUERY = "INSERT INTO customer(first_name, last_name, email, address, telephone_number) VALUES (?,?,?,?,?);";
    private static final String UPDATE_CUSTOMER_QUERY = "UPDATE customer SET customer first_name = ?, last_name = ?, email = ?, address = ?, telephone_number = ? WHERE id = ?;";
    private static final String DELETE_CUSTOMER_QUERY = "DELETE FROM customer WHERE id = ?;";

    /**
     * Read all Customers.
     *
     * @param id
     * @return
     */

    public Customer read(int id) {
        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(READ_CUSTOMER_QUERY);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Customer customer = new Customer();
                customer.setId(resultSet.getInt("id"));
                customer.setFirstName(resultSet.getString("first_name"));
                customer.setLastName(resultSet.getString("last_name"));
                customer.setEmail(resultSet.getString("email"));
                customer.setAddress(resultSet.getString("address"));
                customer.setTelephoneNumber(resultSet.getInt("telephone_number"));
                return customer;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Customer> readAll() {
        List<Customer> customerArrayList = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(READ_ALL_CUSTOMER_QUERY);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setId(resultSet.getInt("id"));
                customer.setFirstName(resultSet.getString("first_name"));
                customer.setLastName(resultSet.getString("last_name"));
                customer.setEmail(resultSet.getString("email"));
                customer.setAddress(resultSet.getString("address"));
                customer.setTelephoneNumber(resultSet.getInt("telephone_number"));
                customerArrayList.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerArrayList;
    }

    public Customer create(Customer customer) {
        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement =
                    connection.prepareStatement(CREATE_CUSTOMER_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, customer.getFirstName());
            statement.setString(2, customer.getLastName());
            statement.setString(3, customer.getEmail());
            statement.setString(4, customer.getAddress());
            statement.setInt(5, customer.getTelephoneNumber());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                customer.setId(resultSet.getInt(1));
            }
            return customer;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void update(Customer customer) {
        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(UPDATE_CUSTOMER_QUERY);
            statement.setInt(6, customer.getId());
            statement.setString(1, customer.getFirstName());
            statement.setString(2, customer.getLastName());
            statement.setString(3, customer.getEmail());
            statement.setString(4, customer.getAddress());
            statement.setInt(5, customer.getTelephoneNumber());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_CUSTOMER_QUERY)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
