package myweb.dao;

import myweb.models.Model;

import java.util.List;

/**
 * The interface Model provides CRUD methods
 * Created by And.Zarazka on 12.04.2017.
 *
 * @param <T> the type parameter
 */
public interface IModel<T extends Model> {
    List<Model> getAll();

    Model getById(int id);

    boolean add(T model);

    boolean update(T model);

    boolean delete(int id);
}
