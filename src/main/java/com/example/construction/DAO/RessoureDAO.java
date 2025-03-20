package com.example.construction.DAO;

import com.example.construction.Config.ConnectionDB;
import com.example.construction.Model.Ressource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RessoureDAO {
    private Connection connection;
    public RessoureDAO() throws SQLException, ClassNotFoundException {
        this.connection = ConnectionDB.getConnection();
    }

    public void AjouterRessource(Ressource ressource) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO ressources(nom,type,quantite) VALUES(?,?,?)";
        Connection connection = ConnectionDB.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1, ressource.getNom());
        preparedStatement.setString(2, ressource.getType());
        preparedStatement.setInt(3, ressource.getQuantite());
        preparedStatement.executeUpdate();
    }

    public void modifierRessource(Ressource ressource) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE ressources SET quantite=? WHERE id=?";
        Connection connection = ConnectionDB.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setInt(1, ressource.getQuantite());
        preparedStatement.setInt(2, ressource.getId());
        preparedStatement.executeUpdate();
    }

    public List<Ressource> afficherRessource() throws SQLException, ClassNotFoundException {
        List<Ressource> ressources = new ArrayList<Ressource>();
        String sql = "SELECT * FROM ressources";
        Connection connection = ConnectionDB.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String nom = resultSet.getString("nom");
            String type = resultSet.getString("type");
            int quantite = resultSet.getInt("quantite");
            Ressource ressource = new Ressource(id, nom, type, quantite);
            ressources.add(ressource);
        }
        return ressources;
    }
    public void SupprimerRessource(int id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM ressources WHERE id=?";
        Connection connection = ConnectionDB.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        preparedStatement.executeUpdate();
    }

    public Ressource getRessourceById(int id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM ressources WHERE id=?";
        Connection connection = ConnectionDB.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return new Ressource(
                    resultSet.getInt("id"),
                    resultSet.getString("nom"),
                    resultSet.getString("type"),
                    resultSet.getInt("quantite"));
        }
        return null;
    }

}
