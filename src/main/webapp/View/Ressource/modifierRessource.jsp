<%@ page import="com.example.construction.Model.Ressource" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Ressource ressource = (Ressource) request.getAttribute("ressource");
%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Modifier la Ressource</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
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
            padding: 30px;
            max-width: 600px;
            margin: auto;
        }
        .btn-primary:hover {
            background-color: #0056b3;
        }
        .btn-secondary:hover {
            background-color: #6c757d;
        }
    </style>
</head>
<body>
<section id="sidebar_section">
    <jsp:include page="../header.jsp" />
</section>
<div class="container">
    <div class="card">
        <h2>Modifier la Ressource</h2>
        <form action="ressource?action=modifier" method="post">
            <input type="hidden" name="action" value="update">
            <input type="hidden" name="id" value="<%= ressource.getId() %>">

            <div class="mb-3">
                <label for="nom" class="form-label">Nom :</label>
                <input type="text" id="nom" name="nom" value="<%= ressource.getNom() %>" class="form-control" required>
            </div>

            <div class="mb-3">
                <label for="type" class="form-label">Type :</label>
                <input type="text" id="type" name="type" value="<%= ressource.getType() %>" class="form-control" required>
            </div>

            <div class="mb-3">
                <label for="quantite" class="form-label">Quantité :</label>
                <input type="number" id="quantite" name="quantite" value="<%= ressource.getQuantite() %>" class="form-control" required>
            </div>

            <button type="submit" class="btn btn-primary">Enregistrer</button>
            <a href="ressource" class="btn btn-secondary">Annuler</a>
        </form>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
