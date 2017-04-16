package myweb.templates;

import myweb.models.Model;
import myweb.models.Role;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by And.Zarazka on 16.04.2017.
 */
public class RoleTemplate extends Template {
    @Override
    public List<Model> getListOfResult(ResultSet rs) throws SQLException {
        List<Model> models = new ArrayList<>();
        while (rs.next()) {
            Role role = new Role();
            role.setId(rs.getInt("id"));
            role.setName(rs.getString("role_name"));
            models.add(role);
        }
        return models;
    }
}
