package myweb.dao.impl;

import myweb.dao.IRole;
import myweb.utils.DataSource;
import myweb.models.Model;
import myweb.models.Role;
import myweb.templates.RoleTemplate;
import myweb.templates.Template;

import java.util.List;

/**
 * The RoleImpl class implementing CRUD methods
 * Created by JOB on 14.04.2017.
 */
public class RoleImpl implements IRole {
    private static final String GET_ALL = "SELECT * FROM template_pattern_db.role";
    private static final String GET_BY_ID = "SELECT * FROM template_pattern_db.role WHERE ID = ?";
    private static final String CREATE = "INSERT INTO template_pattern_db.role (NAME) VALUES (?)";
    private static final String UPDATE = "UPDATE template_pattern_db.role SET NAME = ? WHERE ID = ?";
    private static final String DELETE = "DELETE FROM template_pattern_db.role WHERE ID = ?";
    private static final String GET_BY_NAME = "SELECT * FROM template_pattern_db.role WHERE NAME = ?";

    private DataSource instance = DataSource.getInstance();

    @Override
    public List<Model> getAll() {
        Template template = new RoleTemplate();
        return template.executeAndReturn(instance, GET_ALL);
    }

    @Override
    public List<Model> getById(int id) {
        Template template = new RoleTemplate();
        return template.executeAndReturn(instance, GET_BY_ID, id);
    }

    @Override
    public void create(Role role) {
        Template template = new RoleTemplate();
        template.execute(instance, CREATE, role.getName().trim());
    }

    @Override
    public void update(Role role) {
        Template template = new RoleTemplate();
        template.execute(instance, UPDATE, role.getName().trim(), role.getId());
    }

    @Override
    public void delete(int id) {
        Template template = new RoleTemplate();
        template.execute(instance, DELETE, id);
    }

    @Override
    public List<Model> getByName(String name) {
        Template template = new RoleTemplate();
        return template.executeAndReturn(instance, GET_BY_NAME, name.trim());
    }
}
