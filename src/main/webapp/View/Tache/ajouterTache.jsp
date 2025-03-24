<%@ page import="com.example.construction.DAO.ProjetDAO" %>
<%@ page import="com.example.construction.Model.Projets" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Ajouter une Tâche</title>
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
    .error-message {
      color: red;
      margin-bottom: 15px;
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
        <%-- Error Message Display --%>
        <% if (request.getAttribute("error") != null) { %>
        <div class="alert alert-danger">
          <%= request.getAttribute("error") %>
        </div>
        <% } %>

        <div class="card">
          <div class="card-header bg-primary text-white">
            <h3 class="mb-0">Ajouter une Tâche</h3>
          </div>
          <div class="card-body">
            <form action="tache?action=ajouter" method="post" onsubmit="return validateForm()">
              <div class="mb-3">
                <label for="project_id" class="form-label">Projet</label>
                <select id="project_id" name="project_id" class="form-select" required>
                  <option value="">Sélectionnez un projet</option>
                  <%
                    ProjetDAO projectDAO = new ProjetDAO();
                    List<Projets> projects = projectDAO.afficherProjets();
                    for(Projets project : projects){
                  %>
                  <option value="<%= project.getId() %>"><%= project.getNomduprojet() %></option>
                  <% } %>
                </select>
                <div id="projectIdError" class="error-message"></div>
              </div>

              <div class="mb-3">
                <label for="nomdutache" class="form-label">Nom de la tâche</label>
                <input type="text" class="form-control" id="nomdutache" name="nomdutache" required>
                <div id="nomError" class="error-message"></div>
              </div>

              <div class="mb-3">
                <label for="datededebut" class="form-label">Date de Début</label>
                <input type="date" class="form-control" id="datededebut" name="datededebut" required>
                <div id="dateDebutError" class="error-message"></div>
              </div>

              <div class="mb-3">
                <label for="datefin" class="form-label">Date de Fin</label>
                <input type="date" class="form-control" id="datefin" name="datefin" required>
                <div id="dateFinError" class="error-message"></div>
              </div>

              <div class="mb-3">
                <label for="description" class="form-label">Description</label>
                <textarea class="form-control" id="description" name="description" rows="3" required></textarea>
                <div id="descriptionError" class="error-message"></div>
              </div>

              <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                <button type="submit" class="btn btn-primary">Enregistrer</button>
                <a href="tache?action=afficher" class="btn btn-secondary">Annuler</a>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
<script>
  function validateForm() {
    let isValid = true;

    // Reset error messages
    document.querySelectorAll('.error-message').forEach(el => el.textContent = '');

    // Validate project selection
    const projectId = document.getElementById('project_id').value;
    if (!projectId) {
      document.getElementById('projectIdError').textContent = 'Veuillez sélectionner un projet';
      isValid = false;
    }

    // Validate task name
    const taskName = document.getElementById('nomdutache').value;
    if (!taskName.trim()) {
      document.getElementById('nomError').textContent = 'Veuillez entrer un nom de tâche';
      isValid = false;
    }

    // Validate dates
    const startDate = new Date(document.getElementById('datededebut').value);
    const endDate = new Date(document.getElementById('datefin').value);

    if (!document.getElementById('datededebut').value) {
      document.getElementById('dateDebutError').textContent = 'Veuillez sélectionner une date de début';
      isValid = false;
    }

    if (!document.getElementById('datefin').value) {
      document.getElementById('dateFinError').textContent = 'Veuillez sélectionner une date de fin';
      isValid = false;
    }

    if (document.getElementById('datededebut').value && document.getElementById('datefin').value) {
      if (startDate > endDate) {
        document.getElementById('dateFinError').textContent = 'La date de fin doit être après la date de début';
        isValid = false;
      }
    }

    return isValid;
  }
</script>
</body>
</html>