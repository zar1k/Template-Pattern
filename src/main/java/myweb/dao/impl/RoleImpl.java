package myweb.dao.impl;

import myweb.dao.IRole;
import myweb.db.DataSource;
import myweb.models.Role;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JOB on 14.04.2017.
 */
public class RoleImpl implements IRole {
    private DataSource dataSource = DataSource.getInstance();

    @Override
    public List<Role> getAll() {
        List<Role> roles = new ArrayList<>();
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;
        try {
            String sql = "SELECT * FROM meloman_db.role";
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Role role = new Role();
                role.setId(resultSet.getInt("id"));
                role.setName(resultSet.getString("role_name"));
                roles.add(role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roles;
    }

    @Override
    public Role getById(int id) {
        Role role = null;
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;
        try {
            String sql = "SELECT * FROM meloman_db.role WHERE id = ?";
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                role = new Role();
                role.setName(resultSet.getString("role_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role;
    }

    @Override
    public void add(Role role) {
        Connection connection;
        PreparedStatement statement;
        try {
            String sql = "INSERT INTO meloman_db.role (role_name) VALUES (?)";
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, role.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Role role) {
        Connection connection;
        PreparedStatement statement;
        try {
            String sql = "UPDATE meloman_db.role SET role_name = ? WHERE id = ?";
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, role.getName());
            statement.setInt(2, role.getId());
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
            String sql = "DELETE FROM meloman_db.role WHERE id = ?";
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
