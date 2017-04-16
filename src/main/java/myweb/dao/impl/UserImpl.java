package myweb.dao.impl;

import myweb.dao.IUser;
import myweb.utils.DataSource;
import myweb.models.Model;
import myweb.models.User;
import myweb.templates.Template;
import myweb.templates.UserTemplate;

import java.util.List;

/**
 * Created by And.Zarazka on 12.04.2017.
 */
public class UserImpl implements IUser {
    private static final String GET_ALL = "SELECT id, login, password, first_name, last_name, age, role_id FROM meloman_db.users";
    private static final String GET_BY_ID = "SELECT id, login, password, first_name, last_name, age, role_id FROM meloman_db.users WHERE id = ?";
    private static final String CREATE = "INSERT INTO meloman_db.users (login, password, first_name, last_name, age, role_id) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE meloman_db.users SET login = ?, password = ?, first_name = ?, last_name = ?, age = ?, role_id = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM meloman_db.users WHERE id = ?";

    private DataSource instance = DataSource.getInstance();

    @Override
    public List<Model> getAll() {
        Template template = new UserTemplate();
        return template.executeAndReturn(instance, GET_ALL);
    }

    @Override
    public List<Model> getById(int id) {
        Template template = new UserTemplate();
        return template.executeAndReturn(instance, GET_BY_ID, id);
    }

    @Override
    public void create(User user) {
        Template template = new UserTemplate();
        template.execute(instance, CREATE, user.getLogin(), user.getPassword(), user.getFirstName(),
                user.getLastName(), user.getAge(), user.getRole().getId());
    }

    @Override
    public void update(User user) {
        Template template = new UserTemplate();
        template.execute(instance, UPDATE, user.getLogin(), user.getPassword(), user.getFirstName(),
                user.getLastName(), user.getAge(), user.getRole().getId(), user.getId());
    }

    @Override
    public void delete(int id) {
        Template template = new UserTemplate();
        template.execute(instance, DELETE, id);
    }
}
