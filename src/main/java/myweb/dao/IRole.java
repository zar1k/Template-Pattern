package myweb.dao;

import myweb.models.Model;
import myweb.models.Role;

import java.util.List;

/**
 * The interface Role
 * Created by JOB on 14.04.2017.
 */
public interface IRole extends IModel<Role> {
    /**
     * Gets by Role name
     *
     * @param name the Role name
     * @return the Role name
     */
    List<Model> getByName(String name);
}
