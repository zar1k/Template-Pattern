package myweb.dao.impl;

import myweb.dao.IUser;
import myweb.utils.DataSource;
import myweb.models.Model;
import myweb.models.User;
import myweb.templates.Template;
import myweb.templates.UserTemplate;

import java.util.List;

/**
 * The UserImpl class implementing CRUD methods
 * Created by And.Zarazka on 12.04.2017.
 */
public class UserImpl implements IUser {
    private static final String GET_ALL = "SELECT * FROM template_pattern_db.users";
    private static final String GET_BY_ID = "SELECT ID, LOGIN, PASSWORD, FIRST_NAME, LAST_NAME, AGE, ROLE_ID FROM template_pattern_db.users WHERE ID = ?";
    private static final String GET_BY_LOGIN = "SELECT ID, LOGIN, PASSWORD, FIRST_NAME, LAST_NAME, AGE, ROLE_ID FROM template_pattern_db.users WHERE LOGIN = ?";
    private static final String CREATE = "INSERT INTO template_pattern_db.users (LOGIN, PASSWORD, FIRST_NAME, LAST_NAME, AGE, ROLE_ID) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE template_pattern_db.users SET LOGIN = ?, PASSWORD = ?, FIRST_NAME = ?, LAST_NAME = ?, AGE = ?, ROLE_ID = ? WHERE ID = ?";
    private static final String DELETE = "DELETE FROM template_pattern_db.users WHERE ID = ?";

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
        template.execute(instance, CREATE, user.getLogin().trim(), user.getPassword().trim(), user.getFirstName().trim(),
                user.getLastName().trim(), user.getAge(), user.getRole().getId());
    }

    @Override
    public void update(User user) {
        Template template = new UserTemplate();
        template.execute(instance, UPDATE, user.getLogin().trim(), user.getPassword().trim(), user.getFirstName().trim(),
                user.getLastName().trim(), user.getAge(), user.getRole().getId(), user.getId());
    }

    @Override
    public void delete(int id) {
        Template template = new UserTemplate();
        template.execute(instance, DELETE, id);
    }

    @Override
    public List<Model> getByLogin(String login) {
        Template template = new UserTemplate();
        return template.executeAndReturn(instance, GET_BY_LOGIN, login.trim());
    }
}
