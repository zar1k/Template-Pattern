package myweb.dao;

import myweb.models.Model;

import java.util.List;

/**
 * Created by And.Zarazka on 12.04.2017.
 */
public interface IModel<T extends Model> {
    List<Model> getAll();

    Model getById(int id);

    boolean add(T model);

    boolean update(T model);

    boolean delete(int id);
}
