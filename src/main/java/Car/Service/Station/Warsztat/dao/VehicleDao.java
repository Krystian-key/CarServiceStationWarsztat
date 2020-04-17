package Car.Service.Station.Warsztat.dao;

import Car.Service.Station.Warsztat.model.Customer;
import Car.Service.Station.Warsztat.model.Vehicle;
import Car.Service.Station.Warsztat.util.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDao {
    private static final String READ_VEHICLES_QUERY = "SELECT * FROM vehicles WHERE id = ?;";
    private static final String READ_ALL_VEHICLES_QUERY = "SELECT * FROM vehicles;";
    private static final String CREATE_VEHICLES_QUERY = "INSERT INTO vehicles(brand, engine, colour, production_year, gear_box, " +
            "registration_number, model, next_technical_review) VALUES (?,?,?,?,?,?,?,?);";
    private static final String UPDATE_VEHICLES_QUERY = "UPDATE vehicles SET vehicles brand = ?, engine = ?, colour = ?, production_year = ?," +
            " gear_box = ?,registration_number = ?, model = ?, next_technical_review = ? WHERE id = ?;";
    private static final String DELETE_VEHICLES_QUERY = "DELETE FROM vehicles WHERE id = ?;";

    public Vehicle read(int id) {
        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(READ_VEHICLES_QUERY);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setId(resultSet.getInt("id"));
                vehicle.setBrand(resultSet.getString("brand"));
                vehicle.setEngine(resultSet.getString("engine"));
                vehicle.setColour(resultSet.getString("colour"));
                vehicle.setProductionYear(resultSet.getDate("production_year"));
                vehicle.setGearBox(resultSet.getString("gear_box"));
                vehicle.setRegistrationNumber(resultSet.getString("registration_number"));
                vehicle.setModel(resultSet.getString("model"));
                vehicle.setNextTechnicalReview(resultSet.getDate("next_technical_review"));
                return vehicle;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Vehicle> readAll() {
        List<Vehicle> vehicleArrayList = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(READ_ALL_VEHICLES_QUERY);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setId(resultSet.getInt("id"));
                vehicle.setBrand(resultSet.getString("brand"));
                vehicle.setEngine(resultSet.getString("engine"));
                vehicle.setColour(resultSet.getString("colour"));
                vehicle.setProductionYear(resultSet.getDate("production_year"));
                vehicle.setGearBox(resultSet.getString("gear_box"));
                vehicle.setRegistrationNumber(resultSet.getString("registration_number"));
                vehicle.setModel(resultSet.getString("model"));
                vehicle.setNextTechnicalReview(resultSet.getDate("next_technical_review"));
                vehicleArrayList.add(vehicle);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicleArrayList;
    }

    public Vehicle create(Vehicle vehicle) {
        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement =
                    connection.prepareStatement(CREATE_VEHICLES_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, vehicle.getBrand());
            statement.setString(2, vehicle.getEngine());
            statement.setString(3, vehicle.getColour());
            statement.setString(4, vehicle.getProductionYear().toString());
            statement.setString(5, vehicle.getGearBox());
            statement.setString(6, vehicle.getRegistrationNumber());
            statement.setString(7, vehicle.getModel());
            statement.setString(8, vehicle.getNextTechnicalReview().toString());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                vehicle.setId(resultSet.getInt(1));
            }
            return vehicle;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void update(Vehicle vehicle) {
        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(UPDATE_VEHICLES_QUERY);
            statement.setInt(9, vehicle.getId());
            statement.setString(1, vehicle.getBrand());
            statement.setString(2, vehicle.getEngine());
            statement.setString(3, vehicle.getColour());
            statement.setString(4, vehicle.getProductionYear().toString());
            statement.setString(5, vehicle.getGearBox());
            statement.setString(6, vehicle.getRegistrationNumber());
            statement.setString(7, vehicle.getModel());
            statement.setString(8, vehicle.getNextTechnicalReview().toString());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_VEHICLES_QUERY)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
