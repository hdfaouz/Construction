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


}
