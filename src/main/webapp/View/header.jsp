changer le désigne et les coulours <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <title>Sidebar with Icons</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">

    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">

    <style>
        body {
            display: flex;
            min-height: 100vh;
            margin: 0;
        }
        .sidebar {
            width: 240px;
            background-color: #000000;
            color: #fff;
            padding: 20px;
            box-shadow: 2px 0 5px rgba(0, 0, 0, 0.1);
            position: fixed;
            bottom: 0;
            top: 0;
        }
        .sidebar .navbar-brand {
            color: #fff;
            font-size: 1.5rem;
            font-weight: bold;
            margin-bottom: 20px;
            display: block;
        }
        .sidebar .nav-link {
            color: #fff;
            padding: 10px 15px;
            margin: 5px 0;
            border-radius: 5px;
            transition: background-color 0.3s, color 0.3s;
            display: flex;
            align-items: center;
        }
        .sidebar .nav-link:hover {
            background-color: rgba(255, 255, 255, 0.1);
            color: #f8f9fa;
        }
        .sidebar .nav-link i {
            margin-right: 10px;
            font-size: 1.2rem;
        }

    </style>
</head>

<nav class="sidebar">
    <a class="navbar-brand" href="#">XpertConstruction</a>
    <ul class="nav flex-column">
        <li class="nav-item">
            <a class="nav-link" href="Acceuil.jsp">
                <i class="fas fa-home"></i>
                Accueil
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/projet?action=new">
                <i class="fas fa-plus"></i>
                Ajouter Projet
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/projet?action=afficher">
                <i class="fas fa-list"></i>
                Liste des Projets
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="ressource?action=new">
                <i class="fas fa-tools"></i>
                Ajouter Ressource
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="ressource?action=afficher">
                <i class="fas fa-th-list"></i>
                Liste des Ressources
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="tache?action=new">
                <i class="fas fa-tasks"></i>
                Ajouter Tâche
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="tache?action=afficher">
                <i class="fas fa-eye"></i>
                Afficher les Tâches
            </a>
        </li>
    </ul>
</nav>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
<script>
    function changeLinkColor(className) {
        const links = document.querySelectorAll('.sidebar .nav-link');
        links.forEach(link => {
            link.classList.remove('custom-link-color-1', 'custom-link-color-2', 'custom-link-color-3');
            link.classList.add(className);
        });
    }
</script>