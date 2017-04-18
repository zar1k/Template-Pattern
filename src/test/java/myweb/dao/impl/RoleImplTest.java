package myweb.dao.impl;

import myweb.models.Model;
import myweb.models.Role;
import org.junit.Test;


import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * The test data is taken from the database.
 * The database assigns the object identifiers automatically.
 * <p>
 * Created by And.Zarazka on 16.04.2017.
 */
public class RoleImplTest {
    @Test
    public void whenGetAllRole() throws Exception {
        RoleImpl role = new RoleImpl();
        boolean result = role.getAll().isEmpty();
        assertTrue(!result);
    }

    @Test
    public void whenGetByIdRole() throws Exception {
        String testName = "TEST_GET_BY_ID";
        Role newRole = new Role(testName);
        RoleImpl role = new RoleImpl();
        role.create(newRole);

        List<Model> rolesByName = role.getByName(testName);
        Role returnRoleByName = (Role) rolesByName.get(0);
        int id = returnRoleByName.getId();
        List<Model> rolesById = role.getById(id);
        Role returnRoleById = (Role) rolesById.get(0);
        assertThat(newRole, is(returnRoleById));
    }

    @Test
    public void whenCreateNewRole() throws Exception {
        String testName = "TEST_ROLE_NAME";
        Role newRole = new Role(testName);
        RoleImpl role = new RoleImpl();
        role.create(newRole);

        List<Model> roles = role.getByName(testName);
        Role returnRole = (Role) roles.get(0);
        assertThat(newRole, is(returnRole));
    }

    @Test
    public void whenUpdateRole() throws Exception {
        // Create new Role
        String newName = "NEW_ROLE_NAME";
        Role newRole = new Role(newName);
        RoleImpl role = new RoleImpl();
        role.create(newRole);
        // Get by name "NEW_ROLE_NAME"
        List<Model> newRoles = role.getByName(newName);
        Role returnRole = (Role) newRoles.get(0);
        // Update Role
        String updateName = "NEW_UPDATE_NAME";
        returnRole.setName(updateName);
        role.update(returnRole);
        // Get by name "NEW_UPDATE_NAME"
        List<Model> updateRoles = role.getByName(updateName);
        Role returnAndUpdateRole = (Role) updateRoles.get(0);

        assertThat(returnRole, is(returnAndUpdateRole));
    }

    @Test
    public void whenDeleteRole() throws Exception {
        String roleName = "DELETE";
        Role newRole = new Role(roleName);

        RoleImpl roleImpl = new RoleImpl();
        roleImpl.create(newRole);

        List<Model> models = roleImpl.getByName(roleName);
        Role role = (Role) models.get(0);
        int roleID = role.getId();

        roleImpl.delete(roleID);
        List<Model> roles = roleImpl.getById(roleID);
        boolean result = roles.isEmpty();
        assertTrue(result);
    }

}