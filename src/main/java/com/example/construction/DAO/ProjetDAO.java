package com.example.construction.DAO;

import com.example.construction.Config.ConnectionDB;
import com.example.construction.Model.Projets;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjetDAO {

    public void ajouterProjet(Projets projet) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO projets (nomduprojet, datededebut, datedefin, description, budget) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, projet.getNomduprojet());
            preparedStatement.setDate(2, projet.getDatededebut());
            preparedStatement.setDate(3, projet.getDatedefin());
            preparedStatement.setString(4, projet.getDescription());
            preparedStatement.setDouble(5, projet.getBudget());
            preparedStatement.executeUpdate();
        }
    }

    public void modifierProjet(Projets projet) throws SQLException, ClassNotFoundException {
        String query = "UPDATE projets SET nomduprojet=?, datededebut=?, datedefin=?, description=?, budget=? WHERE id=?";
        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setString(1, projet.getNomduprojet());
            preparedStatement.setDate(2, projet.getDatededebut());
            preparedStatement.setDate(3, projet.getDatedefin());
            preparedStatement.setString(4, projet.getDescription());
            preparedStatement.setDouble(5, projet.getBudget());
            preparedStatement.setInt(6, projet.getId());
            preparedStatement.executeUpdate();
        }
    }

    public List<Projets> afficherProjets() throws SQLException, ClassNotFoundException {
        List<Projets> projetsList = new ArrayList<>();
        String query = "SELECT * FROM projets";
        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Projets projet = new Projets(
                        resultSet.getInt("id"),
                        resultSet.getString("nomduprojet"),
                        resultSet.getDate("datededebut"),
                        resultSet.getDate("datedefin"),
                        resultSet.getString("description"),
                        resultSet.getDouble("budget"));
                projetsList.add(projet);
            }
        }
        return projetsList;
    }

    public void supprimerProjets(int id) throws SQLException, ClassNotFoundException {
        String query = "DELETE FROM projets WHERE id=?";
        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }

    public Projets getProjetById(int id) throws SQLException {
        String sql = "SELECT * FROM projets WHERE id = ?";
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Projets projet = new Projets();
                    projet.setId(resultSet.getInt("id"));
                    projet.setNomduprojet(resultSet.getString("nomduprojet"));
                    projet.setDatededebut(resultSet.getDate("datededebut"));
                    projet.setDatedefin(resultSet.getDate("datedefin"));
                    projet.setDescription(resultSet.getString("description"));
                    projet.setBudget(resultSet.getDouble("budget"));
                    return projet;
                }
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}