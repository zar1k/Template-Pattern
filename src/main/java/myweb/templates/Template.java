package myweb.templates;

import myweb.db.DataSource;
import myweb.models.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by JOB on 14.04.2017.
 */
public abstract class Template {

    public final void execute(final DataSource instance, final String query) {
        executeQuery(instance, query, new Object[0]);
    }

    /**
     * Execute.
     *
     * @param instance the instance
     * @param query    the query
     * @param args     the args
     */
    public final void execute(final DataSource instance, final String query, Object... args) {
        executeQuery(instance, query, args);
    }

    /**
     * Execute and return list.
     *
     * @param instance the instance
     * @param query    the query
     * @param args     the args
     * @return the list
     */
    public final List<Model> executeAndReturn(final DataSource instance, final String query, Object... args) {
        return executeAndReturnValue(instance, query, args);
    }

    /**
     * Execute and return list.
     *
     * @param instance the instance
     * @param query    the query
     * @return the list
     */
    public final List<Model> executeAndReturn(final DataSource instance, final String query) {
        return executeAndReturnValue(instance, query, new Object[0]);
    }

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

    public final List<Model> executeAndReturnValue(final DataSource instance, final String query, Object... args) {
        Connection conn = instance.getConnection();
        List<Model> models = null;
        try (PreparedStatement statement = conn.prepareStatement(query);) {
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

    public final void setArgsOfPreparedStatement(PreparedStatement statement, Object... args) throws SQLException {
        for (int i = 0; i < args.length; i++) {
            statement.setObject(i + 1, args[i]);
        }
    }

    public abstract List<Model> getListOfResult(ResultSet rs) throws SQLException;
}
