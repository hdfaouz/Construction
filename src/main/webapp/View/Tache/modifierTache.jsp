<%--
  Created by IntelliJ IDEA.
  User: Faouz
  Date: 20/03/2025
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Modifier la tâche</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
  <h2 class="mb-4">Modifier la tâche</h2>
  <form action="${pageContext.request.contextPath}/tache?action=modifier" method="post">
    <input type="hidden" name="id" value="${tache.id}" />

    <div class="mb-3">
      <label for="nomdutache" class="form-label">Nom de la tâche</label>
      <input type="text" class="form-control" id="nomdutache" name="nomdutache" value="${tache.nomdutache}" required>
    </div>

    <div class="mb-3">
      <label for="datededebut" class="form-label">Date de début</label>
      <input type="date" class="form-control" id="datededebut" name="datededebut" value="${tache.dateDebut}" required>
    </div>

    <div class="mb-3">
      <label for="datedefin" class="form-label">Date de fin</label>
      <input type="date" class="form-control" id="datedefin" name="datedefin" value="${tache.dateFin}" required>
    </div>

    <div class="mb-3">
      <label for="description" class="form-label">Description</label>
      <textarea class="form-control" id="description" name="description" rows="3">${tache.description}</textarea>
    </div>

    <div class="mb-3">
      <label for="ressourcenecessaire" class="form-label">Ressources nécessaires</label>
      <input type="text" class="form-control" id="ressourcenecessaire" name="ressourcenecessaire" value="${tache.ressourcenessaire}">
    </div>

    <div class="mb-3">
      <label for="projet_id" class="form-label">ID du projet</label>
      <input type="number" class="form-control" id="projet_id" name="projet_id" value="${tache.projet_id}" required>
    </div>

    <button type="submit" class="btn btn-primary">Enregistrer les modifications</button>
    <a href="${pageContext.request.contextPath}/tache?action=afficher" class="btn btn-secondary">Annuler</a>
  </form>
</div>
</body>
</html>

