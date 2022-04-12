package dao;

import bean.Car;
import config.JDBCConfig;
import service.ReflectionGetAnnotation;

import java.sql.*;

public class ImplDao implements Dao<Car> {

    public static final String SELECT_FROM = "SELECT * FROM ";
    public static final String WHERE_ID = " WHERE id= ";
    public static final String DELETE_FROM = "DELETE FROM ";


    @Override
    public void getId(Car car, int id) {
        try (Connection connection = DriverManager.getConnection(JDBCConfig.getUrl(), JDBCConfig.getUser(), JDBCConfig.getPassword())) {
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(SELECT_FROM + ReflectionGetAnnotation.getTable(car.getClass()) + WHERE_ID + id);
                int columnCount = resultSet.getMetaData().getColumnCount();
                while (resultSet.next()) {
                    for (int i = 1; i <= columnCount; i++) {
                        System.out.println(resultSet.getMetaData().getColumnLabel(i)
                                + " " + resultSet.getString(i));

                    }

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void getAll(Car car) {
        try (Connection connection = DriverManager.getConnection(JDBCConfig.getUrl(), JDBCConfig.getUser(), JDBCConfig.getPassword())) {
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(SELECT_FROM + ReflectionGetAnnotation.getTable(car.getClass()));
                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();
                while (resultSet.next()) {
                    for (int i = 1; i <= columnCount; i++) {
                        System.out.println(metaData.getColumnLabel(i) + " " +
                                resultSet.getObject(i));
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Car car, int id) {
        try (Connection connection = DriverManager.getConnection(JDBCConfig.getUrl(), JDBCConfig.getUser(), JDBCConfig.getPassword())) {
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(DELETE_FROM + ReflectionGetAnnotation.getTable(car.getClass()) + WHERE_ID + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void update(Car car) {
        String sql = "UPDATE " + ReflectionGetAnnotation.getTable(car.getClass()) + " SET name=?, color=?, price=? WHERE ID =?";

        try (Connection connection = DriverManager.getConnection(JDBCConfig.getUrl(), JDBCConfig.getUser(), JDBCConfig.getPassword())) {
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, car.getName());
                statement.setString(2, car.getColor());
                statement.setString(3, car.getPrice());
                statement.setInt(4, car.getIdentify());
                statement.executeUpdate();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void save(Car car) {
        String table = ReflectionGetAnnotation.getTable(Car.class);
        String sql = "Insert into " + table + "(id,name,color,price)  values (?,?,?,?)";
        try (Connection connection = DriverManager.getConnection(JDBCConfig.getUrl(), JDBCConfig.getUser(), JDBCConfig.getPassword())) {
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, car.getIdentify());
                statement.setString(2, car.getName());
                statement.setString(3, car.getColor());
                statement.setString(4, car.getPrice());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}

