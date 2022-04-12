package config;

import java.util.ResourceBundle;

public class JDBCConfig {


    private static final String DATABASE_RESOURCE = "database";
    private static final ResourceBundle bundle = ResourceBundle.getBundle(DATABASE_RESOURCE);
    private static final String URL = "url";
    public static final String USER = "user";
    public static final String PASSWORD = "password";

    private static String getValue(String value) {
        return bundle.getString(value);
    }


    public static String getUrl() {
        return getValue(URL);
    }

    public static String getUser() {
        return getValue(USER);
    }

    public static String getPassword() {
        return getValue(PASSWORD);
    }


}
