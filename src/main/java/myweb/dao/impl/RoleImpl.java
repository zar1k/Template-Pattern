package myweb.dao.impl;

import myweb.dao.IRole;
import myweb.utils.DataSource;
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
            String sql = "SELECT * FROM template_pattern_db.role";
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Role role = new Role();
                role.setId(resultSet.getInt("ID"));
                role.setName(resultSet.getString("NAME"));
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
            String sql = "SELECT * FROM template_pattern_db.role WHERE ID = ?";
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                role = new Role();
                role.setName(resultSet.getString("NAME"));
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
            String sql = "INSERT INTO template_pattern_db.role (NAME) VALUES (?)";
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
            String sql = "UPDATE template_pattern_db.role SET NAME = ? WHERE ID = ?";
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
            String sql = "DELETE FROM template_pattern_db.role WHERE ID = ?";
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
