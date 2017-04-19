package myweb.dao.impl;

import myweb.models.Model;
import myweb.models.Role;
import myweb.models.User;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * The test data is taken from the database.
 * The database assigns the object identifiers automatically.
 * Created by And.Zarazka on 16.04.2017.
 */
public class UserImplTest {
    @Test
    public void whenGetAllUsers() throws Exception {
        UserImpl user = new UserImpl();
        boolean result = user.getAll().isEmpty();
        assertTrue(!result);
    }

    @Test
    public void whenGetByIdUser() throws Exception {
        User newUser = new User();
        newUser.setLogin("TEST_USER");
        newUser.setPassword("TEST_USER");
        newUser.setFirstName("TEST_USER");
        newUser.setLastName("TEST_USER");
        newUser.setAge(15);
        newUser.setRole(new Role(3));

        UserImpl userImpl = new UserImpl();
        userImpl.create(newUser);

        List<Model> userByLogin = userImpl.getByLogin("TEST_USER");
        User returnUserByName = (User) userByLogin.get(0);
        int id = returnUserByName.getId();

        List<Model> userById = userImpl.getById(id);
        User returnUserById = (User) userById.get(0);

        assertThat(newUser, is(returnUserById));
    }

    @Test
    public void whenCreateUser() throws Exception {
        User newUser = new User();
        newUser.setLogin("CREATE_NEW_USER");
        newUser.setPassword("CREATE_NEW_USER");
        newUser.setFirstName("CREATE_NEW_USER");
        newUser.setLastName("CREATE_NEW_USER");
        newUser.setAge(25);
        newUser.setRole(new Role(1));

        UserImpl userImpl = new UserImpl();
        userImpl.create(newUser);

        List<Model> userByLogin = userImpl.getByLogin("CREATE_NEW_USER");
        User returnUser = (User) userByLogin.get(0);
        assertThat(newUser, is(returnUser));
    }

    @Test
    public void whenUpdateUser() throws Exception {
        User newUser = new User();
        newUser.setLogin("LOG");
        newUser.setPassword("PASS");
        newUser.setFirstName("USER_NAME");
        newUser.setLastName("USER_SURNAME");
        newUser.setAge(25);
        newUser.setRole(new Role(3));

        UserImpl userImpl = new UserImpl();
        userImpl.create(newUser);

        List<Model> userByLogin = userImpl.getByLogin("LOG");
        User returnUserByLogin = (User) userByLogin.get(0);
        int id = returnUserByLogin.getId();

        returnUserByLogin.setLogin("UPDATE_LOGIN");
        returnUserByLogin.setPassword("UPDATE_PASSWORD");
        returnUserByLogin.setFirstName("UPDATE_NAME");
        returnUserByLogin.setLastName("UPDATE_SURNAME");
        returnUserByLogin.setAge(25);
        returnUserByLogin.setRole(new Role(3));
        userImpl.update(returnUserByLogin);

        List<Model> models = userImpl.getById(id);
        User returnAndUpdateUser = (User) models.get(0);

        assertThat(returnUserByLogin, is(returnAndUpdateUser));
    }

    @Test
    public void whenDeleteUser() throws Exception {
        User newUser = new User();
        newUser.setLogin("TMP_USER");
        newUser.setPassword("TMP_USER");
        newUser.setFirstName("TMP_USER");
        newUser.setLastName("TMP_USER");
        newUser.setAge(55);
        newUser.setRole(new Role(2));

        UserImpl userImpl = new UserImpl();
        userImpl.create(newUser);

        List<Model> models = userImpl.getByLogin("TMP_USER");
        User user = (User) models.get(0);
        int userId = user.getId();

        userImpl.delete(userId);
        List<Model> users = userImpl.getById(userId);
        boolean result = users.isEmpty();
        assertTrue(result);
    }

}