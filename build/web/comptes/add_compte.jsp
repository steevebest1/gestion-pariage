
<%@include  file="../layout/headerOut.jsp"%>
<div class="wrapper">
    <div class="container mt-1 mb-1">
        <form method="POST" action="${pageContext.request.contextPath}/ComptesServlet?operation=add">
            <h3>INSCRIPTION</h3>
            <div class="container-fluid mb-2">
                <p class='' style="color: red;">
                    <%= session.getAttribute("msg") != null? session.getAttribute("msg"):"" %>
                    <% session.removeAttribute("msg"); %>
                    <%= request.getParameter("msg") != null? request.getParameter("msg"):"" %>
                </p>
            </div>
            <div class="form-row">
                <div class="form-wrapper">
                    <label for="">Nom *</label>
                    <input type="text" name="nom" class="form-control" required>
                </div>
                <div class="form-wrapper">
                    <label for="">Prénom *</label>
                    <input type="text" name="prenom" class="form-control" required>
                </div>
            </div>
            <div class="form-row last">
                <div class="form-wrapper">
                    <label for="">Sexe *</label>
                    <select id="" name="sexe" class="form-control" required>
                        <option value="M" selected disabled>Votre choix</option>
                        <option value="M">Masculin</option>
			<option value="F">Féminin</option>
                    </select>
                    <i class="zmdi zmdi-chevron-down"></i>
                </div>
                <div class="form-wrapper">
                    <label for="">Adresse</label>
                    <input type="text" name="adresse" class="form-control" >
                </div>
            </div>
            <div class="form-row">
                <div class="form-wrapper">
                    <label for="">Lieu de naissance</label>
                    <input type="text" name="pob" class="form-control" >
                </div>
                <div class="form-wrapper">
                    <label for="">Date de naissance</label>                    
                    <input type="date" name="dob" class="form-control" required >
                    </div>
            </div>
            <div class="form-row last">
                <div class="form-wrapper">
                    <label for="">Téléphone (+509) *</label>
                    <input type="number" name="phone" class="form-control" required="">
                </div>
                <div class="form-wrapper">
                    <label for="">Nif/Cin *</label>
                    <input type="number" name="nif_cin" class="form-control" required>
                </div>
            </div>
            <div class="form-row last">
                <div class="form-wrapper">
                    <label for="">Nom d'utilisateur *</label>
                    <input type="text" name="username" class="form-control" required>
                </div>
                <div class="form-wrapper">
                    <label for="">Mot de passe *</label>
                    <input type="text" name="pass" class="form-control" required>
                </div>
            </div>
            <button data-text="S'incrire">
                <span>Valider</span>
            </button>
        </form>
    </div>
</div>
<%@include  file="../layout/script.jsp"%>
<%@include  file="../layout/footer.jsp"%>
