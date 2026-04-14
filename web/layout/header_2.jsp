<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="sb.chcl.belparyaj.model.ComptesModel"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bèl Paryaj</title>
    <link href="${pageContext.request.contextPath}/ressources/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/ressources/css/bootstrap-icons.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/ressources/css/datatables.min.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/ressources/form/fonts/linearicons/style.css">
    <!-- MATERIAL DESIGN ICONIC FONT -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/ressources/form/fonts/material-design-iconic-font/css/material-design-iconic-font.min.css">
    <!-- DATE-PICKER -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/ressources/form/vendor/date-picker/css/datepicker.min.css">
    <!-- STYLE CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/ressources/form/css/style.css">
  </head>
  <body class="bg-dark">


<!-- Barre de connexion -->
<div class="container-fluid">
    <ul class="container-fluid mb-0 ms-0 me-0" style="background-color:firebrick">
      <div class="nav justify-content-end  container">
        <li class="nav-item dropdo navbar-expand-m text-center ">         
            <a href="#" class="nav-link dropdown-toggle f-inline bg-dark" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                <span class="btn collap pad-left btn-outline-warning"><%= ((ComptesModel)session.getAttribute("userInfo")).getUsername() %></span>
                <span class="btn  pad-left btn-outline-warning ms-1"><%= ((ComptesModel)session.getAttribute("userInfo")).getSolde() %> Gdes</span>
            </a>
            <ul class="dropdown-menu dropdown-menu-dark">
              <li><a class="dropdown-item" href="?lang=Creole"></a>Mon compte</li>
              <li><a class="dropdown-item"href="?lang=Francais">Déconnection</a></li>
            </ul>
        </li>
      </div>
    </ul>
</div>
<!-- Barre de titre -->      
<div class="container-fluid bg-dark ms-0 me-0">
    <header class="p-3 text-bg-dar" style="background-color:#ffc107">
    <div class="container">
      <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start pe">
        <a href="${pageContext.request.contextPath}/index.jsp" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none me-3">
        <span class=""><img class="img-fluid" src="${pageContext.request.contextPath}/ressources/images/logo.png" alt="logo"></span>
        </a>

        <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0 ms-5">
            <li class="btn"><a href="${pageContext.request.contextPath}/index.jsp" class="nav-link px-2 text-secondary">Accueil</a></li>
          <li class="btn"><a href="${pageContext.request.contextPath}/comptes/view_compte.jsp" class="nav-link px-2 text-secondary">Mon compte</a></li>
          
          <%
              if(((ComptesModel)session.getAttribute("userInfo")).getType_compte().equalsIgnoreCase("admin")){
          %>
          <li class="btn"><a href="${pageContext.request.contextPath}/comptes/index.jsp" class="nav-link px-2 text-secondary">Comptes</a></li>
          <li class="btn"><a href="${pageContext.request.contextPath}/matches/index.jsp" class="nav-link px-2 text-secondary">Matches</a></li>
          <%}%>
          <li class="btn"><a href="${pageContext.request.contextPath}/pariages/index.jsp" class="nav-link px-2 text-secondary">Pariages</a></li>
          <%
              if(((ComptesModel)session.getAttribute("userInfo")).getType_compte().equalsIgnoreCase("admin")){
          %>
          <li class="btn"><a href="${pageContext.request.contextPath}/paiements/index.jsp" class="nav-link px-2 text-secondary">Paiements</a></li>
          <%}%>
        </ul>

        

        <div class="text-end">
            <!--<button type="button" class="btn me-2" style="background-color: #a10000">Se connecter</button>-->
          <a href="${pageContext.request.contextPath}/LoginServlet"><button type="button" class="btn btn-outline-danger me-0">Déconnexion</button></a>
        </div>
      </div>
    </div>
  </header>
</div>
  
  