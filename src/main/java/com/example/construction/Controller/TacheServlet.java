package com.example.construction.Controller;

import com.example.construction.DAO.ProjetDAO;
import com.example.construction.DAO.TacheDAO;
import com.example.construction.Model.Projets;
import com.example.construction.Model.Tache;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/tache")
public class TacheServlet extends HttpServlet {
    private TacheDAO tacheDAO;
    private ProjetDAO projetDAO;

    @Override
    public void init() {
        try {
            tacheDAO = new TacheDAO();
            projetDAO = new ProjetDAO();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException("Failed to initialize DAOs", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null || action.isEmpty()) {
            action = "afficher";
        }
        try {
            switch (action) {
                case "new":
                    showNewForm(req, resp);
                    break;
                case "add":
                    addTache(req, resp);
                    break;
                case "afficher":
                    afficherTaches(req, resp);
                    break;
                case "supprimer":
                    supprimerTache(req, resp);
                    break;
                case "modifier":
                    showEditForm(req, resp);
                    break;
                case "afficherById":
                    afficherTachebyID(req, resp);
                    break;
                case "tacheparprojets":
                    afficherTacheParProjet(req, resp);
                    break;
                default:
                    resp.sendRedirect("tache?action=afficher");
                    break;
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new ServletException("Database error occurred", e);
        }
    }

    private void afficherTacheParProjet(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, ServletException, IOException {
        int projet_id = Integer.parseInt(req.getParameter("projet_id"));
        Projets projets = projetDAO.getProjetById(projet_id);
        List<Tache> taches = tacheDAO.listerTachesParProjet(projet_id);
        req.setAttribute("projets", projets);
        req.setAttribute("taches", taches);
        req.getRequestDispatcher("/View/Tache/afficherTache.jsp").forward(req, resp);
    }

    private void afficherTachebyID(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Tache tacheById = tacheDAO.getTacheById(id);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/View/Tache/ajouterTache.jsp");
        req.setAttribute("tacheById", tacheById);
        dispatcher.forward(req, resp);
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, ClassNotFoundException, ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Tache tache = tacheDAO.getTacheById(id);
        List<Projets> projets = projetDAO.afficherProjets();
        req.setAttribute("projets", projets);
        req.setAttribute("tache", tache);
        req.getRequestDispatcher("/View/Tache/modifierTache.jsp").forward(req, resp);
    }

    private void supprimerTache(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        tacheDAO.supprimerTache(id);
        resp.sendRedirect("tache?action=afficher");
    }

    private void showNewForm(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/View/Tache/ajouterTache.jsp");
        dispatcher.forward(req, resp);
    }

    private void addTache(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, IOException {
        int projetId = Integer.parseInt(req.getParameter("project_id"));
        String nomTache = req.getParameter("nomdutache");
        Date dateDebut = Date.valueOf(req.getParameter("datededebut"));
        Date dateFin = Date.valueOf(req.getParameter("datefin"));
        String description = req.getParameter("description");

        Tache tache = new Tache(projetId, nomTache, dateDebut, dateFin, description);
        tacheDAO.ajouterTache(tache);
        resp.sendRedirect("tache?action=afficher");
    }

    private void afficherTaches(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, ServletException, IOException {
        List<Tache> listeTaches = tacheDAO.getAllTaches();
        req.setAttribute("listeTaches", listeTaches);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/View/Tache/afficherTache.jsp");
        dispatcher.forward(req, resp);
    }
}