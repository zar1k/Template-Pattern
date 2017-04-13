package myweb.db;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * The class provides methods for creating and managing a connection pool to a database
 * <p>
 * Created by JOB on 13.04.2017.
 */
public class DataSource {
    private static DataSource instance = new DataSource();

    private ComboPooledDataSource cpds;

    /**
     * Get instance
     *
     * @return the instance
     */
    public static DataSource getInstance() {
        return instance;
    }

    private DataSource() {
        try {
            createPool();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Establishes a connection to the database
     *
     * @return the connection to the database
     */
    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = this.cpds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * Closes the connection
     *
     * @param conn closes the database connection
     */
    public void closeConnection(Connection conn) {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets db properties
     *
     * @return the databases properties
     * @throws IOException by failed or interrupted I/O operations.
     */
    public Properties getProperties() throws IOException {
        Properties props = new Properties();
        props.load(DataSource.class.getResourceAsStream("/db.properties"));
        if (props == null) {
            // Create a connection to the embedded database
        }
        return props;
    }

    /**
     * Create a pool
     *
     * @throws Exception
     */
    private void createPool() throws Exception {
        Properties props = getProperties();
        cpds = new ComboPooledDataSource();
        cpds.setDriverClass(props.getProperty("driver"));
        cpds.setJdbcUrl(props.getProperty("url"));
        cpds.setUser(props.getProperty("user"));
        cpds.setPassword(props.getProperty("password"));
        cpds.setMaxStatements(180);
    }
}
