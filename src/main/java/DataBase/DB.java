package DataBase;

import java.sql.*;

public class DB {
    private final String HOST = "localhost";
    private final String PORT = "8889";
    private final String DataBaseName = "Restaurant_DB";
    private final String LOGIN = "root";
    private final String PASSWORD = "root";

    private Connection dbConnection = null;

    public Connection getDataBaseConnection() throws ClassNotFoundException, SQLException {
        String connection = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DataBaseName;
        return dbConnection = DriverManager.getConnection(connection, LOGIN, PASSWORD);
    }

}

