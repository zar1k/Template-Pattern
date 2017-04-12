package myweb.dao.impl;

import myweb.dao.IUser;
import myweb.models.Model;
import myweb.models.User;

import java.util.List;

/**
 * Created by And.Zarazka on 12.04.2017.
 */
public class UserImpl implements IUser {
    @Override
    public List<Model> getAll() {
        return null;
    }

    @Override
    public Model getById(int id) {
        return null;
    }

    @Override
    public boolean add(User model) {
        return false;
    }

    @Override
    public boolean update(User model) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
