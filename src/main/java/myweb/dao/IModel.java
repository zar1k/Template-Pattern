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
    List<T> getAll();

    T getById(int id);

    void add(T model);

    void update(T model);

    void delete(int id);
}
