package com.example.construction.Controller;

import com.example.construction.DAO.TacheDAO;
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

        @Override
        public void init() {
            tacheDAO = new TacheDAO();
        }

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String action = req.getParameter("action");
            if (action == null || action.isEmpty()) {
                action = "afficher";
            }

            switch (action) {
                case "new":
                    showNewForm(req, resp);
                    break;
                case "ajouter":
                    try {
                        ajouterTache(req, resp);
                    } catch (SQLException e) {
                        throw new ServletException("Erreur lors de l'ajout de la tâche", e);
                    }
                    break;
                case "afficher":
                    try {
                        afficherTaches(req, resp);
                    } catch (SQLException e) {
                        throw new ServletException("Erreur lors de l'affichage des tâches", e);
                    }
                    break;
                default:
                    resp.sendRedirect("tache?action=afficher");
                    break;
            }
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            doGet(req, resp);
        }

        private void showNewForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/View/Tache/ajouterTache.jsp");
            dispatcher.forward(req, resp);
        }

        private void ajouterTache(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
            int projetId = Integer.parseInt(req.getParameter("project_id"));
            String nomTache = req.getParameter("nomdutache");
            Date dateDebut = Date.valueOf(req.getParameter("datededebut"));
            Date dateFin = Date.valueOf(req.getParameter("datefin"));
            String description = req.getParameter("description");

            Tache tache = new Tache(projetId, nomTache, dateDebut, dateFin, description);
            tacheDAO.AjouterTache(tache);
            resp.sendRedirect("tache?action=afficher");
        }

        private void afficherTaches(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
            List<Tache> listeTaches = tacheDAO.getAllTaches();
            req.setAttribute("listeTaches", listeTaches);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/View/Tache/afficherTache.jsp");
            dispatcher.forward(req, resp);
        }
    }

