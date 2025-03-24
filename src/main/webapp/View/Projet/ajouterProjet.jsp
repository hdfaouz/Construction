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
        .btn-secondary {
            background-color: #6c757d;
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
        }
        .btn-secondary:hover {
            background-color: #5a6268;
        }
        .form-label {
            font-weight: 500;
            color: #495057;
        }
        .card-body {
            padding: 2rem;
        }
        .bodyElement {
            display: flex;
            background-image: url("../Image/pexels-jacobyclarkephoto-1579356.jpg") ;
            background-size: cover;
            background-position: center ;
            background-repeat: no-repeat;

        }
        #sidebar_section {
            width: 240px;
            height: auto;
        }
        .error {
            color: #dc3545;
            font-size: 0.875em;
            margin-top: 0.25rem;
        }
    </style>
</head>
<body class=" bodyElement">


<section id="sidebar_section">
    <jsp:include page="../header.jsp" />
</section>
<section>
    <div class="container mt-5">
        <div class="row">
            <div class="col-md-8 offset-md-2">
                <div class="card">
                    <div class="card-header bg-primary text-white">
                        <h3 class="mb-0">Ajouter un Nouveau Projet</h3>
                    </div>
                    <div class="card-body">
                        <form action="projet" method="post" id="projectForm">
                            <input type="hidden" name="action" value="ajouter">

                            <div class="mb-3">
                                <label for="nom" class="form-label">Nom du Projet</label>
                                <input type="text" class="form-control" id="nom" name="nomduprojet" required>
                            </div>

                            <div class="mb-3">
                                <label for="datededebut" class="form-label">Date de Début</label>
                                <input type="date" class="form-control" id="datededebut" name="datededebut" required>
                            </div>

                            <div class="mb-3">
                                <label for="datefin" class="form-label">Date de Fin</label>
                                <input type="date" class="form-control" id="datefin" name="datefin" required>
                                <div id="dateError" class="error"></div>
                            </div>

                            <div class="mb-3">
                                <label for="description" class="form-label">Description</label>
                                <textarea class="form-control" id="description" name="description" rows="3" required></textarea>
                            </div>

                            <div class="mb-3">
                                <label for="budget" class="form-label">Budget</label>
                                <input type="number" step="0.01" class="form-control" id="budget" name="budget" required>
                            </div>

                            <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                                <button type="submit" class="btn btn-primary">Enregistrer</button>
                                <a href="projet?action=afficher" class="btn btn-secondary">Annuler</a>
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
    document.getElementById('projectForm').addEventListener('submit', function(e) {
        const startDate = new Date(document.getElementById('datededebut').value);
        const endDate = new Date(document.getElementById('datefin').value);
        const dateError = document.getElementById('dateError');

        if (endDate < startDate) {
            e.preventDefault();
            dateError.textContent = "La date de fin doit être postérieure à la date de début.";
        } else {
            dateError.textContent = "";
        }
    });
</script>
</body>
</html>