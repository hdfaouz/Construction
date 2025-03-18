package com.example.construction.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDB {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/construction", "root", "");
        Statement stm = connection.createStatement();

        String projetstable = "CREATE TABLE IF NOT EXISTS projets ("
                + "id INTEGER PRIMARY KEY AUTO_INCREMENT,"
                + "nomduprojet VARCHAR(255) NOT NULL,"
                + "datededebut DATE NOT NULL,"
                + "datedefin DATE NOT NULL,"
                + "description VARCHAR(255),"
                + "budget DOUBLE NOT NULL)";
        stm.executeUpdate(projetstable);

        String tachestable = "CREATE TABLE IF NOT EXISTS taches ("
                + "id INTEGER PRIMARY KEY AUTO_INCREMENT,"
                + "nomdutache VARCHAR(255) NOT NULL,"
                + "datededebut DATE NOT NULL,"
                + "datedefin DATE NOT NULL,"
                + "description VARCHAR(255),"
                + "ressourcenecessaire VARCHAR(255))";
        stm.executeUpdate(tachestable);

        String ressourcetable = "CREATE TABLE IF NOT EXISTS ressources ("
                + "id INTEGER PRIMARY KEY AUTO_INCREMENT,"
                + "nom VARCHAR(255) NOT NULL,"
                + "type VARCHAR(255) NOT NULL,"
                + "quantite INTEGER NOT NULL)";
        stm.executeUpdate(ressourcetable);

        return connection;
    }
}
