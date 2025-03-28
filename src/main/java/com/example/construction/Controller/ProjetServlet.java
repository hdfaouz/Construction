package com.example.construction.Controller;

import com.example.construction.DAO.ProjetDAO;
import com.example.construction.Model.Projets;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet("/projet")
public class ProjetServlet extends HttpServlet {
    private ProjetDAO projetDAO;

    @Override
    public void init() {
        projetDAO = new ProjetDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null || action.isEmpty()) {
            response.sendRedirect("/projet?action=afficher");
            return;
        }

        try {
            switch (action) {
                case "new":
                    showNewForm(request, response);
                    break;
                case "ajouter":
                    ajouterProjet(request, response);
                    break;
                case "afficherbyID":
                    afficherProjetById(request, response);
                    break;
                case "modifier":
                    modifierProjet(request, response);
                    break;
                case "supprimer":
                    supprimerProjet(request, response);
                    break;
                case "afficher":
                    afficherProjet(request, response);
                    break;
                default:
                    response.sendRedirect("/projet?action=afficher");
                    break;
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new ServletException("Erreur SQL", e);
        }
    }

    private void afficherProjetById(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException, ClassNotFoundException {
        int id = Integer.parseInt(request.getParameter("id"));
        Projets projetsById = projetDAO.getProjetById(id);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDateFin = dateFormat.format(projetsById.getDatedefin());
        request.setAttribute("projetsById", projetsById);
        request.setAttribute("formattedDateFin", formattedDateFin);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/View/Projet/modifier-projet.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/View/Projet/ajouterProjet.jsp");
        dispatcher.forward(request, response);
    }

    private void afficherProjet(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException, ClassNotFoundException {
        List<Projets> listeProjets = projetDAO.afficherProjets();
        request.setAttribute("projets", listeProjets);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/View/Projet/afficher-projet.jsp");
        dispatcher.forward(request, response);
    }

    private void supprimerProjet(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ClassNotFoundException {
        int id = Integer.parseInt(request.getParameter("id"));
        projetDAO.supprimerProjets(id);
        response.sendRedirect("projet?action=afficher");
    }

    private void modifierProjet(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ClassNotFoundException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nomduprojet = request.getParameter("nomduprojet");
        Date datededebut = Date.valueOf(request.getParameter("datededebut"));
        Date datefin = Date.valueOf(request.getParameter("datefin"));
        String description = request.getParameter("description");
        Double budget = Double.valueOf(request.getParameter("budget"));
        Projets projets = new Projets(id, nomduprojet, datededebut, datefin, description, budget);
        projetDAO.modifierProjet(projets);
        response.sendRedirect("projet?action=afficher");
    }

    private void ajouterProjet(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ClassNotFoundException {
        String nomduprojet = request.getParameter("nomduprojet");
        Date datededebut = Date.valueOf(request.getParameter("datededebut"));
        Date datefin = Date.valueOf(request.getParameter("datefin"));
        String description = request.getParameter("description");
        Double budget = Double.valueOf(request.getParameter("budget"));
        Projets projets = new Projets(nomduprojet, datededebut, datefin, description, budget);
        projetDAO.ajouterProjet(projets);
        response.sendRedirect("projet?action=afficher");
    }
}
