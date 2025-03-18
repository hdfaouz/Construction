<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.util.Locale" %>
<%@ page import="com.example.construction.Model.Projets" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.FRANCE);
    List<Projets> projets = (List<Projets>) request.getAttribute("projets");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des Projets</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h1>Gestion des Projets</h1>
    <a href="projet?action=new" class="btn btn-primary mb-3">Nouveau Projet</a>

    <%
        if (projets == null || projets.isEmpty()) {
    %>
    <div class="alert alert-info">Aucun projet n'a été trouvé.</div>
    <%
    } else {
    %>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Nom du Projet</th>
            <th>Date de Début</th>
            <th>Date de Fin</th>
            <th>Budget</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <%
            for (Projets projet : projets) {
        %>
        <tr>
            <td><%= projet.getId() %></td>
            <td><%= projet.getNomduprojet() %></td>
            <td><%= sdf.format(projet.getDatededebut()) %></td>
            <td><%= sdf.format(projet.getDatedefin()) %></td>
            <td><%= nf.format(projet.getBudget()) %></td>
            <td>
                <a href="projet?action=afficherbyID&id=<%= projet.getId() %>" class="btn btn-sm btn-info">Modifier</a>
                <a href="#" onclick="confirmDelete(<%= projet.getId() %>)" class="btn btn-sm btn-danger">Supprimer</a>
            </td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
    <%
        }
    %>
</div>

<script>
    function confirmDelete(id) {
        if (confirm("Êtes-vous sûr de vouloir supprimer ce projet ?")) {
            window.location.href = "projet?action=supprimer&id=" + id;
        }
    }
</script>
</body>
</html>
