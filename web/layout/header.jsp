<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bèl Paryaj</title>
    <link href="${pageContext.request.contextPath}/ressources/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/ressources/css/bootstrap-icons.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/ressources/css/datatables.min.css" rel="stylesheet" type="text/css"/>
  </head>
  <body>


<!-- Barre de connexion -->
<ul class="container-fluid mb-0 ">
  <div class="nav justify-content-end bg-danger  container">
    <li class="nav-item dropdown navbar-expand-md text-center ">         
        <a href="#" class="nav-link dropdown-toggle f-inline bg-light" role="button" data-bs-toggle="dropdown" aria-expanded="false">
          <span class="bi bi-translate"></span>
          <span class="collapse navbar-collapse pad-left">Option</span>
        </a>
        <ul class="dropdown-menu dropdown-menu-dark">
          <li><a class="dropdown-item" href="?lang=Creole">Déconnecter</a></li>
          <li><a class="dropdown-item"href="?lang=Francais">Francais</a></li>
          <li><a class="dropdown-item" href="?lang=English">English</a></li>
        </ul>
    </li>
  </div>
</ul>

<!-- Barre de titre -->      
<div class="container-fluid bg-dark ms-0 me-0">
<header class="p-3 text-bg-dark">
    <div class="container">
      <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
        <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
        <span class=""><img class="image-ronde" src="<?php echo $path; ?>images/SC-Logo-Web-350x350.jpg" alt="logo"></span>
        </a>
          
        <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
          <li><a href="<?php echo $path?>index.php" class="nav-link px-2 text-secondary">Accueil</a></li>
          <li><a href="<?php echo $path?>index.php" class="nav-link px-2 text-secondary">Compte</a></li>
          <li><a href="<?php echo $path?>index.php" class="nav-link px-2 text-secondary">Matche</a></li>
          <li><a href="<?php echo $path?>index.php" class="nav-link px-2 text-secondary">Pariage</a></li>
          <li><a href="<?php echo $path?>index.php" class="nav-link px-2 text-secondary">Paiement</a></li>
          <li class="dropdown"><a href="#" class="nav-link px-2 text-white dropdown-toggle dropdown-toggle" role="button" data-bs-toggle="dropdown" aria-expanded="false">A propos</a>
          <ul class="dropdown-menu dropdown-menu-dark">          
              <li><a class="dropdown-item" href="<?php echo $path;?>learn_computer_science/learn_cs.php">TESS</a></li>              
              <li><a class="dropdown-item"href="#"><?php echo lang('cs_desktop');?></a></li>
              <li><a class="dropdown-item" href="<?php echo $path;?>subjects/html_css.php"><?php echo lang('html_css');?></a></li>
              <li><a class="dropdown-item" href="#"><?php echo lang('python');?></a></li>
              <li><a class="dropdown-item" href="#"><?php echo lang('java');?></a></li>
              <li><a class="dropdown-item" href="#"><?php echo lang('fdo');?></a></li>
        
         <li><hr class="dropdown-dividere"></li> 
            <li><a class="dropdown-item" href="#">Unlocking</a></li>
            <li><a class="dropdown-item" href="#">Bypass FRP</a></li>
            <li><a class="dropdown-item" href="#">Flash</a></li>
            <li><a class="dropdown-item" href="#">Root</a></li>
            <li><a class="dropdown-item" href="#">Crack</a></li>
            <li><a class="dropdown-item" href="#">Best tools</a></li>
          </ul>
        </li>
        </ul>

        <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" role="search">
          <input type="search" class="form-control form-control-dark text-bg-dark" placeholder="Search..." aria-label="Search">
        </form>

        <div class="text-end">
          <button type="button" class="btn btn-outline-light me-2">Se connecter</button>
          <a href="sign-up.php"><button type="button" class="btn btn-outline-danger">Inscription</button></a>
        </div>
      </div>
    </div>
  </header>
</div>
  
  