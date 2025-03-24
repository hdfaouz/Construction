package com.example.construction.DAO;

import com.example.construction.Config.ConnectionDB;
import com.example.construction.Model.Tache;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TacheDAO {

        private Connection connection;

        public void tacheDAO() throws SQLException, ClassNotFoundException {
            try {
                this.connection = ConnectionDB.getConnection();
                if (this.connection == null) {
                    throw new SQLException("La connexion à la base de données est null.");
                }
            } catch (SQLException | ClassNotFoundException e) {
                System.err.println("Erreur lors de l'initialisation de TacheDAO : " + e.getMessage());
                throw new RuntimeException("Impossible d'initialiser la connexion à la base de données", e);
            }
        }


    }

