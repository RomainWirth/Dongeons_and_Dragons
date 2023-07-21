package fr.campus.dungeon.db;

import java.sql.*;

public class heroDB {
    ConnectDB connectDB=new ConnectDB();
    Connection con = connectDB.getCon();

    public heroDB(){
        ResultSet results = null;
        String query = "SELECT * FROM hero";
        try {
            Statement stmt = con.createStatement();
            results = stmt.executeQuery(query);
        } catch (SQLException e) {
            //traitement de l'exception
            e.printStackTrace();
        }
    }
    String query = "SELECT * FROM hero";
}
