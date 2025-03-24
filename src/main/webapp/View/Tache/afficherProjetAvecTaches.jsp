<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.construction.Model.Projets" %>
<%@ page import="com.example.construction.Model.Tache" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>Liste des Projets avec Tâches</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2 class="text-center mb-4">Liste des Projets avec leurs Tâches</h2>

    <div class="row">
        <%
            List<Projets> projets = (List<Projets>) request.getAttribute("projets");
            if (projets != null) {
                for (Projets projet : projets) {
        %>
        <div class="col-md-6 mb-4">
            <div class="card">
                <div class="card-header bg-primary text-white">
                    <h5><%= projet.getNomduprojet() %></h5>
                    <p class="mb-0">Du <%= projet.getDatededebut() %> au <%= projet.getDatedefin() %></p>
                </div>
                <div class="card-body">
                    <p><%= projet.getDescription() %></p>
                    <p><strong>Budget:</strong> <%= projet.getBudget() %> €</p>

                    <h6 class="mt-3">Tâches associées:</h6>
                    <%
                        List<Tache> taches = projet.getTaches();
                        if (taches != null && !taches.isEmpty()) {
                    %>
                    <table class="table table-sm table-striped">
                        <thead>
                        <tr>
                            <th>Nom</th>
                            <th>Date Début</th>
                            <th>Date Fin</th>
                            <th>Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            for (Tache tache : taches) {
                        %>
                        <tr>
                            <td><%= tache.getNomdutache() %></td>
                            <td><%= tache.getDateDebut() %></td>
                            <td><%= tache.getDateFin() %></td>
                            <td>
                                <a href="tache?action=afficherById&id=<%= tache.getId() %>" class="btn btn-sm btn-info">Voir</a>
                                <a href="tache?action=modifier&id=<%= tache.getId() %>" class="btn btn-sm btn-warning">Modifier</a>
                                <a href="tache?action=supprimer&id=<%= tache.getId() %>" class="btn btn-sm btn-danger">Supprimer</a>
                            </td>
                        </tr>
                        <%
                            }
                        %>
                        </tbody>
                    </table>
                    <%
                    } else {
                    %>
                    <div class="alert alert-info">Aucune tâche pour ce projet</div>
                    <%
                        }
                    %>

                    <div class="mt-3">
                        <a href="tache?action=new&projet_id=<%= projet.getId() %>" class="btn btn-success">Ajouter une tâche</a>
                    </div>
                </div>
            </div>
        </div>
        <%
                }
            }
        %>
    </div>

    <div class="text-center mt-4">
        <a href="projet?action=new" class="btn btn-primary">Créer un nouveau projet</a>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>