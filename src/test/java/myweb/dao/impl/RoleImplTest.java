package myweb.dao.impl;

import myweb.models.Model;
import myweb.models.Role;
import org.junit.Test;


import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by And.Zarazka on 16.04.2017.
 */
public class RoleImplTest {
    @Test
    public void getAll() throws Exception {
        RoleImpl role = new RoleImpl();
        assertNotNull(role.getAll());
    }

    @Test
    public void whenGetByIdRole() throws Exception {
        int id = 1;
        String testName = "TEST_GET_BY_ID";
        Role newRole = new Role(testName);
        RoleImpl role = new RoleImpl();
        role.create(newRole);

        List<Model> roles = role.getById(id);
        Role returnRole = (Role) roles.get(0);
        assertThat(newRole, is(returnRole));
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
        List<Model> roles = role.getByName(newName);
        Role returnRole = (Role) roles.get(0);
        // Update Role
        String updateName = "NEW_UPDATE_NAME";
        returnRole.setName(updateName);
        role.update(returnRole);
        // Get by name "NEW_UPDATE_NAME"
        List<Model> roles1 = role.getByName(updateName);
        Role returnRole1 = (Role) roles1.get(0);

        assertThat(returnRole, is(returnRole1));
    }

    @Test
    public void whenDeleteRole() throws Exception {
        int roleID = 21;
        String roleName = "DELETE";
        Role newRole = new Role(roleName);

        RoleImpl roleImpl = new RoleImpl();
        roleImpl.create(newRole);

        roleImpl.delete(roleID);
        List<Model> roles = roleImpl.getById(roleID);
        boolean b =  roles.isEmpty();
        assertTrue(b);
    }

}