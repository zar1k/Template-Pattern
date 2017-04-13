package myweb;

import myweb.dao.IUser;
import myweb.dao.impl.UserImpl;
import myweb.models.Model;
import myweb.models.User;

import java.util.List;

/**
 * Created by And.Zarazka on 13.04.2017.
 */
public class Main {
    public static void main(String[] args) {
        IUser user = new UserImpl();

        // Get by id
        Model modelId = user.getById(1);
        System.out.println(modelId);

        System.out.println("********************************\n");

        User newUser = new User();
        newUser.setLogin("Login");
        newUser.setPassword("Password");
        newUser.setFirstName("FirstName");
        newUser.setLastName("LastName");
        newUser.setAge(25);

        user.add(newUser);

        System.out.println("*******************************\n");

        // Get all users
        List<Model> models = user.getAll();
        for (Model modelAll : models) {
            System.out.println(modelAll);
        }
    }
}
