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

        public void AjouterTache(Tache tache) throws SQLException {
            if (connection == null || connection.isClosed()) {
                throw new SQLException("La connexion à la base de données est null ou fermée.");
            }
            String sql = "INSERT INTO taches (projet_id, nomdutache, datededebut, datedefin, description) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, tache.getProjet_id());
                preparedStatement.setString(2, tache.getNomdutache());
                preparedStatement.setDate(3, tache.getDateDebut());
                preparedStatement.setDate(4, tache.getDateFin());
                preparedStatement.setString(5, tache.getDescription());
                preparedStatement.executeUpdate();
            }
        }

        public List<Tache> getAllTaches() throws SQLException {
            if (connection == null || connection.isClosed()) {
                throw new SQLException("La connexion à la base de données est null ou fermée.");
            }
            List<Tache> taches = new ArrayList<>();
            String sql = "SELECT * FROM taches";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Tache tache = new Tache();
                    tache.setId(resultSet.getInt("id"));
                    tache.setProjet_id(resultSet.getInt("projet_id"));
                    tache.setNomdutache(resultSet.getString("nomdutache"));
                    tache.setDateDebut(resultSet.getDate("datededebut"));
                    tache.setDateFin(resultSet.getDate("datedefin"));
                    tache.setDescription(resultSet.getString("description"));
                    taches.add(tache);
                }
            }
            return taches;
        }
    }

