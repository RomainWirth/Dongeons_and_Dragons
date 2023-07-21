package fr.campus.dungeon.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    Connection con;
    private String url = "jdbc:mysql://localhost:3306/D_D";
    private String user = "romain";
    private String password = "LcnA$dl2024!";

    public ConnectDB() {
        try {
            this.con = DriverManager.getConnection(url, user, password);
            System.out.println("Connexion établie");
        } catch (SQLException e){
            System.out.println("Connexion failed");
            throw new RuntimeException(e);
        }
    }

    public Connection getCon() {
        return con;
    }
}
