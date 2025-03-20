<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>XpertConstruction - Connexion</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
            min-height: 100vh;
            display: flex;
            align-items: center;
        }

        .login-container {
            max-width: 500px;
            margin: 0 auto;
            padding: 30px;
            background: white;
            border-radius: 10px;
            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
        }

        .login-logo {
            text-align: center;
            margin-bottom: 30px;
            font-size: 24px;
            font-weight: bold;
            color: #212529;
        }

        .logo-accent {
            color: #f8b500;
        }

        .btn-custom {
            background-color: #f8b500;
            border: none;
            padding: 12px 30px;
            font-weight: 600;
            border-radius: 50px;
        }

        .btn-custom:hover {
            background-color: #e5a700;
        }

        .form-control {
            padding: 12px;
            border-radius: 8px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="login-container">
        <div class="login-logo">
            <span class="logo-accent">Xpert</span>Construction
        </div>
        <h2 class="text-center mb-4">Connexion</h2>
        <form id="loginForm">
            <div class="mb-4">
                <label for="username" class="form-label">Nom d'utilisateur</label>
                <input type="text" class="form-control" id="username" placeholder="Entrez votre nom d'utilisateur" required>
            </div>
            <div class="mb-4">
                <label for="password" class="form-label">Mot de passe</label>
                <input type="password" class="form-control" id="password" placeholder="Entrez votre mot de passe" required>
            </div>
            <div class="mb-4 form-check">
                <input type="checkbox" class="form-check-input" id="rememberMe">
                <label class="form-check-label" for="rememberMe">Se souvenir de moi</label>
            </div>
            <div class="d-grid gap-2 mb-4">
                <button type="submit" class="btn btn-custom">Se connecter</button>
            </div>
        </form>
        <div class="text-center mt-4">
            <a href="index.html" class="text-decoration-none"><i class="fas fa-arrow-left me-2"></i>Retour à l'accueil</a>
        </div>
    </div>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
<script>

    document.getElementById('loginForm').addEventListener('submit', function(e) {
        e.preventDefault();

        alert('Tentative de connexion avec: ' + document.getElementById('username').value);


    });
</script>
</body>
</html>