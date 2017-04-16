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

    List<Model> getById(int id);

    void create(T t);

    void update(T t);

    void delete(int id);
}
