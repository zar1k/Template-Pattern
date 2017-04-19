package myweb.templates;

import myweb.models.Model;
import myweb.models.Role;
import myweb.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by And.Zarazka on 14.04.2017.
 */
public class UserTemplate extends Template {
    @Override
    public List<Model> getListOfResult(ResultSet rs) throws SQLException {
        List<Model> models = new ArrayList<>();
        while (rs.next()) {
            User user = new User();
            user.setId(rs.getInt("ID"));
            user.setLogin(rs.getString("LOGIN"));
            user.setPassword(rs.getString("PASSWORD"));
            user.setFirstName(rs.getString("FIRST_NAME"));
            user.setLastName(rs.getString("LAST_NAME"));
            user.setAge(rs.getInt("AGE"));
            user.setRole(new Role(rs.getInt("ROLE_ID")));
            models.add(user);
        }
        return models;
    }
}
