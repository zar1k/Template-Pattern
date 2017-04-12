package myweb.models;

/**
 * Created by And.Zarazka on 12.04.2017.
 */
public abstract class Model {
    public int id;

    public Model() {
    }

    public Model(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
