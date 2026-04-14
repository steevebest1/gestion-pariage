<%if(session.getAttribute("userInfo")==null){%>
<%@include  file="layout/header_1.jsp"%>
<%}else{%>
<%@include  file="layout/header_2.jsp"%>
<%}%>
<div class="mb-2"></div>
<div class="container">
<!-- Div qui englobe les deux parties de Carousel -->
<div class="container-fluid row p-0 m-0 bg-light">
<!-- Div qui englobe les deux parties de Carousel -->
<div class="container-fluid row p-0 m-0 bg-light">  
  <!-- Carousel de gauche -->
  <div class="col-lg-6 col-sm-12 col-md-6 p-1">
<div id="myCarousel1" class="carousel slide mt-2" data-bs-ride="carousel">    
    <div class="carousel-inner">
      <div class="carousel-item active">
        <img src="ressources/images/parie.jpg" alt="" class="d-block w-100">
        <div class="container">
        <div class="carousel-caption text-start text-white text-center p-3">
            <!-- Stevenson Constant</h1> 
            <p>Étudiant en Sciences Informatiques à l'UEH</p><h1>
            <p class=""><a class="btn btn-lg btn-primary btn-danger" href="#">S'inscrire maintenant</a></p>-->
            
            
          </div>
        </div>
      </div>     
    </div>
  </div>
  </div><!-- Fin dil col carousel de gauche-->

  <!-- Carousel de droite -->
  <div class="col-lg-6 col-sm-12 col-md-6 p-1">
<div id="myCarousel" class="carousel slide mt-2" data-bs-ride="carousel">
    <div class="carousel-indicators">
      <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
      <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="1" aria-label="Slide 2"></button>
      <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="2" aria-label="Slide 3"></button>
      <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="3" aria-label="Slide 4"></button>
      <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="4" aria-label="Slide 5"></button>
      <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="5" aria-label="Slide 6"></button>
      <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="6" aria-label="Slide 7"></button>
      <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="7" aria-label="Slide 8"></button>
      <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="8" aria-label="Slide 9"></button>
      
    </div>
    <div class="carousel-inner">
        
      <div class="carousel-item active">
          <img src="ressources/images/femme.avif" alt="" class="d-block w-100">
        <div class="container">
        <div class="carousel-caption text-start text-white text-center p-3">
            <h1 class="">Devenez riche</h1>
            <p>Visez les meilleurs</p>
            <p><a class="btn btn-lg btn-danger" href="#">Parier maintenant</a></p>
          </div>
        </div>
      </div>
        
      <div class="carousel-item">
      <img src="ressources/images/Messi2.jpg" alt="" class="d-block w-100">
        <div class="container">
          <div class="carousel-caption">
          </div>
        </div>
      </div>
        
      <div class="carousel-item">
      <img src="ressources/images/paris-sportifs.jpg" alt="" class="d-block w-100 ">
        <div class="container">
          <div class="carousel-caption  bg-dark">
            <h1>Gagner</h1>
            <p>toujours plus</p>
            <p><a class="btn btn-lg btn-primary" href="#">Contacter</a></p>
          </div>
        </div>
      </div>
        
        <div class="carousel-item">
      <img src="ressources/images/cr7.jpg" alt="" class="d-block w-100 ">
        <div class="container">
          </div>
      </div>
        
        <div class="carousel-item">
      <img src="ressources/images/paris-sportifs.jpg" alt="" class="d-block w-100 ">
        <div class="container">
          <div class="carousel-caption  bg-dark">
            <h1>Visez</h1>
            <p>toujours plus loin</p>
            <p><a class="btn btn-lg btn-danger" href="#">Score en direct</a></p>
        </div>
        </div>
      </div>
        
        <div class="carousel-item">
      <img src="ressources/images/Vini.jpeg" alt="" class="d-block w-100 ">
        <div class="container">
          <div class="carousel-caption">
          </div>
        </div>
      </div>
        
        <div class="carousel-item">
      <img src="ressources/images/score.jpg" alt="" class="d-block w-100 ">
        <div class="container">          
        </div>
      </div>
        
        <div class="carousel-item">
      <img src="ressources/images/cccr7.jpg" alt="" class="d-block w-100 ">
        <div class="container">
        </div>
      </div>
        
        <div class="carousel-item">
      <img src="ressources/images/Kylian-Mbappe.jpg" alt="" class="d-block w-100 ">
        <div class="container">
          <div class="carousel-caption  bg-dark">
          </div>
        </div>
      </div>
    </div>
    <button class="carousel-control-prev" type="button" data-bs-target="#myCarousel" data-bs-slide="prev">
      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
      <span class="visually-hidden">Previous</span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#myCarousel" data-bs-slide="next">
      <span class="carousel-control-next-icon" aria-hidden="true"></span>
      <span class="visually-hidden">Next</span>
    </button>
  </div>
      <div class="container">
          <img class="img-fluid" src="ressources/images/result.webp" alt="alt"/>
      </div>
  </div><!-- Fin carousel de droite-->

</div> 
</div>
<%@include  file="layout/script.jsp"%>
<%@include  file="layout/footer.jsp"%>