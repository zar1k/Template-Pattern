package myweb.dao.impl;

import myweb.dao.IUser;
import myweb.utils.DataSource;
import myweb.models.Role;
import myweb.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by And.Zarazka on 12.04.2017.
 */
public class UserImpl implements IUser {
    private DataSource dataSource = DataSource.getInstance();

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;
        try {
            String sql = "SELECT * FROM template_pattern_db.users";
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("ID"));
                user.setLogin(resultSet.getString("LOGIN"));
                user.setPassword(resultSet.getString("PASSWORD"));
                user.setFirstName(resultSet.getString("FIRST_NAME"));
                user.setLastName(resultSet.getString("LAST_NAME"));
                user.setAge(resultSet.getInt("AGE"));
                user.setRole(new Role(resultSet.getInt("ROLE_ID")));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User getById(int id) {
        User user = null;
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;
        try {
            String sql = "SELECT ID, LOGIN, PASSWORD, FIRST_NAME, LAST_NAME, AGE, ROLE_ID FROM template_pattern_db.users WHERE ID = ?";
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("ID"));
                user.setLogin(resultSet.getString("LOGIN"));
                user.setPassword(resultSet.getString("PASSWORD"));
                user.setFirstName(resultSet.getString("FIRST_NAME"));
                user.setLastName(resultSet.getString("LAST_NAME"));
                user.setAge(resultSet.getInt("AGE"));
                user.setRole(new Role(resultSet.getInt("ROLE_ID")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void add(User user) {
        Connection connection;
        PreparedStatement statement;
        try {
            String sql = "INSERT INTO template_pattern_db.users (LOGIN, PASSWORD, FIRST_NAME, LAST_NAME, AGE, ROLE_ID) VALUES (?, ?, ?, ?, ?, ?)";
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFirstName());
            statement.setString(4, user.getLastName());
            statement.setInt(5, user.getAge());
            statement.setInt(6, user.getRole().getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(User user) {
        Connection connection;
        PreparedStatement statement;
        try {
            String sql = "UPDATE template_pattern_db.users SET LOGIN = ?, PASSWORD = ?, FIRST_NAME = ?, LAST_NAME = ?, AGE = ?, ROLE_ID = ? WHERE ID = ?";
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFirstName());
            statement.setString(4, user.getLastName());
            statement.setInt(5, user.getAge());
            statement.setInt(6, user.getRole().getId());
            statement.setInt(7, user.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        Connection connection;
        PreparedStatement statement;
        try {
            String sql = "DELETE FROM template_pattern_db.users WHERE ID = ?";
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
