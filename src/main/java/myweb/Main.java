package myweb;

import myweb.dao.IRole;
import myweb.dao.IUser;
import myweb.dao.impl.RoleImpl;
import myweb.dao.impl.UserImpl;
import myweb.models.Model;
import myweb.models.Role;
import myweb.models.User;

import java.util.List;

/**
 * Test class
 * Created by And.Zarazka on 13.04.2017.
 */
public class Main {
    public static void main(String[] args) {
        IUser user = new UserImpl();

        // Get by id
        List<Model> getByIdUser = user.getById(18);
        User userId = (User) getByIdUser.get(0);
        IRole role = new RoleImpl();
        List<Model> role1 = role.getById(userId.getRole().getId());
        Role role2 = (Role) role1.get(0);
        System.out.println("ID = " + userId.getId() + "\n" +
                "LogIn = " + userId.getLogin() + "\n" +
                "PASSWORD = " + userId.getPassword() + "\n" +
                "FIRST NAME = " + userId.getFirstName() + "\n" +
                "LAST NAME = " + userId.getLastName() + "\n" +
                "AGE = " + userId.getAge() + "\n" +
                "ROLE = " + role2.getName() + "\n");

        userId.setLastName("PPPP");
        user.update(userId);

        // Get all users
        List<Model> users = user.getAll();
        for (Model modelAll : users) {
            System.out.println(modelAll);
        }

    }
}
