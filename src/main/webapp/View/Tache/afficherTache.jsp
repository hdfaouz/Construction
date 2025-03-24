<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.construction.Model.Tache" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
  <title>Liste des Tâches</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
  <h2>Liste des Tâches</h2>
  <table class="table table-striped">
    <thead>
    <tr>
      <th>ID</th>
      <th>Nom</th>
      <th>Date Début</th>
      <th>Date Fin</th>
      <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <%
      List<Tache> listeTaches = (List<Tache>) request.getAttribute("listeTaches");
      if (listeTaches != null) {
        for (Tache tache : listeTaches) {
    %>
    <tr>
      <td><%= tache.getId() %></td>
      <td><%= tache.getNomdutache() %></td>
      <td><%= tache.getDateDebut() %></td>
      <td><%= tache.getDateFin() %></td>
      <td>
        <a href="tache?action=afficherById&id=<%= tache.getId() %>" class="btn btn-info btn-sm">Voir</a>
        <a href="tache?action=modifier&id=<%= tache.getId() %>" class="btn btn-warning btn-sm">Modifier</a>
        <a href="tache?action=supprimer&id=<%= tache.getId() %>" class="btn btn-danger btn-sm">Supprimer</a>
      </td>
    </tr>
    <%
        }
      }
    %>
    </tbody>
  </table>
  <a href="tache?action=new" class="btn btn-success">Ajouter une tâche</a>
</div>
</body>
</html>