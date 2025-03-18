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
    private Connection connection;

    public ProjetDAO() {
        try {
            this.connection = ConnectionDB.getConnection();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

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

    public void modifierProjet(Projets projet) throws SQLException {
        String query = "UPDATE projets SET nomduprojet=?, datededebut=?, datedefin=?, description=?, budget=? WHERE id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, projet.getNomduprojet());
            preparedStatement.setDate(2, projet.getDatededebut());
            preparedStatement.setDate(3, projet.getDatedefin()); // correction ajoutée
            preparedStatement.setString(4, projet.getDescription());
            preparedStatement.setDouble(5, projet.getBudget());
            preparedStatement.setInt(6, projet.getId());
            preparedStatement.executeUpdate();
        }
    }

    public List<Projets> afficherProjets() throws SQLException {
        List<Projets> projetsList = new ArrayList<>();
        String query = "SELECT * FROM projets";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
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

    public void supprimerProjets(int id) throws SQLException {
        String query = "DELETE FROM projets WHERE id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }

    public Projets getProjetById(int id) throws SQLException {
        String query = "SELECT * FROM projets WHERE id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return new Projets(
                        rs.getInt("id"),
                        rs.getString("nomduprojet"),
                        rs.getDate("datededebut"),
                        rs.getDate("datedefin"),
                        rs.getString("description"),
                        rs.getDouble("budget"));
            }
        }
        return null;
    }
}
