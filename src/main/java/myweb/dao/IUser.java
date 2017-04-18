package myweb.dao;

import myweb.models.Model;
import myweb.models.User;

import java.util.List;

/**
 * The interface User
 * Created by And.Zarazka on 12.04.2017.
 */
public interface IUser extends IModel<User> {
    /**
     * Gets by User name
     *
     * @param login the User login
     * @return the User login
     */
    List<Model> getByLogin(String login);
}
