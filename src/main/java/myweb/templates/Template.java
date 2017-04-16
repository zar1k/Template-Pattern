package myweb.templates;

import myweb.utils.DataSource;
import myweb.models.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Template class for working with JDBC
 * Created by And.Zarazka on 14.04.2017.
 */
public abstract class Template {

    /**
     * Execute query (CREATE, UPDATE, DELETE ) the database
     *
     * @param instance the DataSource instance
     * @param query    the database query
     */
    public final void execute(final DataSource instance, final String query) {
        executeQuery(instance, query, new Object[0]);
    }

    /**
     * Execute query (CREATE, UPDATE, DELETE ) the database
     *
     * @param instance the DataSource instance
     * @param query    the database query
     * @param args     the args
     */
    public final void execute(final DataSource instance, final String query, Object... args) {
        executeQuery(instance, query, args);
    }

    /**
     * Reading from database
     *
     * @param instance the DataSource instance
     * @param query    the database query
     * @return the list of {@link myweb.models.Model}
     */
    public final List<Model> executeAndReturn(final DataSource instance, final String query) {
        return executeAndReturnValue(instance, query, new Object[0]);
    }

    /**
     * Reading from database by parameter
     *
     * @param instance the DataSource instance
     * @param query    the database query
     * @param args     the args
     * @return the list of {@link myweb.models.Model}
     */
    public final List<Model> executeAndReturn(final DataSource instance, final String query, Object... args) {
        return executeAndReturnValue(instance, query, args);
    }

    /**
     * Template for methods {@link #execute(DataSource, String), {@link #execute(DataSource, String, Object...)}}
     *
     * @param instance the DataSource instance
     * @param query    the database query
     * @param args     the args
     */
    private final void executeQuery(final DataSource instance, String query, Object... args) {
        Connection conn = instance.getConnection();
        try (PreparedStatement st = conn.prepareStatement(query);) {
            setArgsOfPreparedStatement(st, args);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        instance.closeConnection(conn);
    }

    /**
     * Template for methods {@link #executeAndReturn(DataSource, String)} ,
     * {@link #executeAndReturn(DataSource, String, Object...)}}
     *
     * @param instance the DataSource instance
     * @param query    the database query
     * @param args     the args
     * @return the list of {@link myweb.models.Model}
     */
    private final List<Model> executeAndReturnValue(final DataSource instance, final String query, Object... args) {
        List<Model> models = null;
        Connection conn = instance.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            setArgsOfPreparedStatement(statement, args);
            try (ResultSet rs = statement.executeQuery();) {
                models = getListOfResult(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        instance.closeConnection(conn);
        return models;
    }

    /**
     * Sets args of prepared statement.
     * Sets the value of the designated parameter using the given object.
     * The JDBC specification specifies a standard mapping from Java Object types to SQL types.
     * The given argument will be converted to the corresponding SQL type before being sent to the database.
     *
     * @param statement the PreparedStatement
     * @param args      the args
     * @throws SQLException hte SQL exception
     */
    private final void setArgsOfPreparedStatement(PreparedStatement statement, Object... args) throws SQLException {
        for (int i = 0; i < args.length; i++) {
            statement.setObject(i + 1, args[i]);
        }
    }

    /**
     * Creates objects {@link myweb.models.User, {@link myweb.models.Role}}
     *
     * @param rs the ResultSet
     * @return the list of {@link myweb.models.Model}
     * @throws SQLException hte SQL exception
     */
    public abstract List<Model> getListOfResult(ResultSet rs) throws SQLException;
}
