package Car.Service.Station.Warsztat.dao;

import Car.Service.Station.Warsztat.model.Customer;
import Car.Service.Station.Warsztat.model.Status;
import Car.Service.Station.Warsztat.util.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StatusDao {
    private static final String READ_STATUS_QUERY = "SELECT * FROM status WHERE id = ?;";
    private static final String READ_ALL_STATUS_QUERY = "SELECT * FROM status;";
    private static final String CREATE_STATUS_QUERY = "INSERT INTO status(status, order_id) VALUES (?,?);";
    private static final String UPDATE_STATUS_QUERY = "UPDATE status SET status status = ?, order_id = ? WHERE id = ?;";
    private static final String DELETE_STATUS_QUERY = "DELETE FROM status WHERE id = ?;";

    /**
     * Read all Status by Id.
     *
     * @param id
     * @return
     */

    public Status read(int id) {
        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(READ_STATUS_QUERY);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Status status = new Status();
                status.setId(resultSet.getInt("id"));
                status.setStatus(resultSet.getInt("status"));
                status.setOrderId(resultSet.getInt("order_id"));
                return status;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Read all Status.
     *
     * @return
     */

    public List<Status> readAll() {
        List<Status> customerArrayList = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(READ_ALL_STATUS_QUERY);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Status status = new Status();
                status.setId(resultSet.getInt("id"));
                status.setStatus(resultSet.getInt("status"));
                status.setOrderId(resultSet.getInt("order_id"));
                customerArrayList.add(status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerArrayList;
    }

    /**
     * Create Status.
     *
     * @param status
     * @return
     */

    public Status create(Status status) {
        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement =
                    connection.prepareStatement(CREATE_STATUS_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, status.getStatus());
            statement.setInt(2, status.getOrderId());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                status.setId(resultSet.getInt(1));
            }
            return status;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Update Status by Id.
     *
     * @param status
     */

    public void update(Status status) {
        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(UPDATE_STATUS_QUERY);
            statement.setInt(3, status.getId());
            statement.setInt(1, status.getStatus());
            statement.setInt(2, status.getOrderId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Delete Status by Id.
     *
     * @param id
     */

    public void delete(int id) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_STATUS_QUERY)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
