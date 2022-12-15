package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtils {

    private final String DB_URL = "jdbc:postgresql://localhost:5432/offer";
    private final String USERNAME = "postgres";
    private final String PASSWORD = "postgres";
    private final String INITIALIZATION_SCRIPT="" +
            "DROP TABLE IF EXISTS OFFERS;\n" +
            "DROP TABLE IF EXISTS  CANDIDATES;\n" +

            "CREATE TABLE IF NOT EXISTS OFFERS\n" +
            "(\n" +
            "    ID SERIAL PRIMARY KEY NOT NULL,\n" +
            "    DESCRIPTION varchar(100),\n" +
            "    SALARY float NOT NULL\n" +
            ");\n" +
            "\n" +
            "CREATE TABLE IF NOT EXISTS CANDIDATES\n" +
            "(\n" +
            "    ID SERIAL PRIMARY KEY NOT NULL,\n" +
            "    NAME_ varchar(30),\n" +
            "    AGE int NOT NULL,\n" +
            "    SEX varchar(10),\n" +
            "    PHONE varchar(20),\n" +
            "    EMAIL varchar(30),\n" +
            "    ADDRESS varchar(50),\n" +
            "    YEARS_OF_EXPERIENCE int NOT NULL,\n" +
            "    HAVE_HIGHER_EDUCATION BOOLEAN\n" +
            ");";

    public JdbcUtils() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        initDB();
    }

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    private void initDB(){
        try {
            Statement statement = getConnection().createStatement();
            statement.execute(INITIALIZATION_SCRIPT);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
