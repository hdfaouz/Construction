<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>XpertConstruction - Votre partenaire en construction</title>
  <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css" rel="stylesheet">
  <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" rel="stylesheet">
  <style>
    .hero-section {
      background: linear-gradient(rgba(0, 0, 0, 0.6), rgba(0, 0, 0, 0.6));
      height: 100vh;
      display: flex;
      align-items: center;
      color: white;
    }

    .service-card {
      transition: all 0.3s ease;
      border: none;
      border-radius: 8px;
      overflow: hidden;
    }

    .service-card:hover {
      transform: translateY(-10px);
      box-shadow: 0 15px 30px rgba(0, 0, 0, 0.1);
    }

    .service-icon {
      font-size: 3rem;
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

    .section-heading {
      position: relative;
      padding-bottom: 15px;
      margin-bottom: 30px;
    }

    .section-heading:after {
      content: '';
      position: absolute;
      bottom: 0;
      left: 50%;
      transform: translateX(-50%);
      width: 80px;
      height: 3px;
      background-color: #f8b500;
    }
    .count-box .count-number {
      font-size: 3rem;
      font-weight: 700;
      color: #f8b500;
    }
  </style>
</head>
<body>
<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark fixed-top bg-dark">
  <div class="container">
    <a class="navbar-brand" href="#">XpertConstruction</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav ms-auto">
        <li class="nav-item">
          <a class="nav-link active" href="#accueil">Accueil</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#services">Services</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#propos">A propos</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="Login.jsp" id="loginNav">Login</a>
        </li>
      </ul>
    </div>
  </div>
</nav>


<section class="hero-section" id="accueil">
  <div class="container text-center">
    <h1 class="display-3 fw-bold mb-4">Construisez votre avenir avec XpertConstruction</h1>
    <p class="lead mb-5">Specialistes en construction residentielle et commerciale depuis plus de 25 ans</p>
    <div class="d-flex justify-content-center">
      <a href="#contact" class="btn btn-custom me-3">Demandez un devis</a>
      <a href="#projets" class="btn btn-outline-light">Voir nos projets</a>
    </div>
  </div>
</section>


<section class="py-5" id="services">
  <div class="container py-5">
    <h2 class="text-center section-heading">Nos Services</h2>
    <div class="row g-4">
      <div class="col-md-4">
        <div class="card service-card h-100">
          <div class="card-body text-center p-4">
            <div class="service-icon mb-4">
              <i class="fas fa-home"></i>
            </div>
            <h3 class="card-title h4">Construction residentielle</h3>
            <p class="card-text">Des maisons individuelles aux immeubles residentiels, nous creons des espaces de vie qui durent.</p>
          </div>
        </div>
      </div>
      <div class="col-md-4">
        <div class="card service-card h-100">
          <div class="card-body text-center p-4">
            <div class="service-icon mb-4">
              <i class="fas fa-building"></i>
            </div>
            <h3 class="card-title h4">Construction commerciale</h3>
            <p class="card-text">Bureaux, magasins, restaurants - nous construisons des espaces commerciaux fonctionnels et attrayants.</p>
          </div>
        </div>
      </div>
      <div class="col-md-4">
        <div class="card service-card h-100">
          <div class="card-body text-center p-4">
            <div class="service-icon mb-4">
              <i class="fas fa-tools"></i>
            </div>
            <h3 class="card-title h4">Rénovation</h3>
            <p class="card-text">Transformez votre espace existant avec nos services de rénovation de qualité supérieure.</p>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>

<!-- About Section -->
<section class="py-5 bg-light" id="propos">
  <div class="container py-5">
    <div class="row align-items-center">
      <div class="col-lg-6">
      </div>
      <div class="col-lg-6 mt-4 mt-lg-0">
        <h2 class="section-heading">À propos de XpertConstruction</h2>
        <p>Fondee en 1998, XpertConstruction s'est batie une reputation d'excellence dans l'industrie de la construction. Notre mission est de creer des espaces qui inspirent, fonctionnent et durent.</p>
        <p>Avec une équipe d'experts passionnés et un engagement envers la qualité, nous sommes devenus un leader de confiance dans le secteur de la construction.</p>
        <div class="d-flex mt-4">
          <div class="me-4">
            <h4 class="h5">Notre Mission</h4>
            <p>Fournir des services de construction de qualité supérieure qui dépassent les attentes de nos clients.</p>
          </div>
          <div>
            <h4 class="h5">Notre Vision</h4>
            <p>Être reconnu comme le constructeur de premier choix pour les projets de construction innovants et durables.</p>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>

<footer class="bg-dark text-white-50 py-4">
  <div class="container">
    <div class="row">
      <div class="col-md-6">
        <p class="mb-0">&copy; 2025 XpertConstruction. Tous droits réservés.</p>
      </div>
      <div class="col-md-6 text-md-end">
        <a href="#" class="text-white-50 me-3">Politique de confidentialité</a>
        <a href="#" class="text-white-50">Mentions légales</a>
      </div>
    </div>
  </div>
</footer>

<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
<script>

  document.getElementById('loginNav').addEventListener('click', function(e) {
    e.preventDefault();
    window.location.href = 'login.html';
  });
</script>
</body>
</html>