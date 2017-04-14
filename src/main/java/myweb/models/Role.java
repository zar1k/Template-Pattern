package myweb.models;

import java.util.List;
import java.util.Objects;

/**
 * The type Role
 * Created by JOB on 14.04.2017.
 */
public class Role extends Model {
    private String name;
    private List<User> users;

    /**
     * Instantiates a new Role
     */
    public Role() {
        super();
    }

    /**
     * Instantiates a new User.
     *
     * @param id the Role id
     */
    public Role(int id) {
        super(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Role)) return false;
        Role role = (Role) obj;
        return Objects.equals(getName(), role.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    /**
     * Needed for logging
     *
     * @return Role description
     */
    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
