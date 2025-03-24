<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Liste des Tâches</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
    .container { max-width: 1000px; margin-top: 50px; }
  </style>
</head>
<body>
<div class="container">
  <h2>Liste des Tâches</h2>
  <a href="tache?action=new" class="btn btn-primary mb-3">Ajouter une Tâche</a>
  <table class="table table-bordered">
    <thead>
    <tr>
      <th>ID</th>
      <th>Projet ID</th>
      <th>Nom</th>
      <th>Date Début</th>
      <th>Date Fin</th>
      <th>Description</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="tache" items="${listeTaches}">
      <tr>
        <td>${tache.id}</td>
        <td>${tache.projet_id}</td>
        <td>${tache.nomdutache}</td>
        <td>${tache.dateDebut}</td>
        <td>${tache.dateFin}</td>
        <td>${tache.description}</td>
      </tr>
    </c:forEach>
    <c:if test="${empty listeTaches}">
      <tr>
        <td colspan="6" class="text-center">Aucune tâche disponible.</td>
      </tr>
    </c:if>
    </tbody>
  </table>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>