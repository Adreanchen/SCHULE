package at.htl.gebrauchtwagenverwaltung;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Utility {
    private DBConnection dbConnection = new DBConnection();
    private final Connection connection = dbConnection.buildConnection()[1];
    private final String CSV_CAR_PATH = System.getProperty("user.dir") + "/src/cars.csv";
    private final String CSV_USER_PATH = System.getProperty("user.dir") + "/src/users.csv";
    private final String SQL_FILE_PATH = System.getProperty("user.dir") + "/src/createDB.sql";

    public void fillCarTable() {
        try {
            String FIllDB_INSERT_SQL_CAR = "INSERT INTO Car (brand, model, `firstRegistration`, kilometer, price, `dateOfPriceChange`, automatic, `range`, `power`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatementCAR = dbConnection.buildConnection()[1].prepareStatement(FIllDB_INSERT_SQL_CAR);
            BufferedReader readerCAR = new BufferedReader(new FileReader(CSV_CAR_PATH));
            String line;
            connection.setAutoCommit(false);
            readerCAR.readLine();
            while ((line = readerCAR.readLine()) != null) {
                String[] column = line.split(",");
                if (column.length != 9) continue;
                preparedStatementCAR.setString(1, column[0]);
                preparedStatementCAR.setString(2, column[1]);
                preparedStatementCAR.setInt(3, Integer.parseInt(column[2]));
                preparedStatementCAR.setDouble(4, Double.parseDouble(column[3]));
                preparedStatementCAR.setDouble(5, Double.parseDouble(column[4]));
                preparedStatementCAR.setString(6, column[5]);
                preparedStatementCAR.setBoolean(7, Boolean.parseBoolean(column[6]));
                preparedStatementCAR.setInt(8, Integer.parseInt(column[7]));
                preparedStatementCAR.setInt(9, Integer.parseInt(column[8]));
                preparedStatementCAR.addBatch();
            }
            preparedStatementCAR.executeBatch();
            connection.commit();
        } catch (SQLException SQLex) {
            System.err.println("Database error: " + SQLex.getMessage());
        } catch (IOException IOex) {
            System.err.println("Something went while trying to read the file: " + IOex.getMessage());
        } catch (NumberFormatException NFEex) {
            System.err.println("Something went wrong while converting the data");
        }
    }

    public void fillUserTable() {
        try {
            String FIllDB_INSERT_SQL_USER = "INSERT INTO UserData (username, password , email, adminRights) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatementUSER = dbConnection.buildConnection()[1].prepareStatement(FIllDB_INSERT_SQL_USER);
            BufferedReader readerUSER = new BufferedReader(new FileReader(CSV_USER_PATH));
            String line;
            connection.setAutoCommit(false);
            readerUSER.readLine();
            while ((line = readerUSER.readLine()) != null) {
                String[] column = line.split(",");
                if (column.length != 4) continue;
                preparedStatementUSER.setString(1, column[0]);
                preparedStatementUSER.setString(2, Integer.toString(column[1].hashCode()));
                preparedStatementUSER.setString(3, column[2]);
                preparedStatementUSER.setBoolean(4, Boolean.parseBoolean(column[3]));
                preparedStatementUSER.addBatch();
            }
            preparedStatementUSER.executeBatch();
            connection.commit();
        } catch (SQLException SQLex) {
            System.err.println("Database error: " + SQLex.getMessage());
        } catch (IOException IOex) {
            System.err.println("Something went while trying to read the file: " + IOex.getMessage());
        } catch (NumberFormatException NFEex) {
            System.err.println("Something went wrong while converting the data");
        }
    }

    public void createDatabase() {
        try {
            Statement stmt = dbConnection.buildConnection()[0].createStatement();
            BufferedReader reader = new BufferedReader(new FileReader(SQL_FILE_PATH));
            StringBuilder sqlCommand = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                sqlCommand.append(line);
                if (line.endsWith(";")) {
                    stmt.execute(sqlCommand.toString());
                    sqlCommand.setLength(0);
                }
            }
        } catch (IOException IOex) {
            System.out.println("File not found");
        } catch (SQLException SQLex) {
            throw new RuntimeException(SQLex);
        }
    }

    public List<Car> getCarTable() {
        List<Car> carTable = new ArrayList<>();
        try {
            String GET_DB_SELECT_SQL = "SELECT * FROM Car";
            Statement stmt = dbConnection.buildConnection()[1].createStatement();
            ResultSet rs = stmt.executeQuery(GET_DB_SELECT_SQL);
            while (rs.next()) {
                carTable.add(new Car(
                        rs.getInt("CAR_ID"),
                        rs.getString("brand"),
                        rs.getString("model"),
                        rs.getInt("firstRegistration"),
                        rs.getDouble("kilometer"),
                        rs.getDouble("price"),
                        rs.getDate("dateOfPriceChange"),
                        rs.getBoolean("automatic"),
                        rs.getInt("range"),
                        rs.getInt("power")
                ));
            }
        } catch (SQLException sqlex) {
            System.err.println("Database error: " + sqlex.getMessage());
        }
        return carTable;
    }

    public boolean verifyLogin(UserLogin userLogin) {
        try {
            String VERIFY_LOGIN_SQL = "SELECT password FROM UserData WHERE username = ?";
            PreparedStatement pstmt = dbConnection.buildConnection()[1].prepareStatement(VERIFY_LOGIN_SQL);
            pstmt.setString(1, "'" + userLogin.getUsername() + "'");
            ResultSet rs = pstmt.executeQuery();
            return rs.getString("password").equals(userLogin.getPassword());
        } catch (SQLException sqlex) {
            System.err.println("Database error: " + sqlex.getMessage());
            return false;
        }
    }
}
