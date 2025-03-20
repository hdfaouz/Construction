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
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <style>
        body {
            background: url(assets/images/construction-statistics-2020.webp);
            display: flex;
        }

        #sidebar_section {
            width: 240px;
            height: auto;
        }

        .container {
            flex: 1;
            padding: 20px;
        }

        .card {
            border: none;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* Subtle shadow */
            background-color: #fff; /* White background for the card */
            padding: 20px;
        }

        .btn-primary {
            background-color: #007bff; /* Bootstrap primary color */
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
        }

        .btn-primary:hover {
            background-color: #0056b3; /* Darker blue on hover */
        }

        .btn-danger {
            background-color: #dc3545; /* Bootstrap danger color */
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
        }

        .btn-danger:hover {
            background-color: #c82333; /* Darker red on hover */
        }

        .btn-info {
            background-color: #17a2b8; /* Bootstrap info color */
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
        }

        .btn-info:hover {
            background-color: #138496; /* Darker teal on hover */
        }

        .table {
            width: 100%;
            margin-top: 20px;
            border-collapse: collapse;
        }

        .table th,
        .table td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd; /* Light border between rows */
        }

        .table th {
            background-color: #007bff; /* Blue header */
            color: #fff; /* White text */
        }

        .table tr:hover {
            background-color: #f1f1f1; /* Light gray on hover */
        }

        .alert {
            margin-top: 20px;
            padding: 15px;
            border-radius: 5px;
        }

        .alert-info {
            background-color: #d1ecf1; /* Light blue for info alerts */
            color: #0c5460; /* Dark blue text */
        }
    </style>
</head>
<body>
<section id="sidebar_section">
    <jsp:include page="../header.jsp" />
</section>
<div class="container">
    <div class="card">
        <h1>Gestion des Projets</h1>
        <a href="projet?action=new" class="btn btn-primary mb-3">Nouveau Projet</a>

        <%
            if (projets == null || projets.isEmpty()) {
        %>
        <div class="alert alert-info">Aucun projet n'a été trouvé.</div>
        <%
        } else {
        %>
        <table class="table">
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