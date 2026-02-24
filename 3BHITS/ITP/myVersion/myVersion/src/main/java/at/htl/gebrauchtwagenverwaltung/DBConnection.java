package at.htl.gebrauchtwagenverwaltung;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
    private final String CONFIG_FILE = System.getProperty("user.dir") + "/src/config.properties";

    public Connection[] buildConnection() {
        try {
            String[] userData = getLoginData(CONFIG_FILE);
            Connection connection = DriverManager.getConnection(userData[0], userData[1], userData[2]);
            Connection connection2 = DriverManager.getConnection(userData[3], userData[1], userData[2]);
            return new Connection[] {connection, connection2};
        } catch (SQLException SQLex) {
            System.err.println("Connection to database failed! (Start your database!)");
            System.exit(0);
        }
        return null;
    }

    public String[] getLoginData(String filePath) {
        Properties props = new Properties();
        String[] values = new String[4];
        try {
            FileInputStream input = new FileInputStream(filePath);
            props.load(input);
            values[0] = props.getProperty("JDBC_URL");
            values[1] = props.getProperty("USER");
            values[2] = props.getProperty("PASSWORD");
            values[3] = props.getProperty("JDBC_URL") + "Gebrauchtwagenverwaltung";
            if (values[0] == null || values[1] == null || values[2] == null)
                throw new IllegalArgumentException("config.properties is missing JDBC_URL, USER or PASSWORD.");
        } catch (IOException IOex) {
            System.err.println("Error reading config file: " + filePath);
        }
        return values;
    }
}
