import config.JDBCConfig;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {


    @Test
    public void testConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(JDBCConfig.getUrl(), JDBCConfig.getUser(), JDBCConfig.getPassword());
        Assert.assertNotNull(connection);
        String expected = connection.getMetaData().getURL();
        String actual = "jdbc:h2:~/car_database";
        Assert.assertEquals(expected, actual);
        connection.close();

    }
}
