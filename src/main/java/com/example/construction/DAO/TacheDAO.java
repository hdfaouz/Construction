package com.example.construction.DAO;

import com.example.construction.Config.ConnectionDB;
import com.example.construction.Model.Tache;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TacheDAO {
    private Connection connection;
    public TacheDAO() throws SQLException, ClassNotFoundException {
        this.connection = ConnectionDB.getConnection();
    }

    public void AjouterTache(Tache tache) throws SQLException {
        String sql = "INSERT INTO taches(nomdutache,datededebut,datedefin,description,ressourcenecessaire) VALUES (?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,tache.getNomdutache());
        preparedStatement.setDate(2, tache.getDateDebut());
        preparedStatement.setDate(3, tache.getDateFin());
        preparedStatement.setString(4,tache.getDescription());
        preparedStatement.executeUpdate();

    }

    public void ModifierTache(Tache tache) throws SQLException {
        String sql ="UPDATE taches SET nomdutache=? ,datededebut=?,datedefin=?,description=? WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,tache.getNomdutache());
        preparedStatement.setDate(2, tache.getDateDebut());
        preparedStatement.setDate(3, tache.getDateFin());
        preparedStatement.setInt(4,tache.getId());
        preparedStatement.executeUpdate();
    }
    public List<Tache>  AfficherTache() throws SQLException, ClassNotFoundException {
        List<Tache> taches = new ArrayList<Tache>();
        String sql = "SELECT * FROM taches";
        Connection connection = ConnectionDB.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String nom = resultSet.getString("nomdutache");
            Date dateDebut = resultSet.getDate("datededebut");
            Date dateFin = resultSet.getDate("datedefin");
            String description = resultSet.getString("description");
            taches.add(new Tache(id,nom,dateDebut,dateFin,description));
        }
        return taches;
    }

    public void supprimerTache(int id) throws SQLException {
        String sql = "DELETE FROM taches WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        preparedStatement.executeUpdate();
    }

    public Tache getTacheById(int id) throws SQLException {
        String sql = "SELECT * FROM taches WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return new Tache(
                    resultSet.getInt("id"),
                    resultSet.getString("nomdutache"),
                    resultSet.getDate("datededebut"),
                    resultSet.getDate("datedefin"),
                    resultSet.getString("description"));
        }
        return null;
    }
}
