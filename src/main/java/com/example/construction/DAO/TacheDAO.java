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

    public TacheDAO() throws SQLException, ClassNotFoundException {
        this.connection = ConnectionDB.getConnection();
    }

    public void ajouterTache(Tache tache) throws SQLException {
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
        List<Tache> taches = new ArrayList<>();
        String sql = "SELECT * FROM taches";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Tache tache = new Tache();
                tache.setId(resultSet.getInt("id"));
                tache.setProjet_id(resultSet.getInt("projet_id"));
                tache.setNomdutache(resultSet.getString("nomdutache"));

                // Handle NULL dates
                java.sql.Date dateDebut = resultSet.getDate("datededebut");
                if (resultSet.wasNull()) dateDebut = null;
                tache.setDateDebut(dateDebut);

                java.sql.Date dateFin = resultSet.getDate("datedefin");
                if (resultSet.wasNull()) dateFin = null;
                tache.setDateFin(dateFin);

                tache.setDescription(resultSet.getString("description"));
                taches.add(tache);
            }
        }
        return taches;
    }

    public List<Tache> listerTachesParProjet(int projet_id) throws SQLException {
        List<Tache> taches = new ArrayList<>();
        String sql = "SELECT * FROM taches WHERE projet_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, projet_id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Tache tache = new Tache();
                    tache.setId(resultSet.getInt("id"));
                    tache.setProjet_id(projet_id);
                    tache.setNomdutache(resultSet.getString("nomdutache"));

                    // Handle NULL dates
                    java.sql.Date dateDebut = resultSet.getDate("datededebut");
                    if (resultSet.wasNull()) dateDebut = null;
                    tache.setDateDebut(dateDebut);

                    java.sql.Date dateFin = resultSet.getDate("datedefin");
                    if (resultSet.wasNull()) dateFin = null;
                    tache.setDateFin(dateFin);

                    tache.setDescription(resultSet.getString("description"));
                    taches.add(tache);
                }
            }
        }
        return taches;
    }

    public Tache getTacheById(int id) throws SQLException {
        String sql = "SELECT * FROM taches WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Tache tache = new Tache();
                    tache.setId(resultSet.getInt("id"));
                    tache.setProjet_id(resultSet.getInt("projet_id"));
                    tache.setNomdutache(resultSet.getString("nomdutache"));

                    // Handle NULL dates
                    java.sql.Date dateDebut = resultSet.getDate("datededebut");
                    if (resultSet.wasNull()) dateDebut = null;
                    tache.setDateDebut(dateDebut);

                    java.sql.Date dateFin = resultSet.getDate("datedefin");
                    if (resultSet.wasNull()) dateFin = null;
                    tache.setDateFin(dateFin);

                    tache.setDescription(resultSet.getString("description"));
                    return tache;
                }
            }
        }
        return null;
    }

    public void supprimerTache(int id) throws SQLException {
        String sql = "DELETE FROM taches WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }

    public void modifierTache(Tache tache) throws SQLException {
        String sql = "UPDATE taches SET projet_id=?, nomdutache=?, datededebut=?, datedefin=?, description=? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, tache.getProjet_id());
            preparedStatement.setString(2, tache.getNomdutache());
            preparedStatement.setDate(3, tache.getDateDebut());
            preparedStatement.setDate(4, tache.getDateFin());
            preparedStatement.setString(5, tache.getDescription());
            preparedStatement.setInt(6, tache.getId());
            preparedStatement.executeUpdate();
        }
    }
}