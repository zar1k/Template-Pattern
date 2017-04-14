package myweb;

import myweb.dao.IUser;
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
        User userGetId = user.getById(1);
        System.out.println("\n" + userGetId + "\n");

        System.out.println("********************************\n");

        // Create new User
        User newUser = new User();
        newUser.setLogin("newUser");
        newUser.setPassword("newUser");
        newUser.setFirstName("newUser");
        newUser.setLastName("newUser");
        newUser.setAge(30);
        newUser.setRole(new Role(3));

        // Add User
//        user.add(newUser);

        // Delete User
//        user.delete(12);

        // Update User
        userGetId.setLogin("admin");
        userGetId.setPassword("12345");
        userGetId.setFirstName("Admin");
        userGetId.setLastName("Admin");
        userGetId.setAge(35);
        userGetId.setRole(new Role(1));
//        user.update(userGetId);

        System.out.println("*******************************\n");

        // Get all users
        List<User> users = user.getAll();
        for (Model modelAll : users) {
            System.out.println(modelAll);
        }
    }
}
