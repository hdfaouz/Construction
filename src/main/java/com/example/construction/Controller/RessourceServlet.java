package com.example.construction.Controller;

import com.example.construction.DAO.RessoureDAO;
import com.example.construction.Model.Ressource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ressource")
public class RessourceServlet extends HttpServlet {
    private RessoureDAO ressoureDAO;
    public void init() {
        try {
            ressoureDAO= new RessoureDAO();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
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
            resp.sendRedirect("/ressource?action=afficher");
            return;
        }
        switch (action) {
            case "new":
                showNewForm(resp,req);
                break;
                case "ajouter":
                    try {
                        AjouterRssource(resp,req);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                    case "modifier":
                        try {
                            ModifierRessource(resp,req);
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        } catch (ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                        case "supprimer":
                            try {
                                supprimerRessource(resp,req);
                            } catch (SQLException e) {
                                throw new RuntimeException(e);
                            } catch (ClassNotFoundException e) {
                                throw new RuntimeException(e);
                            }
                            break;
                            case "afficher":
                                try {
                                    Afficherressource(resp,req);
                                } catch (SQLException e) {
                                    throw new RuntimeException(e);
                                } catch (ClassNotFoundException e) {
                                    throw new RuntimeException(e);
                                }
                                break;
                                case "afficherByID":
                                    try {
                                        AfficherByID(resp,req);
                                    } catch (SQLException e) {
                                        throw new RuntimeException(e);
                                    } catch (ClassNotFoundException e) {
                                        throw new RuntimeException(e);
                                    }
                                    break;
                                    default:
                                        resp.sendRedirect("/ressource?action=afficher");
                                        break;

        }
    }

    private void supprimerRessource(HttpServletResponse resp, HttpServletRequest req) throws SQLException, ClassNotFoundException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        ressoureDAO.SupprimerRessource(id);
        resp.sendRedirect("ressource?action=afficher");
    }

    private void AfficherByID(HttpServletResponse resp, HttpServletRequest req) throws SQLException, ClassNotFoundException, ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Ressource ressource = ressoureDAO.getRessourceById(id);
        req.setAttribute("ressource", ressource);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/View/Ressource/modifierRessource.jsp");
        dispatcher.forward(req, resp);

    }

    private void Afficherressource(HttpServletResponse resp, HttpServletRequest req) throws SQLException, ClassNotFoundException, ServletException, IOException {
        List<Ressource> ressources = ressoureDAO.afficherRessource();
        req.setAttribute("ressources", ressources);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/View/Ressource/afficherRessource.jsp");
        dispatcher.forward(req, resp);
    }

    private void ModifierRessource(HttpServletResponse resp, HttpServletRequest req) throws SQLException, ClassNotFoundException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String nom = req.getParameter("nom");
        String type = req.getParameter("type");
        int quantite = Integer.parseInt(req.getParameter("quantite"));
        Ressource ressource = new Ressource(id,nom,type,quantite);
        ressoureDAO.modifierRessource(ressource);
        resp.sendRedirect("ressource?action=afficher");
    }


    private void AjouterRssource(HttpServletResponse resp, HttpServletRequest req) throws SQLException, ClassNotFoundException, IOException {
        String nom = req.getParameter("nom");
        String type = req.getParameter("type");
        Integer quantite = Integer.parseInt(req.getParameter("quantite"));
        Ressource ressource = new Ressource(nom, type, quantite);
        ressoureDAO.AjouterRessource(ressource);
        resp.sendRedirect("ressource?action=afficher");
    }

    private void showNewForm(HttpServletResponse resp, HttpServletRequest req) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/View/Ressource/ajouterRessource.jsp");
        dispatcher.forward(req, resp);
    }
}
