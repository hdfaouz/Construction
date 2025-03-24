<%@ page import="com.example.construction.DAO.ProjetDAO" %>
<%@ page import="com.example.construction.Model.Projets" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Ajouter un Projet</title>

  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">

  <style>
    .card {
      border: none;
      border-radius: 10px;
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
      width: 800px;
    }
    .card-header {
      border-radius: 10px 10px 0 0;
    }
    .form-control {
      border-radius: 5px;
      border: 1px solid #ced4da;
    }
    .form-control:focus {
      border-color: #007bff;
      box-shadow: 0 0 5px rgba(0, 123, 255, 0.5);
    }
    .btn-primary {
      background-color: #007bff;
      border: none;
      border-radius: 5px;
      padding: 10px 20px;
    }
    .btn-primary:hover {
      background-color: #0056b3;
    }
    .form-label {
      font-weight: 500;
      color: #495057;
    }
    .card-body {
      padding: 2rem;
    }

    body {
      display: flex;
    }

    #sidebar_section {
      width: 240px;
      height: auto;
    }
  </style>
</head>
<body>
<section id="sidebar_section">
  <jsp:include page="../header.jsp" />
</section>
<section>
  <div class="container mt-5">
    <div class="row">
      <div class="col-md-8 offset-md-2">
        <div class="card">
          <div class="card-header bg-primary text-white">
            <h3 class="mb-0">Ajouter une Tache</h3>
          </div>
          <div class="card-body">
            <form action="tache?action=ajouter" method="post">
              <input type="hidden" name="action" value="ajouter">
              <div>
                <label for="project_id" class="block font-bold sm:text-sm">Project</label>
                <select id="project_id" name="project_id" required class="w-full p-4 sm:p-3 border rounded-lg focus:outline-none focus:ring-2 focus:ring-[#F4A261]">
                  <option value="">Select a project</option>
                  <%
                    ProjetDAO projectDAO = new ProjetDAO();
                    List<Projets> projects = projectDAO.afficherProjets();
                    for(Projets project : projects){
                  %>
                  <option value="<%= project.getId() %>"><%= project.getNomduprojet() %></option>
                  <% } %>
                </select>
                <div id="projectIdError" class="error"></div>
              </div>
              <div class="mb-3">
                <label for="nom" class="form-label">Nom du tache</label>
                <input type="text" class="form-control" id="nom" name="nomdutache" required>
              </div>

              <div class="mb-3">
                <label for="datededebut" class="form-label">Date de Début</label>
                <input type="date" class="form-control" id="datededebut" name="datededebut" required>
              </div>

              <div class="mb-3">
                <label for="datefin" class="form-label">Date de Fin</label>
                <input type="date" class="form-control" id="datefin" name="datefin" required>
              </div>

              <div class="mb-3">
                <label for="description" class="form-label">Description</label>
                <textarea class="form-control" id="description" name="description" rows="3" required></textarea>
              </div>

<%--              <div class="mb-3">--%>
<%--                <label for="description" class="form-label">ressourcenecessaire</label>--%>
<%--                <textarea class="form-control" id="ressourcenecessaire" name="description" rows="3" required></textarea>--%>
<%--              </div>--%>


              <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                <button type="submit" class="btn btn-primary">Enregistrer</button>

              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>