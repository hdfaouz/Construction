<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.example.construction.DAO.RessoureDAO" %>
<%@ page import="com.example.construction.Model.Ressource" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.lang.ClassNotFoundException" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Ajouter une Ressource</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>


<jsp:include page="../header.jsp" />
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card shadow rounded-4">
                <div class="card-header text-center bg-primary text-white">
                    <h4>Ajouter une Ressource</h4>
                </div>
                <div class="card-body">
                    <form action="ressource?action=ajouter" method="post">
                        <div class="mb-3">
                            <label for="nom" class="form-label">Nom :</label>
                            <input type="text" id="nom" name="nom" class="form-control" required>
                        </div>
                        <div class="mb-3">
                            <label for="type" class="form-label">Type :</label>
                            <input type="text" id="type" name="type" class="form-control" required>
                        </div>
                        <div class="mb-3">
                            <label for="quantite" class="form-label">Quantité :</label>
                            <input type="number" id="quantite" name="quantite" class="form-control" required>
                        </div>
                        <div class="d-grid">
                            <button type="submit" class="btn btn-primary">Ajouter</button>
                        </div>
                    </form>
                    <%
                        if ("POST".equalsIgnoreCase(request.getMethod())) {
                            String nom = request.getParameter("nom");
                            String type = request.getParameter("type");
                            int quantite = Integer.parseInt(request.getParameter("quantite"));

                            Ressource ressource = new Ressource();
                            ressource.setNom(nom);
                            ressource.setType(type);
                            ressource.setQuantite(quantite);

                            try {
                                RessoureDAO ressourceDAO = new RessoureDAO();
                                ressourceDAO.AjouterRessource(ressource);
                    %>
                    <div class="alert alert-success mt-3" role="alert">
                        Ressource ajoutée avec succès !
                    </div>
                    <%
                    } catch (SQLException | ClassNotFoundException e) {
                    %>
                    <div class="alert alert-danger mt-3" role="alert">
                        Erreur lors de l'ajout : <%= e.getMessage() %>
                    </div>
                    <%
                            }
                        }
                    %>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
