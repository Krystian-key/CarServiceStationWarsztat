package Car.Service.Station.Warsztat.dao;

import Car.Service.Station.Warsztat.model.Employee;
import Car.Service.Station.Warsztat.model.Order;
import Car.Service.Station.Warsztat.util.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {
    private static final String READ_ORDERS_QUERY = "SELECT * FROM orders WHERE id = ?;";
    private static final String READ_ALL_ORDERS_QUERY = "SELECT * FROM orders;";
    private static final String CREATE_ORDERS_QUERY = "INSERT INTO orders(accepted_date, planed_date, start_date, description_problems, description_repair, repair_cost, " +
            "parts_cost, hourly_rate, repair_hours, employees_id, customer_id, vehicles_id) VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";
    private static final String UPDATE_ORDERS_QUERY = "UPDATE orders SET orders accepted_date = ?, planed_date = ?, start_date = ?, description_problems = ?, " +
            "description_repair = ?, repair_cost = ?, parts_cost = ?, hourly_rate = ?, repair_hours = ?, employees_id = ?, customer_id = ?, vehicles_id WHERE id = ?;";
    private static final String DELETE_ORDERS_QUERY = "DELETE FROM orders WHERE id = ?;";

    /**
     * Read all Orders.
     *
     * @param id
     * @return
     */

    public Order read(int id) {
        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(READ_ORDERS_QUERY);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getInt("id"));
                order.setAcceptedDate(resultSet.getDate("accepted_date"));
                order.setPlanedDate(resultSet.getDate("planed_date"));
                order.setStartDate(resultSet.getDate("start_date"));
                order.setDescriptionProblems(resultSet.getString("description_problems"));
                order.setDescriptionRepair(resultSet.getString("description_repair"));
                order.setRepairCost(resultSet.getDouble("repair_cost"));
                order.setPartsCost(resultSet.getDouble("parts_cost"));
                order.setHourlyRate(resultSet.getInt("hourly_rate"));
                order.setRepairHours(resultSet.getDouble("repair_hours"));
                order.setEmployeesId(resultSet.getInt("employees_id"));
                order.setCustomerId(resultSet.getInt("customer_id"));
                order.setVehiclesId(resultSet.getInt("vehicles_id"));
                return order;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Order> readAll() {
        List<Order> orderArrayList = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(READ_ALL_ORDERS_QUERY);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getInt("id"));
                order.setAcceptedDate(resultSet.getDate("accepted_date"));
                order.setPlanedDate(resultSet.getDate("planed_date"));
                order.setStartDate(resultSet.getDate("start_date"));
                order.setDescriptionProblems(resultSet.getString("description_problems"));
                order.setDescriptionRepair(resultSet.getString("description_repair"));
                order.setRepairCost(resultSet.getDouble("repair_cost"));
                order.setPartsCost(resultSet.getDouble("parts_cost"));
                order.setHourlyRate(resultSet.getInt("hourly_rate"));
                order.setRepairHours(resultSet.getDouble("repair_hours"));
                order.setEmployeesId(resultSet.getInt("employees_id"));
                order.setCustomerId(resultSet.getInt("customer_id"));
                order.setVehiclesId(resultSet.getInt("vehicles_id"));
                orderArrayList.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderArrayList;
    }

    public Order create(Order order) {
        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement =
                    connection.prepareStatement(CREATE_ORDERS_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, order.getAcceptedDate().toString());
            statement.setString(2, order.getPlanedDate().toString());
            statement.setString(3, order.getStartDate().toString());
            statement.setString(4, order.getDescriptionProblems());
            statement.setString(5, order.getDescriptionRepair());
            statement.setDouble(6, order.getRepairCost());
            statement.setDouble(7, order.getPartsCost());
            statement.setInt(8, order.getHourlyRate());
            statement.setDouble(9, order.getRepairCost());
            statement.setInt(10, order.getEmployeesId());
            statement.setInt(11, order.getCustomerId());
            statement.setInt(12, order.getVehiclesId());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                order.setId(resultSet.getInt(1));
            }
            return order;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void update(Order order) {
        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(UPDATE_ORDERS_QUERY);
            statement.setInt(13, order.getId());
            statement.setString(1, order.getAcceptedDate().toString());
            statement.setString(2, order.getPlanedDate().toString());
            statement.setString(3, order.getStartDate().toString());
            statement.setString(4, order.getDescriptionProblems());
            statement.setString(5, order.getDescriptionRepair());
            statement.setDouble(6, order.getRepairCost());
            statement.setDouble(7, order.getPartsCost());
            statement.setInt(8, order.getHourlyRate());
            statement.setDouble(9, order.getRepairCost());
            statement.setInt(10, order.getEmployeesId());
            statement.setInt(11, order.getCustomerId());
            statement.setInt(12, order.getVehiclesId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_ORDERS_QUERY)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
