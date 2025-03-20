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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/tache")
public class TacheServlet extends HttpServlet {
    private TacheDAO tacheDAO;

    public void init() {
        try {
            tacheDAO = new TacheDAO();
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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null || action.isEmpty()) {
            resp.sendRedirect("/tache?action=afficher");
          return;
        }
        switch (action) {
            case "new" :
                showNewForm(req, resp);
            case "ajouter":
                try {
                    ajouterTache(req,resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
                case "afficher":
                    try {
                        afficherTache(req,resp);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                    case "supprimer":
                        try {
                            SupprimerTache(req,resp);
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                        case "modifier":
                            try {
                                modifierTache(req,resp);
                            } catch (SQLException e) {
                                throw new RuntimeException(e);
                            } catch (ClassNotFoundException e) {
                                throw new RuntimeException(e);
                            }
                            break;
            case"afficherbyID":
                try {
                    afficherTachebyID(req,resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            default:
                                resp.sendRedirect("/tache?action=afficher");
                                break;

        }
    }

    private void afficherTachebyID(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Tache tache =tacheDAO.getTacheById(id);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDateFin = dateFormat.format(tache.getDateFin());
        req.setAttribute("tache",tache);
        req.setAttribute("formattedDateFin", formattedDateFin);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/View/Tache/modifierTache.jsp");
        dispatcher.forward(req, resp);
    }

    private void modifierTache(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ClassNotFoundException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String nomdutache = req.getParameter("nomdutache");
        Date dateDebut = Date.valueOf(req.getParameter("datedebut"));
        Date dateFin = Date.valueOf(req.getParameter("datefin"));
        String description = req.getParameter("description");
        Tache tache = new Tache(id, nomdutache, dateDebut, dateFin, description);
        tacheDAO.ModifierTache(tache);
        resp.sendRedirect("tache?action=afficher");
    }

    private void SupprimerTache(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
        int id = Integer.parseInt(req.getParameter("id"));
        tacheDAO.supprimerTache(id);
        resp.sendRedirect("tache?action=afficher");
    }

    private void afficherTache(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ClassNotFoundException {
        List<Tache> taches = tacheDAO.AfficherTache();
        req.setAttribute("taches", taches);
        req.getRequestDispatcher("/WEB-INF/View/Tache/afficherTache.jsp");
    }



    private void ajouterTache(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        String nomdutache = req.getParameter("nomdutache");
        Date dateDebut = Date.valueOf(req.getParameter("datedebut"));
        Date dateFin = Date.valueOf(req.getParameter("datefin"));
        String description = req.getParameter("description");
        Tache tache = new Tache(nomdutache, dateDebut, dateFin, description);
        tacheDAO.AjouterTache(tache);
        resp.sendRedirect("tache?action=afficher");
    }

    private void showNewForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/View/Tache/ajouterTache.jsp");
        dispatcher.forward(req, resp);
    }
}
