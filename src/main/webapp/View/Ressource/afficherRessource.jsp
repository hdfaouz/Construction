<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Locale" %>
<%@ page import="com.example.construction.Model.Ressource" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    NumberFormat nf = NumberFormat.getInstance(Locale.FRANCE);
    List<Ressource> ressources = (List<Ressource>) request.getAttribute("ressources");
%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Liste des Ressources</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background: url(assets/images/construction-background.webp);
            display: flex;
        }
        #sidebar_section {
            width: 240px;
        }
        .container {
            flex: 1;
            padding: 20px;
        }
        .card {
            border: none;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            background-color: #fff;
            padding: 20px;
        }
        .table th {
            background-color: #007bff;
            color: white;
        }
        .table tr:hover {
            background-color: #f1f1f1;
        }
        .btn-primary:hover {
            background-color: #0056b3;
        }
        .btn-danger:hover {
            background-color: #c82333;
        }
        .btn-info:hover {
            background-color: #138496;
        }
        .alert-info {
            background-color: #d1ecf1;
            color: #0c5460;
        }
    </style>
</head>
<body>
<section id="sidebar_section">
    <jsp:include page="../header.jsp" />
</section>
<div class="container">
    <div class="card">
        <h1>Gestion des Ressources</h1>
        <a href="ressource?action=new" class="btn btn-primary mb-3">Nouvelle Ressource</a>

        <%
            if (ressources == null || ressources.isEmpty()) {
        %>
        <div class="alert alert-info">Aucune ressource trouvée.</div>
        <%
        } else {
        %>
        <table class="table">
            <thead>
            <tr>
                <th>ID</th>
                <th>Nom de la Ressource</th>
                <th>Type</th>
                <th>Quantité</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <%
                for (Ressource ressource : ressources) {
            %>
            <tr>
                <td><%= ressource.getId() %></td>
                <td><%= ressource.getNom() %></td>
                <td><%= ressource.getType() %></td>
                <td><%= nf.format(ressource.getQuantite()) %></td>
                <td>
                    <a href="ressource?action=modifiert&id=<%= ressource.getId() %>" class="btn btn-sm btn-info">Modifier</a>
                    <a href="#" onclick="confirmDelete(<%= ressource.getId() %>)" class="btn btn-sm btn-danger">Supprimer</a>
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
</div>

<script>
    function confirmDelete(id) {
        if (confirm("Êtes-vous sûr de vouloir supprimer cette ressource ?")) {
            window.location.href = "ressource?action=delete&id=" + id;
        }
    }
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
